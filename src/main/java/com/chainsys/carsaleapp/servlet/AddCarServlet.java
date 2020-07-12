package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.exception.ServiceException;
import com.chainsys.carsaleapp.model.CarDetail;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.service.CarDetailService;

@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CarDetailService cdi;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int sellerId = (Integer) session.getAttribute("login_seller_id");
		CarDetail carDetail = new CarDetail();
		int price = Integer.parseInt(request.getParameter("price"));
		carDetail.setPrice(price);
		int isowner = Integer.parseInt(request.getParameter("isowner"));
		carDetail.setIsOwner(isowner);
		String carName = request.getParameter("carName");
		carDetail.setCarName(carName);
		String carBrand = request.getParameter("carBrand");
		carDetail.setCarBrand(carBrand);
		String trType = request.getParameter("tr");
		carDetail.setTrType(trType);
		String fuelType = request.getParameter("fuel");
		carDetail.setFuelType(fuelType);
		String regState = request.getParameter("regState");
		carDetail.setRegState(regState);
		String carAvailableCity = request.getParameter("carAvailableCity");
		carDetail.setCarAvailableCity(carAvailableCity);
		int regYear = Integer.parseInt(request.getParameter("regYear"));
		carDetail.setRegYear(regYear);
		int drKm = Integer.parseInt(request.getParameter("drKm"));
		carDetail.setDrivenKm(drKm);
		String regNo = request.getParameter("regNo");
		carDetail.setRegistrationNo(regNo);
		String vid = request.getParameter("vid");
		String imageSrc = request.getParameter("image");
		carDetail.setVehicleIdNo(vid);
		CarOwner carOwner = new CarOwner();
		carOwner.setOwnerId(sellerId);
		carDetail.setCarOwner(carOwner);
		carDetail.setImageSrc(imageSrc);
		try {
			cdi.addCarDetail(carDetail);
			System.out.println("Add success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginIndex.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			System.out.println("Message:" + e.getMessage());
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddCar.jsp?errorMessage=" + e.getMessage());
			dispatcher.forward(request, response);

		}

	}

}
