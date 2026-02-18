package com.kirylliuss.weatherForecast.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({HttpClientErrorException.class, NoResourceFoundException.class})
    public String handleNotFoundException(){
        return "/error/404";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex){
        ex.getStackTrace();
        return "error/500";
    }
}
