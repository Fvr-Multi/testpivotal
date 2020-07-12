package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.model.CarDetail;
import com.chainsys.carsaleapp.service.CarDetailService;

@WebServlet("/SearchByBrandServlet")
public class SearchByBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CarDetailService cdi;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String carBrand = request.getParameter("carBrand");
		CarDetail cd = new CarDetail();
		cd.setCarBrand(carBrand);
		List<CarDetail> ar = new ArrayList<CarDetail>();
		try {
			ar = cdi.getCarDetail(carBrand);
			request.setAttribute("availableCar", ar);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SearchByBrand.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
