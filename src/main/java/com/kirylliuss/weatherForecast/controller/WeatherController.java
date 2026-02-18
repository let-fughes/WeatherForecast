package com.kirylliuss.weatherForecast.controller;

import com.kirylliuss.weatherForecast.dto.WeatherDto;
import com.kirylliuss.weatherForecast.service.OpenWeatherMapAPIService;
import com.kirylliuss.weatherForecast.service.WeatherBitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/v1/weather")
public class WeatherController {

    private final OpenWeatherMapAPIService openWeatherMapAPIService;
    private final WeatherBitService weatherBitService;

    public WeatherController(OpenWeatherMapAPIService openWeatherMapAPIService, WeatherBitService weatherBitService){
        this.openWeatherMapAPIService = openWeatherMapAPIService;
        this.weatherBitService = weatherBitService;
    }

    @GetMapping("/")
    public String getWeather(@RequestParam(defaultValue = "Minsk") String city, Model model){
        return handleWeatherRequest(city, model, "OpenWeather");
    }

    @GetMapping("/openweather")
    public String getWeatherByOpenWeatherMap(@RequestParam(defaultValue = "Minsk") String city, Model model){
        return handleWeatherRequest(city, model, "OpenWeather");
    }

    @GetMapping("/weatherbit")
    public String getWeatherByWeatherBit(@RequestParam(defaultValue = "Minsk") String city, Model model){
        return handleWeatherRequest(city, model, "WeatherbitAPI");
    }

    private String handleWeatherRequest(String city, Model model, String source) {
        if(source.equals("OpenWeather")){
            WeatherDto current = openWeatherMapAPIService.fetchWeather(city);

            List<WeatherDto> forecastList = openWeatherMapAPIService.fetchForecast(city);

            if (current == null) {
                return "error/404";
            }

            model.addAttribute("city", city);
            model.addAttribute("current", current);
            if (forecastList != null && !forecastList.isEmpty()) {
                model.addAttribute("dailyForecast", forecastList.stream()
                        .filter(i -> forecastList.indexOf(i) % 8 == 0)
                        .skip(1)
                        .limit(4)
                        .toList());
            }
        } else if(source.equals("WeatherbitAPI")){
            WeatherDto current = weatherBitService.fetchWeather(city);

            List<WeatherDto> forecastList = weatherBitService.fetchForecast(city).stream().limit(4).toList();

            model.addAttribute("city", city);
            model.addAttribute("current", current);
            model.addAttribute("dailyForecast", forecastList);
        }

        model.addAttribute("currentSourceName", source);

        return "weather";
    }

}