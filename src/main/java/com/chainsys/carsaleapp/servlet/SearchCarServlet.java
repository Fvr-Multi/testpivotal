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

/**
 * Servlet implementation class SearchCarServlet
 */
@WebServlet("/SearchCarServlet")
public class SearchCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CarDetailService cao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String carId = request.getParameter("carId");
		int car = Integer.parseInt(carId);
		System.out.println(carId);

		CarDetail cd = new CarDetail();
		cd.setCarId(car);

		try {
			List<CarDetail> lcd = cao.getCarDetailUseCarId(car);
			System.out.println(lcd.size());
			request.setAttribute("carDetail", lcd);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewFullDetail.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
