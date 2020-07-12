package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.model.CarDetail;
import com.chainsys.carsaleapp.service.CarDetailService;


@WebServlet("/CarRegNoValidateServlet")
public class CarRegNoValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CarDetailService coi;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CarDetail cd = new CarDetail();
		String regNo = request.getParameter("regNo");
		cd.setRegistrationNo(regNo);
		Integer alreadyRegistered = 0;

		try {
			boolean exists = coi.isCarAlreadyRegistered(regNo);
			if (exists) {
				alreadyRegistered = 1;
			}
			System.out.println(exists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println(alreadyRegistered);
		out.flush();

	}
}