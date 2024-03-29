import React, { useState } from 'react';
import { Button, Input } from '@chakra-ui/react';
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
            return await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/v1/getWeatherByCity?city=${location}`);
        } catch (e) {
            throw e;
        }
    }


    return (
        <div>
            <Input
                value={ location }
                onChange={(e) => setLocation(e.target.value)}
                placeholder='Enter city name or zip code'
                size='sm'
            />
            <Button colorScheme='teal' variant='outline' type="submit" onClick={ fetchWeatherData }>
                Get Weather
            </Button>
            {weather && (
                <div>
                    <h2>Weather in {weather.name}</h2>
                    <p>Temperature: {(weather.main.temp - 273.15).toFixed(2)} °C</p>
                    <p>Feels like: {(weather.main.feels_like - 273.15).toFixed(2)} °C</p>
                    <p>Weather description: {weather.weather[0].description}</p>
                </div>
            )}
        </div>
    );
}

export default WeatherApp;
