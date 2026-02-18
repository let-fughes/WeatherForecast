package com.kirylliuss.weatherForecast.dto.OpenWeatherMapAPI.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapResponse {

    @JsonProperty("name")
    private String city;

    @JsonProperty("coord")
    private Coords coords;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Sys sys;
    private long dt;


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Coords{
        private float lon;
        private float lat;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather{
        private String main;
        private String description;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main{
        private float temp;

        @JsonProperty("feels_like")
        private float feelsLike;

        private int pressure;
        private int humidity;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Wind{
        private float speed;
        private int deg;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sys{
        private long sunrise;
        private long sunset;
        private String country;
    }
}

