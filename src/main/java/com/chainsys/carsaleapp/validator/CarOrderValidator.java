package com.chainsys.carsaleapp.validator;

import org.springframework.stereotype.Component;

import com.chainsys.carsaleapp.exception.InfoMessages;
import com.chainsys.carsaleapp.exception.ValidatorException;
import com.chainsys.carsaleapp.model.CarOrder;

@Component
public class CarOrderValidator {
	public void validateOrderCarForSave(CarOrder carOrder) throws ValidatorException {
		if (carOrder.getBuyerContactNo() ==0) {
			throw new ValidatorException(InfoMessages.VALIDATE_CONTACT_NO);
		}
		if (carOrder.getBuyerName() == null || "".equals(carOrder.getBuyerName().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_NAME);
		}
		if (carOrder.getTestDrive() == null || "".equals(carOrder.getTestDrive().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_TESTDRIVE);
		}
		if (carOrder.getAddress1() == null || "".equals(carOrder.getAddress1().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_STREETNAME);
		}
		if (carOrder.getAddress2() == null || "".equals(carOrder.getAddress2().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_STREETNO);
		}
		if (carOrder.getCity() == null || "".equals(carOrder.getCity().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_CITY);
		}
		if (carOrder.getBuyerState() == null || "".equals(carOrder.getBuyerState().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_STATE);
		}
		if (carOrder.getPincode() == 0 || carOrder.getPincode() <= 0) {
			throw new ValidatorException(InfoMessages.VALIDATE_PINCODE);

		}
	}
}
