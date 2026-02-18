package com.kirylliuss.weatherForecast.mapper;

import com.kirylliuss.weatherForecast.dto.OpenWeatherMapAPI.response.OpenWeatherForecastResponse;
import com.kirylliuss.weatherForecast.dto.OpenWeatherMapAPI.response.OpenWeatherMapResponse;
import com.kirylliuss.weatherForecast.dto.WeatherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OpenWeatherMapper {

    @Mapping(source = "coords.lon", target = "lon")
    @Mapping(source = "coords.lat", target = "lat")
    @Mapping(source = "main.temp", target = "temp")
    @Mapping(source = "main.feelsLike", target = "feelsLike")
    @Mapping(source = "main.pressure", target = "pressure")
    @Mapping(source = "main.humidity", target = "humidity")
    @Mapping(source = "wind.speed", target = "speed")
    @Mapping(source = "wind.deg", target = "deg")
    @Mapping(source = "sys.sunrise", target = "sunrise")
    @Mapping(source = "sys.sunset", target = "sunset")
    @Mapping(source = "sys.country", target = "country")
    @Mapping(source = "weather", target = "main", qualifiedByName = "mapWeatherMain")
    @Mapping(source = "weather", target = "description", qualifiedByName = "mapWeatherDescription")
    WeatherDto toWeatherDto(OpenWeatherMapResponse response);

    @Named("mapWeatherMain")
    default String mapWeatherMain(List<OpenWeatherMapResponse.Weather> weather) {
        return (weather != null && !weather.isEmpty()) ? weather.get(0).getMain() : null;
    }

    @Named("mapWeatherDescription")
    default String mapWeatherDescription(List<OpenWeatherMapResponse.Weather> weather) {
        return (weather != null && !weather.isEmpty()) ? weather.get(0).getDescription() : null;
    }

    default List<WeatherDto> toWeatherDtoList(OpenWeatherForecastResponse forecastResponse) {
        if (forecastResponse == null || forecastResponse.getResponses() == null) {
            return Collections.emptyList();
        }

        return forecastResponse.getResponses().stream()
                .map(item -> {
                    WeatherDto dto = toWeatherDto(item);

                    if (forecastResponse.getCity() != null) {
                        dto.setCity(forecastResponse.getCity().getName());
                        dto.setCountry(forecastResponse.getCity().getCountry());

                        if (forecastResponse.getCity().getCoord() != null) {
                            dto.setLat(forecastResponse.getCity().getCoord().getLat());
                            dto.setLon(forecastResponse.getCity().getCoord().getLon());
                        }
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }
}