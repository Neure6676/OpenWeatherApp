package com.zhenyuan.OpenWeather.controller;

import com.zhenyuan.OpenWeather.service.IOpenWeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class OpenWeatherController {

    private IOpenWeatherService iOpenWeatherService;

    @GetMapping(value = "/getWeather")
    public ResponseEntity<?> getWeather(@RequestParam String location) {
        return ResponseEntity.ok(iOpenWeatherService.getWeather(location));
    }

}
