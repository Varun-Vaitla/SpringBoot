package com.example.Flight_Rest_project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightDto {
	private String gwFlightKey;
	private String carrier;
	private String flightNumber;
	private String fareType;
	private double totalAmount;

}
