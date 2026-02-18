package com.kirylliuss.weatherForecast.dto.Weatherbit.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherbitRootResponse {

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("country_code")
    private String countryCode;

    private float lat;
    private float lon;

    @JsonProperty("data")
    private List<WeatherbitDataResponse> data;
}