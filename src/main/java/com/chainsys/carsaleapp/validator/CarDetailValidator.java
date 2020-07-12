package com.chainsys.carsaleapp.validator;

import org.springframework.stereotype.Component;

import com.chainsys.carsaleapp.exception.InfoMessages;
import com.chainsys.carsaleapp.exception.ValidatorException;
import com.chainsys.carsaleapp.model.CarDetail;

@Component
public class CarDetailValidator {

	public void validateCarForSave(CarDetail carDetail) throws ValidatorException {
		if (carDetail.getCarName() == null || "".equals(carDetail.getCarName().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_CARNAME);
		}
		if (carDetail.getCarBrand() == null || "".equals(carDetail.getCarBrand().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_CARBRAND);
		}
		if (carDetail.getRegState() == null || "".equals(carDetail.getRegState().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_REGSTATE);
		}
		if (carDetail.getDrivenKm() == 0 ||carDetail.getDrivenKm()<=0) {
			throw new ValidatorException(InfoMessages.VALIDATE_DRIVENKM);
		}
		if (carDetail.getCarAvailableCity() == null || "".equals(carDetail.getCarAvailableCity().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_AVAILABLECITY);
		}
		if (carDetail.getRegistrationNo() == null || "".equals(carDetail.getRegistrationNo().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_REGISTRATION_NO);
		}
		if (carDetail.getVehicleIdNo() == null || "".equals(carDetail.getVehicleIdNo().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_VID_NO);
		}
		if (carDetail.getImageSrc() == null || "".equals(carDetail.getImageSrc().trim())) {
			throw new ValidatorException(InfoMessages.VALIDATE_IMAGESRC);
		}
	}

}
