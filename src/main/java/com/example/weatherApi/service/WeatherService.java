package com.example.weatherApi.service;
import java.text.MessageFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.weatherApi.model.domain.DBResult;
import com.example.weatherApi.model.domain.DBResultRepository;
import com.example.weatherApi.service.dto.Location;
import com.example.weatherApi.service.dto.WeatherDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {
	Location location = new Location();
	private final DBResultRepository dbResultRepository;
	public WeatherDto callGet(String queryString) {
		String url = MessageFormat.format("https://maps.googleapis.com/maps/api/geocode/json?address={0}&key={1}",
				queryString, "AIzaSyDV6J_lwZ8KtNQg_1DFdJLKQRPjrlxCm4E");
		return new RestTemplate().getForObject(url, WeatherDto.class);
	}
	public DBResult save(DBResult dbResult) {
		return dbResultRepository.save(dbResult);
	}
	public DBResult createResult(WeatherDto weatherDto) {
		DBResult dbResult = DBResult.builder().id(0).latitude(
				weatherDto.getResults()[0].getGeometry().getLocation().getLat())
				.longitude(weatherDto.getResults()[0].getGeometry().getLocation().getLng())
				.build();
		return dbResult;
	}
}

