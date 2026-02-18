package com.kirylliuss.weatherForecast.mapper;

import com.kirylliuss.weatherForecast.dto.WeatherDto;
import com.kirylliuss.weatherForecast.dto.Weatherbit.response.WeatherbitDataResponse;
import com.kirylliuss.weatherForecast.dto.Weatherbit.response.WeatherbitRootResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface WeatherbitMapper {

    @Mapping(source = "temp", target = "temp")
    @Mapping(source = "appMaxTemp", target = "feelsLike") // Используем app_temp как feels_like
    @Mapping(source = "windSpd", target = "speed")
    @Mapping(source = "ts", target = "dt")
    @Mapping(source = "weather.description", target = "description")

    WeatherDto toWeatherDto(WeatherbitDataResponse data);

    default List<WeatherDto> toDtoList(WeatherbitRootResponse root) {
        if (root == null || root.getData() == null) return Collections.emptyList();

        return root.getData().stream()
                .map(data -> {
                    WeatherDto dto = toWeatherDto(data);
                    dto.setCity(root.getCityName());
                    dto.setLat(root.getLat());
                    dto.setLon(root.getLon());
                    return dto;
                })
                .toList();
    }
}
