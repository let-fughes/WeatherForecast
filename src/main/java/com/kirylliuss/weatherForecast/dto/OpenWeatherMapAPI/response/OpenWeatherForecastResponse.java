package com.kirylliuss.weatherForecast.dto.OpenWeatherMapAPI.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherForecastResponse {

    @JsonProperty("list")
    private List<OpenWeatherMapResponse> responses;

    private City city;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class City {
        private String name;
        private String country;
        private OpenWeatherMapResponse.Coords coord;
    }
}
