package com.kirylliuss.weatherForecast.dto;

import lombok.Data;

import java.util.List;

@Data
public class ForecastDto {

    private List<WeatherDto> list;

    private City city;

    public static class City {
        private String name;
        private String country;
    }
}
