package com.zhenyuan.OpenWeather.controller;

import com.zhenyuan.OpenWeather.service.IGetWeatherByCityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ByCityController {

    private IGetWeatherByCityService iOpenWeatherService;

    @GetMapping(value = "/getWeatherByCity")
    public ResponseEntity<?> getWeatherByCity(@RequestParam String city) {
        return ResponseEntity.ok(iOpenWeatherService.getWeatherByCity(city));
    }

}
