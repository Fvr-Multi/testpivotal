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

import com.chainsys.carsaleapp.model.CarOrder;
import com.chainsys.carsaleapp.service.CarOrderService;

@WebServlet("/WhoOrderedMyCarSevlet")
public class WhoOrderedMyCarSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CarOrderService co;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int sellerId = (Integer) session.getAttribute("login_seller_id");
		try {
			List<CarOrder> li = co.getOrderedUserCar(sellerId);
			System.out.println("size:" + li.size());
			request.setAttribute("orderedlist", li);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WhoOrderedMyCar.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("WhoOrderedMyCar.jsp");
			dispatcher.forward(request, response);
		}

	}

}
