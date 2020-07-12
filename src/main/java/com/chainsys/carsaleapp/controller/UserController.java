package com.chainsys.carsaleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.carsaleapp.dto.Message;
import com.chainsys.carsaleapp.dto.ResultDTO;
import com.chainsys.carsaleapp.exception.ServiceException;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.service.CarOwnerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	CarOwnerService obj;

	@PostMapping("/Registration")
	public ResponseEntity<?> registration(@RequestBody CarOwner carOwner) {
		try {
			obj.addCarOwner(carOwner);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (ServiceException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/viewMyCar")
	public ResponseEntity<?> viewYourCar(@RequestParam(name = "mobileNo") long mobileNo) {
		List<CarOwner> li = null;
		try {
			li = obj.viewYourCar(mobileNo);
			return new ResponseEntity(li, HttpStatus.OK);
		} catch (ServiceException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("/RemoveCar")
	public ResponseEntity removeCar(@RequestParam(name = "carOwnerId") Integer carOwnerId,
			@RequestParam(name = "carId") Integer carId) {
		try {
			obj.deleteCarDetail(carOwnerId, carId);
			return new ResponseEntity(HttpStatus.OK);
		} catch (ServiceException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/VerifyUser")

	public ResponseEntity<?> VerifyUser(@RequestParam(name = "mobileNo") long mobileNo) {
		
		try {
		boolean	exist = obj.isCarOwnerAlreadyRegistered(mobileNo);
			System.out.println(exist);
			ResultDTO result = new ResultDTO(exist);
			if(exist) {
			return new ResponseEntity<>(result, HttpStatus.FOUND);
			}
			else {
				return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
			}
		} catch (ServiceException e) {
			Message msg = new Message();
			e.printStackTrace();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/updatePrice")
	public ResponseEntity updatePrice(@RequestBody CarOwner carOwner) {
		try {
			obj.updateCarPrice(carOwner);
			return new ResponseEntity(HttpStatus.OK);
		} catch (ServiceException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_MODIFIED);
		}

	}
}
