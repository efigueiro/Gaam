package com.gaam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCustomerController
 */
@WebServlet("/createCustomer")
public class CreateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String status = (String) request.getParameter("status");
		String name = (String) request.getParameter("name");
		String phone = (String) request.getParameter("phone");
		String address = (String) request.getParameter("address");
		String cpf = (String) request.getParameter("cpf");
		String rg = (String) request.getParameter("rg");
		String insuranceCompany = (String) request.getParameter("insuranceCompany");
		String insuranceCompanyIdentification = (String) request.getParameter("insuranceCompanyIdentification");
		String observation = (String) request.getParameter("observation");
		
		
	}

}
