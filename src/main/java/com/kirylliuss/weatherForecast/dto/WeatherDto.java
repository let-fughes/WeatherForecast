package com.kirylliuss.weatherForecast.dto;

import lombok.Data;

@Data
public class WeatherDto {
    private long dt;
    private String city;
    private float lon;
    private float lat;
    private String main;
    private String description;
    private float temp;
    private float feelsLike;
    private int pressure;
    private int humidity;
    private float speed;
    private int deg;
    private long sunrise;
    private long sunset;
    private String country;
}
