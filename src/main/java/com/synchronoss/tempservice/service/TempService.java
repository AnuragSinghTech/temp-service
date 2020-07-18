package com.synchronoss.tempservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.synchronoss.tempservice.exception.CustomException;
import com.synchronoss.tempservice.pojo.Temperature;
import com.synchronoss.tempservice.repository.TempRepository;

@Service
public class TempService {
	@Autowired
	private TempRepository tempRepo;

	public Temperature getTempDetails(String city)
			throws CustomException, JsonMappingException, JsonProcessingException {
		return tempRepo.getWeatherDetails(city);
	}

}
