package com.zhenyuan.OpenWeather.service;

import org.springframework.http.ResponseEntity;

public interface IOpenWeatherService {
    String getWeather(String location);
}
