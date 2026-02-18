package com.kirylliuss.weatherForecast.service;

import com.kirylliuss.weatherForecast.dto.ForecastDto;
import com.kirylliuss.weatherForecast.dto.OpenWeatherMapAPI.response.OpenWeatherForecastResponse;
import com.kirylliuss.weatherForecast.dto.OpenWeatherMapAPI.response.OpenWeatherMapResponse;
import com.kirylliuss.weatherForecast.dto.WeatherDto;
import com.kirylliuss.weatherForecast.mapper.OpenWeatherMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class OpenWeatherMapAPIService {

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.base_url}")
    private String baseUrl;

    @Value("${openweather.api.forecast.base_url}")
    private String forecastBaseUrl;

    private final RestTemplate restTemplate;

    private final OpenWeatherMapper mapper;

    public OpenWeatherMapAPIService(RestTemplate restTemplate, OpenWeatherMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public WeatherDto fetchWeather(String city) {
        try {
            String url = String.format("%s?q=%s&appid=%s&units=metric&lang=en",
                    baseUrl, city, apiKey);
            return mapper.toWeatherDto(restTemplate.getForObject(url, OpenWeatherMapResponse.class));
        } catch (Exception e) {
            return null;
        }
    }

    public List<WeatherDto> fetchForecast(String city) {
        try {
            String url = String.format("%s?q=%s&appid=%s&units=metric&lang=en",
                    forecastBaseUrl, city, apiKey);

            OpenWeatherForecastResponse rawResponse = restTemplate.getForObject(url, OpenWeatherForecastResponse.class);

            return mapper.toWeatherDtoList(rawResponse);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
