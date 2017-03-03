package com.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.weather.dao.WeatherDao;
import com.weather.model.WeatherData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "weatherdata")
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class WeatherController {

	@Autowired
	WeatherDao weatherDao;

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	@ApiOperation(value = "insert city weather data", notes = "returns ok if successful",response = HttpStatus.class)
	public @ResponseBody HttpStatus inputWeatherData(@RequestBody WeatherData input) {

		//weatherDao = new WeatherDaoImpl();
		weatherDao.insertData(input);
		
		
		return HttpStatus.CREATED;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ApiOperation(value = "test if service is up", notes = "test service",response = String.class)
	public String test(ModelMap input) {

		return "Service is UP.";
	}

}
