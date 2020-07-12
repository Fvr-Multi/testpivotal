
package com.chainsys.carsaleapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.exception.ServiceException;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.service.CarDetailService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Autowired
	CarDetailService cdi;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarOwner cs = new CarOwner();
		Long phNo = Long.parseLong(request.getParameter("mobileno"));
		String pass = request.getParameter("pass");
		cs.setContactNo(phNo);
		cs.setPassword(pass);
		int sellerId = 0;

		try {
			sellerId = cdi.getSellerId(cs.getContactNo(), cs.getPassword());

			System.out.println(sellerId);
			if (sellerId == 0) {
				throw new DbException("Invalid Login credential");
			} else if (sellerId != 0) {
				HttpSession session = request.getSession();
				session.setAttribute("login_seller_id", sellerId);
				// RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAllCar");
				// dispatcher.forward(request, response);
				response.sendRedirect("ViewAllCar");

			}
		} catch (ServiceException e) {
			e.printStackTrace();
			response.sendRedirect("Login.jsp?errorMessage=" + e.getMessage());
		} catch (DbException e) {
			// TODO Auto-generated catch block

		}

	}

}
