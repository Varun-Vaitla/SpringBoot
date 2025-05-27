package com.example.Flight_Rest_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Flight_Rest_project.dto.FlightDto;
import com.example.Flight_Rest_project.entity.FlightInfo;
import com.example.Flight_Rest_project.service.FlightService;

@RestController
public class FlightController {
	@Autowired
	FlightService service;
	@PostMapping("/api/flights/fetch-and-store")
	public ResponseEntity<List<FlightInfo>> insertAll(@RequestBody List<FlightDto> dtos)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.first(dtos));
		
	}
	@GetMapping("/api/flight/{flightNumber}")
	public ResponseEntity<List<FlightInfo>> find(@PathVariable String flightNumber)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.findByFlight(flightNumber));
	}
	@GetMapping("/api/flights")
	public ResponseEntity<List<FlightInfo>> sort(@RequestParam(defaultValue = "id")String[] price,@RequestParam(defaultValue = "false")boolean desc)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.sortBy(price,desc));
	}

}
