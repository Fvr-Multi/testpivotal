package com.chainsys.carsaleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.carsaleapp.dao.CarOrderDAO;
import com.chainsys.carsaleapp.dto.Message;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarOrder;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/order")
public class CarOrderController {
	@Autowired
	CarOrderDAO obj;

	@GetMapping("/getDeliveryDate")
	public ResponseEntity<?> getCarDeleveryDate(@RequestParam(name = "orderId") int orderId) {
		List<CarOrder> li = null;
		try {
			li = obj.findByOrderId(orderId);
			return new ResponseEntity(li, HttpStatus.OK);
		} catch (DbException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/orderCar")
	public ResponseEntity orderCar(@RequestBody CarOrder carOrder) {
		try {
			obj.save(carOrder);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (DbException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<?> getDeliveryCarDet(@PathVariable("orderId") int orderId) {
		CarOrder co = null;
		try {
			co = obj.findCarDeliveryDetail(orderId);
			return new ResponseEntity(co, HttpStatus.CREATED);
		} catch (DbException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/viewOrderedCar")
	public ResponseEntity<?> getOrderedCar(@RequestParam(name = "userId", required = false) Integer userId,
			@RequestParam(name = "sellerId", required = false) Integer sellerId) {
		List<CarOrder> li = null;
		try {
			if (userId != null) {

				li = obj.findByUserId(userId);
			} else if (sellerId != null) {
				li = obj.findBySellerId(sellerId);
			}
		} catch (DbException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(li, HttpStatus.OK);
	}

}
