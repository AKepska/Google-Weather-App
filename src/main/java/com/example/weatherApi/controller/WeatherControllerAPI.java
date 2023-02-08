package com.example.weatherApi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.weatherApi.service.dto.WeatherDto;
@RequestMapping(value = "/api/weather", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public interface WeatherControllerAPI {
	@GetMapping("/location/{locationQueryString}")
	ResponseEntity<WeatherDto> searchForLocation(@PathVariable String locationQueryString);
}
