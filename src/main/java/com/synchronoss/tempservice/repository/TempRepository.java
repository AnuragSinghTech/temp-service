package com.synchronoss.tempservice.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synchronoss.tempservice.exception.CustomException;
import com.synchronoss.tempservice.pojo.Temperature;

@Repository
public class TempRepository {
	public Temperature getWeatherDetails(String city)
			throws CustomException, JsonMappingException, JsonProcessingException {
		Map<String, Object> map = (HashMap<String, Object>) new RestTemplate().getForEntity(
				"https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ba2e26157dd2d87c9ac4ff1a959d8e8c",
				HashMap.class).getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(map.get("main"));
		Temperature temp = objectMapper.readValue(jsonString, Temperature.class);
		return temp;
	}
}
