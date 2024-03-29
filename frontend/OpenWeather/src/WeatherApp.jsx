import React, { useState } from 'react';
import {
    Flex,
    Box,
    Input,
    Stack,
    Button,
    Heading,
    Text,
    useColorModeValue,
    ListItem,
    List
} from '@chakra-ui/react'
import axios from "axios";


function WeatherApp() {

    const [ location, setLocation ] = useState("");
    const [ weather, setWeather ] = useState(null);

    const fetchWeatherData = async () => {
        getWeather().then(res => {
            setWeather(res.data)
        }).catch(err => {
            console.log(err)
        });
    };

    const getWeather = async () => {
        try {
            return await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/v1/getWeather?location=${location}`);
        } catch (e) {
            throw e;
        }
    }


    return (
        <div>
            <Flex
                minH={'100vh'}
                align={'center'}
                justify={'center'}
                bg={useColorModeValue('gray.50', 'gray.800')}>
                <Stack spacing={8} mx={'auto'} maxW={'lg'} py={12} px={6}>
                    <Stack align={'center'}>
                        <Heading fontSize={'4xl'} textAlign={'center'}>
                            OpenWeather
                        </Heading>
                        <Text fontSize={'lg'} color={'gray.600'}>
                            Made by Zhenyuan️
                        </Text>
                    </Stack>
                    <Input
                        value={ location }
                        onChange={(e) => setLocation(e.target.value)}
                        placeholder='Enter city name or zip code'
                        size='md'
                    />
                    <Button colorScheme='teal' variant='outline' type="submit" onClick={ fetchWeatherData }>
                        Get Weather
                    </Button>
                    {weather && (
                        <Box>
                            <Text
                                fontSize={{ base: '16px', lg: '18px' }}
                                color={useColorModeValue('yellow.500', 'yellow.300')}
                                fontWeight={'500'}
                                textTransform={'uppercase'}
                                mb={'4'}>
                                Weather in {weather.name}
                            </Text>

                            <List spacing={2}>
                                <ListItem>
                                    <Text as={'span'} fontWeight={'bold'}>
                                        Temperature:
                                    </Text>{' '}
                                    {(weather.main.temp - 273.15).toFixed(2)} °C
                                </ListItem>
                                <ListItem>
                                    <Text as={'span'} fontWeight={'bold'}>
                                        Feels like:
                                    </Text>{' '}
                                    {(weather.main.feels_like - 273.15).toFixed(2)} °C
                                </ListItem>
                                <ListItem>
                                    <Text as={'span'} fontWeight={'bold'}>
                                        Description:
                                    </Text>{' '}
                                    {weather.weather[0].description}
                                </ListItem>
                            </List>
                        </Box>
                    )}
                </Stack>
            </Flex>
        </div>
    );
}

export default WeatherApp;
