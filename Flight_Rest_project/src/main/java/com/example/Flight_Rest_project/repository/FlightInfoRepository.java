package com.example.Flight_Rest_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Flight_Rest_project.entity.FlightInfo;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Long> {

	List<FlightInfo> findByFlightNumber(String flightNumber);

}
