package com.chainsys.carsaleapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@Data
@ToString
public class CarOwner {
	private Integer ownerId;
	private String ownerName;
	private Long contactNo;
	private String address1;
	private Integer pincode;
	private String address2;
	private String city;
	private String state;
	private String password;
	private String email;
	private CarDetail carDetail;

}
