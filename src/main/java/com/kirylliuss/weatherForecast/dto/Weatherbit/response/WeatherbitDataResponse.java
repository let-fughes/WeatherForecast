package com.kirylliuss.weatherForecast.dto.Weatherbit.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherbitDataResponse {

    private double temp;

    @JsonProperty("app_max_temp")
    private float appMaxTemp;

    @JsonProperty("pres")
    private int pressure;

    @JsonProperty("rh")
    private int humidity;

    @JsonProperty("wind_spd")
    private float windSpd;

    private long ts;

    @JsonProperty("sunrise_ts")
    private long sunrise;

    @JsonProperty("sunset_ts")
    private long sunset;

    private WeatherbitWeatherDescription weather;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WeatherbitWeatherDescription {
        private String description;
        private String icon;
        private int code;
    }
}