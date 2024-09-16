package com.Idfoxes.Adapter.feign;

import com.Idfoxes.Adapter.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-service", url = "http://api.gismeteo.ru")
public interface WeatherServiceClient {
    @GetMapping("/current")
    WeatherResponse getWeather(@RequestParam("lat") String latitude, @RequestParam("lon") String longitude);
}