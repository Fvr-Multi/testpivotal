package com.chainsys.carsaleapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Message {

	private String errorMessage;
	
	private String infoMessage;
	
}
