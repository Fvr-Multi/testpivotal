package com.chainsys.carsaleapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.carsaleapp.dao.RtoDAO;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.exception.ServiceException;

@Service
public class RtoService {
	@Autowired
	RtoDAO rtoDAO;

	public boolean isCarAlreadyRegistered(String regNo) throws ServiceException {

		boolean exists = false;

		try {
			exists = rtoDAO.findByRegNo(regNo);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return exists;
	}

}
