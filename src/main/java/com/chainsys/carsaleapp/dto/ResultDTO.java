package com.chainsys.carsaleapp.dto;

import lombok.Data;

@Data
public class ResultDTO {

	public ResultDTO(Boolean valid) {
		this.valid = valid;
	}

	private Boolean valid;
}
