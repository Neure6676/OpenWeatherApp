package com.zhenyuan.OpenWeather.service;

public interface IOpenWeatherService {

    String getWeatherByCity(String city);

    String getWeatherByZipCode(String zipCode);
}
