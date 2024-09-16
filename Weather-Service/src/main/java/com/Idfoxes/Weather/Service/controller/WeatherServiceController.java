package com.Idfoxes.Weather.Service.controller;

import com.Idfoxes.Weather.Service.model.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherServiceController {

    @GetMapping("/current")
    public WeatherResponse getCurrentWeather(@RequestParam("lat") String latitude, @RequestParam("lon") String longitude) {
        WeatherResponse response = new WeatherResponse();
        response.setTemperature(28);
        return response;
    }
}