package com.chainsys.carsaleapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.carsaleapp.dao.CarOwnerDAO;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.exception.ServiceException;
import com.chainsys.carsaleapp.exception.ValidatorException;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.validator.CarOwnerValidator;

@Service
public class CarOwnerService {
	@Autowired
	CarOwnerValidator carValidator;
	@Autowired
	CarOwnerDAO carOwnerDAO;

	public void addCarOwner(CarOwner carOwner) throws ServiceException {
		try {
			carValidator.validateRegistationForSave(carOwner);
			carOwnerDAO.save(carOwner);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void deleteCarDetail(int carOwnerId, int carId) throws ServiceException {
		try {
			carOwnerDAO.delete(carOwnerId, carId);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<CarOwner> viewYourCar(long mobileNo) throws ServiceException {
		List<CarOwner> li = null;
		try {
			li = carOwnerDAO.findCar(mobileNo);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return li;
	}

	public void updateCarPrice(CarOwner carOwner) throws ServiceException {
		try {
			carOwnerDAO.updatePrice(carOwner);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}

	}

	public boolean isCarOwnerAlreadyRegistered(Long mobileNo) throws ServiceException {
		boolean exists = false;
		try {
			exists = carOwnerDAO.exists(mobileNo);
			System.out.println(exists);
			return exists;
	    	} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
	}
	public void updateStatus(CarOwner carOwner)throws ServiceException{
		try
		{
			carOwnerDAO.updateStatus(carOwner);
		}catch(DbException e)
		{
			e.printStackTrace();
			throw new ServiceException(e);
		}
		}
	public void mail()throws ServiceException
			{
		try
		{
			     carOwnerDAO.sentMail();
		}catch(DbException e)
		{
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
			}
}
