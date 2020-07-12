package com.chainsys.carsaleapp.validator;

import org.springframework.stereotype.Component;

import com.chainsys.carsaleapp.exception.InfoMessages;
import com.chainsys.carsaleapp.exception.ValidatorException;
import com.chainsys.carsaleapp.model.CarOwner;

@Component
public class CarOwnerValidator {
	public void validateRegistationForSave(CarOwner carOwner) throws ValidatorException {
		if (carOwner.getContactNo() == 0) {
			throw new ValidatorException(InfoMessages.VALIDATE_CONTACT_NO);
		}
		if (carOwner.getOwnerName() == null || "".equals(carOwner.getOwnerName().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_NAME);
		}
		if (carOwner.getAddress1() == null || "".equals(carOwner.getAddress1().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_STREETNAME);
		}
		if (carOwner.getAddress2() == null || "".equals(carOwner.getAddress2().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_STREETNO);
		}
		if (carOwner.getState() == null || "".equals(carOwner.getState().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_STATE);
		}

	}
}