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

import com.chainsys.carsaleapp.exception.ServiceException;
import com.chainsys.carsaleapp.model.CarDetail;
import com.chainsys.carsaleapp.service.CarDetailService;
/**
 * Servlet implementation class SearchCarByDrivenKmServlet
 */
@WebServlet("/SearchCarByDrivenKmServlet")
public class SearchCarByDrivenKmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	@Autowired
	CarDetailService cdi;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		
        String from= request.getParameter("fromKm");
		String to=request.getParameter("toKm");
	  int  startFrom= Integer.parseInt(from);
		Long endTo= Long.parseLong(to);
		System.out.println(startFrom);
		System.out.println(endTo);
		//CarDetail cd = new CarDetail();
		try {
			List<CarDetail> ar=cdi.getCarDetailByDrivenKm(startFrom, endTo);
			request.setAttribute("carDetail", ar);
			System.out.println(ar);
			System.out.println("size"+ar.size());
			RequestDispatcher dispatcher = request.getRequestDispatcher("SearchByDrivenKm.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			}
}
