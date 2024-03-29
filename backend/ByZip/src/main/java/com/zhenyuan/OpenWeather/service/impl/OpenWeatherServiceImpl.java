package com.zhenyuan.OpenWeather.service.impl;

import com.zhenyuan.OpenWeather.service.IOpenWeatherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
@Slf4j
public class OpenWeatherServiceImpl implements IOpenWeatherService {

    private static final String url = "https://api.openweathermap.org/data/2.5/weather";

    private static final String api_key = "1328a0774637ec53b00f218a93b8ebe0";

    private RestTemplate restTemplate;

    @Override
    public String getWeatherByCity(String city) {
        try {

            String fullUrl = String.format(url.concat("?q=%s").concat("&appid=%s"), city, api_key);

            ResponseEntity<String> response = restTemplate.exchange(fullUrl, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class);

            return response.getBody();

        } catch (Exception e) {
            log.error("Some thing went wrong when fetching weather data by city", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception when calling OpenWeather API",
                    e
            );
        }
    }

    @Override
    public String getWeatherByZipCode(String zipCode) {
        try {

            String fullUrl = String.format(url.concat("?zip=%s").concat("&appid=%s"), zipCode, api_key);

            ResponseEntity<String> response = restTemplate.exchange(fullUrl, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class);

            return response.getBody();

        } catch (Exception e) {
            log.error("Some thing went wrong when fetching weather data by zip code", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception when calling OpenWeather API",
                    e
            );
        }
    }
}
