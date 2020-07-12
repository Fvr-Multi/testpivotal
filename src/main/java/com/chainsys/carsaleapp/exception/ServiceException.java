package com.chainsys.carsaleapp.exception;

public class ServiceException extends Exception {

	public ServiceException(Throwable e) {
		super(e);
	}

	public ServiceException(String msg, Throwable e) {
		super(msg, e);
	}

	public ServiceException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
}
