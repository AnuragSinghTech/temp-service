package com.synchronoss.tempservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.synchronoss.tempservice.exception.CustomException;
import com.synchronoss.tempservice.pojo.Temperature;
import com.synchronoss.tempservice.service.TempService;

@RestController
public class TempController {

	@Autowired
	private TempService tempService;

	@GetMapping("cityTemperature")
	public ResponseEntity<Temperature> getItems(@RequestParam("city") String city)
			throws CustomException, JsonMappingException, JsonProcessingException {
		Temperature temp = tempService.getTempDetails(city);
		return new ResponseEntity<Temperature>(temp, HttpStatus.OK);
	}
}
