package com.chainsys.carsaleapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.carsaleapp.dao.CarOrderDAO;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.exception.ServiceException;
import com.chainsys.carsaleapp.exception.ValidatorException;
import com.chainsys.carsaleapp.model.CarOrder;
import com.chainsys.carsaleapp.validator.CarOrderValidator;

@Service
public class CarOrderService {
	@Autowired
	CarOrderDAO carOrderDAO;
	@Autowired
	CarOrderValidator carValidator;

	public void orderCar(CarOrder carOrder) throws ServiceException {
		try {
		carValidator.validateOrderCarForSave(carOrder);
			carOrderDAO.save(carOrder);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}

	}

	public List<CarOrder> getCarDeleveryDate(int orderId) throws ServiceException {
		List<CarOrder> col = null;
		try {
			col = carOrderDAO.findByOrderId(orderId);

		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return col;

	}

	public CarOrder getDeliveryCarDet(int orderId) throws ServiceException {
		CarOrder li = null;
		try {
			li = carOrderDAO.findCarDeliveryDetail(orderId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return li;

	}

	public void updateCarStatus(int carId) throws ServiceException {
		try {
			carOrderDAO.updateStatus(carId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}

	}

	public List<CarOrder> getOrderedCar(int userId) throws ServiceException {
		List<CarOrder> li = null;
		try {
			li = carOrderDAO.findByUserId(userId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return li;
	}

	public List<CarOrder> getOrderedUserCar(int sellerId) throws ServiceException {
		List<CarOrder> li = null;
		try {
			li = carOrderDAO.findBySellerId(sellerId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return li;

	}

	public List<CarOrder> viewYourPlacedCar(Long mobileNo) throws ServiceException {
		List<CarOrder> li = null;
		try {
			li = carOrderDAO.findByMobileNo(mobileNo);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return li;
	}

}
