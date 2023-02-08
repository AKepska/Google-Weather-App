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
	@Value("${locationQueryString}")
	private String queryString;
	private final WeatherService weatherService;

	@Override
	public void run(String... args) throws Exception {
		initStorage();
	}
	private void initStorage() {
		log.info("jfs-cloud-files initializing storage...");
		weatherService.callGet(queryString);
		weatherService.save(weatherService.createResult(weatherService.callGet(queryString)));
	}
}
