package com.example.Flight_Rest_project.entity;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.example.Flight_Rest_project.dto.FlightDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class FlightInfo {
	public FlightInfo(FlightDto dto) {
		this.carrier=dto.getCarrier();
		this.fareType=dto.getFareType();
		this.flightNumber=dto.getFlightNumber();
		this.gwFlightKey=dto.getGwFlightKey();
		this.totalAmount=dto.getTotalAmount();
		}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String gwFlightKey;
	private String carrier;
	private String flightNumber;
	private String fareType;
	private double totalAmount;

}
