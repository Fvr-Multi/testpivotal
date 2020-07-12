package com.chainsys.carsaleapp.exception;

import java.sql.SQLException;

public class DbException extends Exception {
	public DbException(String msg) {
		super(msg);
	}

	public DbException(String msg, Exception e) {
		super(msg,e);
	}

}
