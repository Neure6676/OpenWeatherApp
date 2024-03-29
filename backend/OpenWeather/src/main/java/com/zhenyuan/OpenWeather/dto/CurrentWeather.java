package com.zhenyuan.OpenWeather.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentWeather {

    private String temperature;

    private String feelsLike;

    private String Description;
}
