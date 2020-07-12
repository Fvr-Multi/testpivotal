package com.chainsys.carsaleapp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;
@JsonInclude(Include.NON_NULL)
@Data
@ToString
public class CarOrder {
	private Integer orderId;
	private String buyerName;
	private Long buyerContactNo;
	private  Integer carId;
	private Integer sellerId;
	private String testDrive;
	private String status;
	private Integer userId;
	private LocalDate orderedDate;
	private LocalDate deliveredDate;
	private String address1;
	private String address2;
	private Integer pincode;
	private String buyerState;
	private String city;
	private String carName;

}
