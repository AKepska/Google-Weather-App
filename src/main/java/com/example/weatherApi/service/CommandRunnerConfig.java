package com.example.weatherApi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunnerConfig implements CommandLineRunner {
	private final WeatherService weatherService;
	@Value("${locationQueryString}")
	private String queryString;

	@Override
	public void run(String... args) {
		initStorage();
	}

	private void initStorage() {
		log.info("Google API test call started...");
		weatherService.callGet(queryString);
		log.info("Google API test call finished...");
	}
}
