package com.chainsys.carsaleapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chainsys.carsaleapp.dao.RtoDAO;
import com.chainsys.carsaleapp.exception.DbException;
@Repository
public class RtoImp implements RtoDAO  {
	private static final Logger log = LoggerFactory.getLogger(RtoImp.class);
	
@Autowired
private DataSource dataSource;
	@Override
	public boolean findByRegNo(String regNo) throws DbException {
		boolean exists=false;
		String sql="select * from rto_db where reg_no=?";
		try(Connection con=dataSource.getConnection();PreparedStatement ps=con.prepareStatement(sql);)
		{
			ps.setString(1,regNo);
			try(ResultSet rs=ps.executeQuery();)
			{
				if(rs.next())
				{
					exists=true;
				}
			}
		} catch (SQLException e) {
			log.error("Invalid Car registration number",e);
			throw new DbException("invalid car registration number");
		}
		return exists;
	}

}
