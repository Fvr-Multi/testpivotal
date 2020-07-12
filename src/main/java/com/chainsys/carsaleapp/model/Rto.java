package com.chainsys.carsaleapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;
@JsonInclude(Include.NON_NULL)
@Data
@ToString
public class Rto {
	private Integer carId;
	private String regNo;
	private String vId;
	private String carName;
	private String carBrand;

}
