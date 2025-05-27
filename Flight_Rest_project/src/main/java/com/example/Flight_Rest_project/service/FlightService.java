package com.example.Flight_Rest_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Flight_Rest_project.dto.FlightDto;
import com.example.Flight_Rest_project.entity.FlightInfo;
import com.example.Flight_Rest_project.repository.FlightInfoRepository;


@Service
public class FlightService {
	@Autowired
	FlightInfoRepository repository;

	public List<FlightInfo> first(List<FlightDto> dtos) {
		List<FlightInfo> flightInfo =new ArrayList<FlightInfo>();
		for(FlightDto dto:dtos)
		{
			flightInfo.add(new FlightInfo(dto));
		}
		return repository.saveAll(flightInfo);
	}

	public List<FlightInfo> findByFlight(String flightNumber) {
		return repository.findByFlightNumber(flightNumber.trim());
		
	}

	public List<FlightInfo> sortBy(String[] price, boolean desc) {
		Sort sort=null;
		if(desc)
		{
			sort=Sort.by(price).descending();
		}
		else
		{
			sort=Sort.by(price).ascending();
		}
		List<FlightInfo> sortedList=repository.findAll(sort);
		return sortedList;
	}

}
