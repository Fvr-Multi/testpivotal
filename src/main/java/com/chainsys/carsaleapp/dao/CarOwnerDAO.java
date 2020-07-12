package com.chainsys.carsaleapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarOwner;

@Repository
public interface CarOwnerDAO {
	void save(CarOwner carOwner) throws DbException;

	void delete(int carOwnerId, int carId) throws DbException;

	public List<CarOwner> findCar(long mobileNo) throws DbException;

	void updatePrice(CarOwner carOwner) throws DbException;

	public boolean exists(Long mobileNo) throws DbException;

	void updateStatus(CarOwner carOwner) throws DbException;

	public void sentMail() throws DbException;
}
