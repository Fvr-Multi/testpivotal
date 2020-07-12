package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
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

@WebServlet("/SearchByCarPriceServlet")
public class SearchByCarPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CarDetailService co;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String price = request.getParameter("price");
		// String price=(String) request.getAttribut("price");
		// System.out.println(price);
		float pric = Float.parseFloat(price);
		CarDetail cd = new CarDetail();
		cd.setPrice((int) pric);
		List<CarDetail> ar = null;
		System.out.println(price);
		/*
		 * if(pric < 560000) { try { ar = co.getCarDetailBelowPrice(pric);
		 * request.setAttribute("carList", ar); System.out.println(price);
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("SearchByPrice.jsp");
		 * dispatcher.forward(request, response); } catch (Exception e) {
		 * e.printStackTrace(); } } if (pric > 56000) {
		 */
		try {
			ar = co.getCarDetailAbovePrice(pric);
			request.setAttribute("carList", ar);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SearchByPrice.jsp");
			dispatcher.forward(request, response);
			System.out.println(price);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
