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

    private static final String byCityUrl = "http://localhost:8081/api/v1/getWeatherByCity";

    private static final String byZipUrl = "http://localhost:8082/api/v1/getWeatherByZip";

    private RestTemplate restTemplate;

    @Override
    public String getWeather(String location) {
        try {

            boolean byZip = false;
            if (location.charAt(0) >= '0' && location.charAt(0) <= '9') {
                byZip = true;
            }

            String fullUrl;
            if (byZip) {
                // call byZip server
                fullUrl = String.format(byZipUrl.concat("?zip=%s"), location);
            } else {
                // call byCity server
                fullUrl = String.format(byCityUrl.concat("?city=%s"), location);
            }

            ResponseEntity<String> response = restTemplate.exchange(fullUrl, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class);

            return response.getBody();

        } catch (Exception e) {
            log.error("Some thing went wrong when connecting GetWeather services", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception when calling GetWeather services",
                    e
            );
        }
    }
}
