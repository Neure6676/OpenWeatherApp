package com.zhenyuan.OpenWeather.service;

import org.springframework.http.ResponseEntity;

public interface IOpenWeatherService {

    String getWeatherByCity(String city);

    String getWeatherByZipCode(String zipCode);
}
