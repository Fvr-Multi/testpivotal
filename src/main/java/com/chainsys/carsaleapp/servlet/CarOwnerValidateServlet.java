package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.service.CarOwnerService;

@WebServlet("/CarOwnerValidateServlet")
public class CarOwnerValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CarOwnerService coi;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CarOwner coo = new CarOwner();
		long phNo = Long.parseLong(request.getParameter("phoneNo"));
		coo.setContactNo(phNo);
		Integer alreadyRegistered = 0;
		try {
			boolean exists = coi.isCarOwnerAlreadyRegistered(phNo);
			if (exists) {
				alreadyRegistered = 1;
			} else {
				alreadyRegistered = 0;
			}
			System.out.println(exists);
		} catch (Exception e) {
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.println(alreadyRegistered);
		out.flush();

	}
}
