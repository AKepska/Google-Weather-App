package com.example.weatherApi.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherApi.service.WeatherService;
import com.example.weatherApi.service.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor

public class WeatherControllerImpl implements WeatherControllerAPI{
	private final WeatherService weatherService;
	public ResponseEntity<WeatherDto> searchForLocation(@PathVariable String locationQueryString){
		return ResponseEntity.ok(weatherService.callGet(locationQueryString));

	}
}
