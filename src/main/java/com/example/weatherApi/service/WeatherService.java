package com.example.weatherApi.service;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weatherApi.model.domain.DBResult;
import com.example.weatherApi.model.repository.DBResultRepository;
import com.example.weatherApi.service.dto.WeatherDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {
	@Value("${key}")
	private String key;
	private final DBResultRepository dbResultRepository;

	public WeatherDto callGet(String queryString) {
		String url = MessageFormat.format("https://maps.googleapis.com/maps/api/geocode/json?address={0}&key={1}",
				queryString, key);
		WeatherDto weatherDto = new RestTemplate().getForObject(url, WeatherDto.class);
		save(createResult(weatherDto));
		return weatherDto;
	}

	public DBResult save(DBResult dbResult) {
		return dbResultRepository.save(dbResult);
	}

	public DBResult createResult(WeatherDto weatherDto) {
		DBResult dbResult = DBResult.builder().latitude(
						weatherDto.getResults()[0].getGeometry().getLocation().getLat())
				.longitude(weatherDto.getResults()[0].getGeometry().getLocation().getLng())
				.build();
		return dbResult;
	}
}

