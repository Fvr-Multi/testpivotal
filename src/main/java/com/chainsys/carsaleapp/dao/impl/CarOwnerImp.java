package com.chainsys.carsaleapp.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.carsaleapp.dao.CarOwnerDAO;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarDetail;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.util.Mail;
import com.chainsys.carsaleapp.util.MailUtil;

@Repository
public class CarOwnerImp implements CarOwnerDAO {
	private static final Logger log = LoggerFactory.getLogger(CarDetailImp.class);
//	private static final Logger log = Logger.getInstance();
	private static final String seller_id = "seller_id";
	private static final String car_name = "car_name";
	private static final String car_id = "car_id";
	private static final String car_brand = "car_brand";
	private static final String registration_no = "registration_no";
	private static final String seller_name = "seller_name";
	private static final String reg_year = "reg_year";
	private static final String price = "price";
	private static final String driven_km = "driven_km";
	private static final String car_available_city = "car_available_city";
	private static final String vehicle_identification_no = "vehicle_identification_no";
	private static final String statuss = "status";
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	Mail mn;

	public boolean exists(Long mobileNo) throws DbException {
		boolean exists = false;
		// Connection con=null;
		String sqll = "select * from car_seller where seller_contact_no=? or seller_id=?";

		// Statement st=null;
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sqll);) {

			ps.setLong(1, mobileNo);
			ps.setLong(2, mobileNo);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exists = true;
				}
			}
		} catch (SQLException e) {
			throw new DbException("Phone number not Exists");
		}
		return exists;
	}

	public void save(CarOwner carOwner) throws DbException {
		// Connection con=null;
		// PreparedStatement pst=null;
		String sql = "insert into car_seller(seller_id,seller_name,seller_contact_no,user_password,address1,address2,city,seller_state,pincode,email_id)values(seller_id_sq.nextval,?,?,?,?,?,?,?,?,?)";
		try {
			Object[] params = { carOwner.getOwnerName(), carOwner.getContactNo(), carOwner.getPassword(),
					carOwner.getAddress1(), carOwner.getAddress2(), carOwner.getCity(), carOwner.getState(),
					carOwner.getPincode(), carOwner.getEmail() };
			int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows + "" + sql);
			/*
			 * try (Connection con = dataSource.getConnection(); PreparedStatement pst =
			 * con.prepareStatement(sql);) {
			 * 
			 * pst.setString(1, carOwner.getOwnerName()); pst.setLong(2,
			 * carOwner.getContactNo()); pst.setString(3, carOwner.getPassword());
			 * pst.setString(4, carOwner.getAddress1()); pst.setString(5,
			 * carOwner.getAddress2()); pst.setString(6, carOwner.getCity());
			 * pst.setString(7, carOwner.getState()); pst.setInt(8, carOwner.getPincode());
			 * 
			 * int row = pst.executeUpdate(); System.out.println(row);
			 * System.out.println(sql); } catch (SQLException e) { log.error(e); }
			 */

		} catch (Exception e) {
			throw new DbException("Registration Failed");
		}

	}

	public void delete(int carOwnerId, int carId) throws DbException {
		// TODO Auto-generated method stub
		// Connection con=null;
		// PreparedStatement ps=null;
		// PreparedStatement pst=null;
		String sqll = "select seller_id from car_seller where seller_id=?";

		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sqll);) {
			ps.setInt(1, carOwnerId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					int carSellerId = rs.getInt("seller_id");
					String sql = "delete from  car_detail where car_id=? and car_seller_id=? and lower(status)='available'";
					try (PreparedStatement pst = con.prepareStatement(sql);) {
						pst.setInt(1, carId);
						pst.setInt(2, carSellerId);
						int rows = pst.executeUpdate();
						System.out.println(rows);
					}
				}
			}
		} catch (SQLException e) {
			throw new DbException("unable to delete car");
		}
	}

	public List<CarOwner> findCar(long mobileNo) throws DbException {
		List<CarOwner> al = new ArrayList<CarOwner>();
		// Connection con=null;
		// PreparedStatement ps=null;
		String sql = "select * from car_seller s,car_detail c where (s.seller_contact_no=? or s.seller_Id=?) and s.seller_id=c.car_seller_id";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);)

		{
			/*
			 * String sql="select seller_id from car_seller where
			 * seller_contact_no="+mobileno+""; Statement st=con.createStatement();
			 */
			ps.setLong(1, mobileNo);
			ps.setLong(2, mobileNo);

			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					CarOwner c = new CarOwner();
					CarDetail cd = new CarDetail();
					c.setOwnerName(rs.getString(seller_name));
					c.setOwnerId(rs.getInt(seller_id));
					cd.setCarId(rs.getInt(car_id));
					cd.setCarAvailableCity(rs.getString(car_available_city));
					cd.setCarBrand(rs.getString(car_brand));
					cd.setCarName(rs.getString(car_name));
					cd.setDrivenKm(rs.getInt(driven_km));
					cd.setPrice(rs.getInt(price));
					cd.setRegistrationNo(rs.getString(registration_no));
					cd.setRegYear(rs.getInt(reg_year));
					cd.setVehicleIdNo(rs.getString(vehicle_identification_no));
					cd.setStatus(rs.getString(statuss));
					c.setCarDetail(cd);
					al.add(c);
				}

			}
		} catch (SQLException e) {
			throw new DbException("unable to view Car");
		}

		return al;
	}

	public void updatePrice(CarOwner carOwner) throws DbException {

		String sql = null;
		CarDetail carDetail = carOwner.getCarDetail();
		try (Connection con = dataSource.getConnection();) {

			if (carOwner.getOwnerId() != 0) {
				/*
				 * sql = "update car_detail cd set cd.price="+cardetail.getPrice()+"where car_id
				 * = "+cardetail.getCarId()+" and ( car_seller_id = "+carOwner.getownerId()+" or
				 * car_seller_id in ( select seller_id from car_seller where seller_contact_no
				 * ="+carOwner.getcontactNo()+"";
				 */
				sql = "update car_detail  set price=?,status=? where car_id =? and car_seller_id=?";
				try (PreparedStatement ps = con.prepareStatement(sql);) {
					ps.setFloat(1, carDetail.getPrice());
					ps.setString(2, carDetail.getStatus());
					ps.setInt(3, carDetail.getCarId());
					ps.setInt(4, carOwner.getOwnerId());
					int rs = ps.executeUpdate();
					log.info(rs + "Updated successFully");
				}
			} else if (carOwner.getContactNo() != 0) {
				sql = "update car_detail set price=?,status=? where car_id =? and car_seller_id in ( select seller_id from car_seller where seller_contact_no =?)";
				try (PreparedStatement ps = con.prepareStatement(sql);) {
					ps.setFloat(1, carDetail.getPrice());
					ps.setString(2, carDetail.getStatus());
					ps.setInt(3, carDetail.getCarId());
					ps.setLong(4, carOwner.getContactNo());
					int rs = ps.executeUpdate();
					log.info(rs + "Updated successFully");
				}
			} else {
				log.info("Failed to Upadate");
			}
		} catch (SQLException e) {
			throw new DbException("unable to retrive");
		}

	}

	@Override
	public void updateStatus(CarOwner carOwner) throws DbException {
		String sql = null;
		CarDetail carDetail = carOwner.getCarDetail();
		try (Connection con = dataSource.getConnection();) {

			if (carOwner.getOwnerId() != 0) {
				/*
				 * sql = "update car_detail cd set cd.price="+cardetail.getPrice()+"where car_id
				 * = "+cardetail.getCarId()+" and ( car_seller_id = "+carOwner.getownerId()+" or
				 * car_seller_id in ( select seller_id from car_seller where seller_contact_no
				 * ="+carOwner.getcontactNo()+"";
				 */
				sql = "update car_order set status=? where car_id =?";
				try (PreparedStatement ps = con.prepareStatement(sql);) {
					ps.setString(1, carDetail.getStatus());
					ps.setInt(2, carDetail.getCarId());
					int rs = ps.executeUpdate();
					log.info(rs + "Updated successFully");
				}
			} else if (carOwner.getContactNo() != 0) {
				sql = "update car_order set status=? where car_id =?";
				try (PreparedStatement ps = con.prepareStatement(sql);) {
					ps.setString(1, carDetail.getStatus());
					ps.setInt(2, carDetail.getCarId());
					int rs = ps.executeUpdate();
					log.info(rs + "Updated successFully");
				}
			} else {
				log.info("Failed to Upadate");
			}
		} catch (SQLException e) {
			throw new DbException("unable to retrive");
		}
	}

	/**
	 * @throws DbException
	 * @throws IOException
	 * 
	 */
	public void sentMail() throws DbException {
		String sql = null;
		sql = "select cs.email_id from  car_seller cs where cs.seller_id=(select u.user_id from car_order u where u.car_id=1001 and status='ordered')";
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			if (rs.next()) {
				String mail = rs.getString("email_id");
				System.out.println(mail);
				
		mn.send(mail, "comfirmation","update");
				 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
