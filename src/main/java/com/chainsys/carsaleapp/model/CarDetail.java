package com.chainsys.carsaleapp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;
@JsonInclude(Include.NON_NULL)
@Data
@ToString
public class CarDetail {
	private Integer carId;
	private String carBrand;
	private String carName;
	private String trType;
	private String fuelType;
	private String regState;
	private Integer regYear;
	private String registrationNo;
	private Integer drivenKm;
	private LocalDate updateDate;
	private  Integer price;
	private String status;
	private String carAvailableCity;
	private String imageSrc;
	private String vehicleIdNo;
	private Integer isOwner;
	private Long contactNo;
	private String password;

	private CarOwner carOwner;

}
