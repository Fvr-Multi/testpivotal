package com.chainsys.carsaleapp.dao;

import org.springframework.stereotype.Repository;

import com.chainsys.carsaleapp.exception.DbException;
@Repository
public interface RtoDAO {
 public boolean findByRegNo(String regNo)throws DbException;
}
