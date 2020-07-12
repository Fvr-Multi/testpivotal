package com.chainsys.carsaleapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.carsaleapp.dao.CarDetailDAO;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.exception.ServiceException;
import com.chainsys.carsaleapp.exception.ValidatorException;
import com.chainsys.carsaleapp.model.CarDetail;
import com.chainsys.carsaleapp.validator.CarDetailValidator;

@Service
public class CarDetailService {

	@Autowired
	CarDetailValidator carValidator;
	@Autowired
	CarDetailDAO carDetailDAO;

	public void addCarDetail(CarDetail carDetail) throws ServiceException {

		try {
			carValidator.validateCarForSave(carDetail);
			carDetailDAO.save(carDetail);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<CarDetail> getCarDetail(String carName) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findByCarName(carName);

		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;

	}

	public List<CarDetail> getDetailWithOwner(String carBrand) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findByCarBrand(carBrand);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> getUpdatedCar(String status) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.updateStatus(status);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> getCarDetail(String carName, String carBrand, String fuleType) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findByCarNameAndBrandAndFuelType(carName, carBrand, fuleType);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;

	}

	public List<CarDetail> getCarDetailAbovePrice(float max) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findByAbovePrice(max);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}
	public List<CarDetail> getCarDetailByDrivenKm(int from,Long to) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findByDrivenKmFromAndTo(from,to);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> getCarDetail(Float max, String carBrand) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findByMaxPriceAndCarBrand(max, carBrand);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> viewAllCar() throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findAll();
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;

	}

	public List<CarDetail> getCarDetailBelowPrice(Float max) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findAll();
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> getCarDetailAboveDrivenKm(int from, Long to) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findByDrivenKmFromAndTo(from, to);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;

	}

	public List<CarDetail> getCarDetailUseCarId(int carId) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.findOne(carId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public Integer getSellerId(Long mobileNo, String password) throws ServiceException {
		Integer id=null;
		try {
			id = carDetailDAO.findByMobileNoAndPassword(mobileNo, password);
		if(id==null)
		{
			throw new ServiceException("invalid Credential !!!");
		}
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return id;

	}

	public boolean isCarAlreadyRegistered(String regNo) throws ServiceException {

		boolean exists = false;

		try {
			exists = carDetailDAO.findByRegNo(regNo);
			} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return exists;
	}
}
