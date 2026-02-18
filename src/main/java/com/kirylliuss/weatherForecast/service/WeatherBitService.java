package com.kirylliuss.weatherForecast.service;

import com.kirylliuss.weatherForecast.dto.WeatherDto;
import com.kirylliuss.weatherForecast.dto.Weatherbit.response.WeatherbitRootResponse;
import com.kirylliuss.weatherForecast.mapper.WeatherbitMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class WeatherBitService {

    @Value("${weatherbit.api.key}")
    private String apiKey;

    @Value("${weatherbit.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;
    private final WeatherbitMapper mapper;

    public WeatherBitService(RestTemplate restTemplate, WeatherbitMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public List<WeatherDto> fetchForecast(String city){
        try{
            String request = String.format("%s?city=%s&key=%s&lang=en", baseUrl, city, apiKey);
            WeatherbitRootResponse rawResponse = restTemplate.getForObject(request, WeatherbitRootResponse.class);
            return mapper.toDtoList(rawResponse);
        } catch (Exception ex){
            System.err.println("Weatherbit error: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    public WeatherDto fetchWeather(String city) {
        List<WeatherDto> forecast = fetchForecast(city);
        return (forecast != null && !forecast.isEmpty()) ? forecast.get(0) : null;
    }
}
