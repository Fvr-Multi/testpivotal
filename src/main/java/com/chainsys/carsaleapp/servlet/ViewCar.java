package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.service.CarOwnerService;

@WebServlet("/ViewCar")
public class ViewCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CarOwnerService coi;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int sellerId = (Integer) session.getAttribute("login_seller_id");

		try {
			List<CarOwner> cars = coi.viewYourCar(sellerId);
			request.setAttribute("totalCar", cars);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCar.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
