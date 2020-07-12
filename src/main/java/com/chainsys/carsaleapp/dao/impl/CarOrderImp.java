package com.chainsys.carsaleapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chainsys.carsaleapp.dao.CarOrderDAO;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarOrder;

@Repository
public class CarOrderImp implements CarOrderDAO {
	// private static final Logger log = Logger.getInstance();
	private static final Logger log = LoggerFactory.getLogger(CarDetailImp.class);
	private static final String buyer_contact_number = "buyer_contact_number";
	private static final String status = "status";
	private static final String test_drive = "test_drive";
	private static final String delivered_date = "delivered_date";
	private static final String ordered_date = "ordered_date";
	private static final String order_id = "order_id";
	private static final String buyer_name = "buyer_name";
	private static final String buyer_state = "buyer_state";
	private static final String seller_id = "seller_id";
	private static final String car_name = "car_name";
	private static final String car_id = "car_id";
	private static final String user_id = "user_id";
	private static final String address1 = "address1";
	private static final String address2 = "address2";
	private static final String buyerState = "buyer_state";
	private static final String pincode = "pincode";
	private static final String city = "city";
	private static final String orderDate = "ordered_date";
	private static final String testDrive = "test_drive";
	private static final String statuss = "status";
	@Autowired
	private DataSource dataSource;

	public void save(CarOrder carOrder) throws DbException {
		String check = " select car_id  from car_detail where car_id = ?";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(check);) {
			ps.setInt(1, carOrder.getCarId());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					int carId = rs.getInt(car_id);
					String sql = "insert into car_order(order_id,buyer_name,buyer_contact_number,car_id,seller_id,test_drive,address1,address2,city,buyer_state,pincode,user_id)values(order_id_sq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
					System.out.println(sql);
					try (PreparedStatement pst = con.prepareStatement(sql);) {
						pst.setString(1, carOrder.getBuyerName());
						pst.setLong(2, carOrder.getBuyerContactNo());
						pst.setInt(3, carId);
						pst.setInt(4, carOrder.getSellerId());
						pst.setString(5, carOrder.getTestDrive());
						pst.setString(6, carOrder.getAddress1());
						pst.setString(7, carOrder.getAddress2());
						pst.setString(8, carOrder.getCity());
						pst.setString(9, carOrder.getBuyerState());
						pst.setInt(10, carOrder.getPincode());
						pst.setInt(11, carOrder.getUserId());
						int rows = pst.executeUpdate();
						System.out.println(rows);
						System.out.println(sql);
						updateStatus(carId);
				}
			}
		} 
		}catch (SQLException e) {
			log.error("unable to order the car!!", e);
			throw new DbException("unable to order the car!!", e);
		}
	}
 public Integer updateStatus(Integer carId) throws DbException{
	 String sql = "select status from car_order where car_id=?";
	 try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, carId);
			try (ResultSet rss = ps.executeQuery()) {
				if(rss.next())
				{
				String stat = rss.getString("status");
				String upsql = "update car_detail  set status=? where car_id=?";
				try (PreparedStatement pt = con.prepareStatement(upsql);) {
					pt.setString(1, stat);
					pt.setInt(2, carId);
					int uprs = pt.executeUpdate();
					System.out.println(uprs);
				}
			}
			}
		}catch(SQLException e)
	 {
			throw new DbException("unable to order the car!!", e);
	 }
	return carId;
	 
 }
	public List<CarOrder> findByOrderId(int orderId) throws DbException {
		List<CarOrder> lt = new ArrayList<CarOrder>();
		String sql = "select buyer_name ,order_id,car_id,delivered_date from car_order where order_id=?";

		try (Connection con = dataSource.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, orderId);
			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					CarOrder c = new CarOrder();
					c.setBuyerName(rs.getString(buyer_name));
					c.setOrderId(rs.getInt(order_id));
					c.setCarId(rs.getInt(car_id));
					Date d = rs.getDate(delivered_date);
					c.setDeliveredDate(d.toLocalDate());
					lt.add(c);
				}
			}
		} catch (SQLException e) {
			log.error("Sorry!!invalid orderId", e);
			throw new DbException("Sorry!!invalid orderId", e);
		}
		return lt;
	}

	public CarOrder findCarDeliveryDetail(int orderId) throws DbException {
		// TODO Auto-generated method stub
		// Connection con =null;
		// PreparedStatement pst=null;
		String sql = "select c.car_name ,d.delivered_date,d.buyer_name from car_order d,car_detail c where order_id=?  and c.car_id=d.car_id ";
		CarOrder cc = null;
		try (Connection con = dataSource.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			// LocalDate ld=LocalDate.parse(deliver);
			// Date da=Date.valueOf(ld);
			// pst.setDate(1,da);
			pst.setInt(1, orderId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					cc = new CarOrder();
					cc.setCarName(rs.getString(car_name));
					Date d = rs.getDate(delivered_date);
					cc.setDeliveredDate(d.toLocalDate());
					cc.setBuyerName(rs.getString(buyer_name));
				}
				System.out.println(sql);
			}
		} catch (SQLException e) {
			log.error("no cars found in this date");
			throw new DbException("no cars found in this date");
		}
		return cc;
	}

	@Override
	public void updateStatus(int carId) throws DbException {
	}

	@Override
	public List<CarOrder> findByUserId(int userId) throws DbException {
		String sql = "select * from car_order where user_id=?";
		List<CarOrder> ts = new ArrayList<CarOrder>();
		try (Connection con = dataSource.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					CarOrder cc = new CarOrder();
					// cc.setCarName(rs.getString(car_name));
					Date d = rs.getDate(delivered_date);
					cc.setDeliveredDate(d.toLocalDate());
					cc.setBuyerName(rs.getString(buyer_name));
					cc.setOrderId(rs.getInt(order_id));
					cc.setCarId(rs.getInt(car_id));
					cc.setSellerId(rs.getInt(seller_id));
					cc.setStatus(rs.getString(statuss));
					ts.add(cc);
				}
				System.out.println(sql);
			}
		} catch (SQLException e) {
			log.error("unable to get car details,check your input", e);
			throw new DbException("unable to get car details,check your input", e);
		}
		return ts;
	}

	public List<CarOrder> findBySellerId(int sellerId) throws DbException {
		String sql = "select * from car_order where seller_id=?";
		List<CarOrder> ts = new ArrayList<CarOrder>();
		try (Connection con = dataSource.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, sellerId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					CarOrder cc = new CarOrder();
					// cc.setCarName(rs.getString(car_name));
					Date d = rs.getDate(delivered_date);
					cc.setDeliveredDate(d.toLocalDate());
					cc.setBuyerName(rs.getString(buyer_name));
					cc.setAddress1(rs.getString(address1));
					cc.setAddress2(rs.getString(address2));
					cc.setOrderId(rs.getInt(order_id));
					cc.setBuyerState(rs.getString(buyerState));
					cc.setCity(rs.getString(city));
					cc.setStatus(rs.getString(statuss));
					cc.setCarId(rs.getInt(car_id));
					cc.setSellerId(rs.getInt(seller_id));
					cc.setUserId(rs.getInt(user_id));
					Date od = rs.getDate(orderDate);
					cc.setOrderedDate(od.toLocalDate());
					cc.setTestDrive(rs.getString(testDrive));
					cc.setPincode(rs.getInt(pincode));
					cc.setStatus(rs.getString(statuss));
					ts.add(cc);
				}
				log.info(sql);
			}
		} catch (SQLException e) {
			log.error("unable to retrive your car Information", e);
			throw new DbException("unable to retrive your car Information", e);

		}
		return ts;
	}

	public List<CarOrder> findByMobileNo(Long mobileNo) throws DbException {
		// Connection con = null;
		// PreparedStatement ps = null;
		List<CarOrder> ar = new ArrayList<CarOrder>();
		String sql = "select * from car_order where seller_id=(select seller_id from car_seller where seller_contact_no=?)";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setLong(1, mobileNo);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					CarOrder co = new CarOrder();
					co.setBuyerContactNo(rs.getLong(buyer_contact_number));
					co.setBuyerName(rs.getString(buyer_name));
					co.setCarId(rs.getInt(car_id));
					co.setOrderId(rs.getInt(order_id));
					co.setTestDrive(rs.getString(test_drive));
					Date d = rs.getDate(delivered_date);
					co.setDeliveredDate(d.toLocalDate());
					Date od = rs.getDate(ordered_date);
					co.setOrderedDate(od.toLocalDate());
					co.setAddress1(rs.getString(address1));
					co.setAddress2(rs.getString(address2));
					co.setBuyerState(rs.getString(buyer_state));
					co.setStatus(rs.getString(status));
					co.setPincode(rs.getInt(pincode));
					ar.add(co);
				}
			}
		} catch (SQLException e) {
			log.error("order failed", e);
			throw new DbException("order failed", e);
		}
		return ar;
	}

	/*
	 * public void updateCarStatus(int carId) throws DbException { // TODO
	 * Auto-generated method stub CarDetail c=new CarDetail(); Connection
	 * con=dataSource.getConnection(); String
	 * sql="update car_detail  set status='not available' where car_id=(select car_id from car_order where car_order.car_id=cardetail.?"
	 * ; PreparedStatement pst=con.prepareStatement(sql); pst.setInt(1,c.carId); int
	 * row=pst.executeUpdate(); System.out.println(row); }
	 */

}
