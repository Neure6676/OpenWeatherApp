package com.zhenyuan.OpenWeather.controller;

import com.zhenyuan.OpenWeather.service.IGetWeatherByZipService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ByZipController {

    private IGetWeatherByZipService iOpenWeatherService;

    @GetMapping(value = "/getWeatherByZip")
    public ResponseEntity<?> getWeatherByZipCode(@RequestParam String zip) {
        return ResponseEntity.ok(iOpenWeatherService.getWeatherByZipCode(zip));
    }

}
