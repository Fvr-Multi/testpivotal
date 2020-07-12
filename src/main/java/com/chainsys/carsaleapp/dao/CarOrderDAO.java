package com.chainsys.carsaleapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarOrder;

@Repository
public interface CarOrderDAO {
	public void save(CarOrder carOrder) throws DbException;

	public List<CarOrder> findByOrderId(int orderId) throws DbException;

	public CarOrder findCarDeliveryDetail(int orderId) throws DbException;

	public void updateStatus(int carId) throws DbException;

	public List<CarOrder> findByUserId(int userId) throws DbException;

	public List<CarOrder> findBySellerId(int sellerId) throws DbException;

	public List<CarOrder> findByMobileNo(Long mobileNo) throws DbException;

	public Integer updateStatus(Integer carId) throws DbException;
}