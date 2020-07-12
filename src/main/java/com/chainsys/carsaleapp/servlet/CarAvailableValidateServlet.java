package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.exception.ServiceException;
import com.chainsys.carsaleapp.service.CarOwnerService;
import com.chainsys.carsaleapp.service.RtoService;


@WebServlet("/CarAvailableValidateServlet")
public class CarAvailableValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	RtoService  rto;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String regNo=request.getParameter("regNo");
		Integer carAvailable = 0;
	try {
	boolean	exists=rto.isCarAlreadyRegistered(regNo);
		if(exists)
		{
			carAvailable=1;
		}
		else
		{
			carAvailable=0;
		}
	} catch (ServiceException e) {
		
		e.printStackTrace();
	}
	PrintWriter out = response.getWriter();
	out.println(carAvailable);
	out.flush();
	}

}
