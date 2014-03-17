package com.gaam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gaam.model.entity.Customer;
import com.gaam.model.entity.User;
import com.gaam.model.service.UserService;
import com.gaam.util.Msg;

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
		boolean isOk = false;
		User user = new User();
		Customer customer = new Customer();
		
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String status = (String) request.getParameter("status");
		String name = (String) request.getParameter("name");
		String phone = (String) request.getParameter("phone");
		String address = (String) request.getParameter("address");
		String cpf = (String) request.getParameter("cpf");
		String rg = (String) request.getParameter("rg");
		String insuranceCompanyId = (String) request.getParameter("insuranceCompany");
		String insuranceCompanyIdentification = (String) request.getParameter("insuranceCompanyIdentification");
		String observation = (String) request.getParameter("observation");
		
		// Fields validation
		if(StringUtils.isEmpty(email) || StringUtils.isEmpty(name) || StringUtils.isEmpty(cpf) || StringUtils.isEmpty(rg) || StringUtils.isEmpty(password)) {
			message = Msg.getProperty("message.user.mandatory.fields");
			isOk = false;
		} else {
			isOk = true;
		}
		
		// User validation
		if(isOk) {
			try {
				if(UserService.getInstance().isValidEMail(email)){
					isOk = true;
				} else {
					message = Msg.getProperty("message.email.exist");
					isOk = false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = e.getMessage();
			}
		}
		
		// Create user
		if(isOk) {
			user.setEmail(email);
			user.setPassword(password);
			try {
				message = UserService.getInstance().createUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// Set customer for dont lose data on screen
		customer.setAddress(address);
		customer.setCpf(cpf);
		customer.setName(name);
		customer.setPhone(phone);
		customer.setRg(rg);
		customer.setObservation(observation);
		customer.setInsuranceCompanyIdentification(insuranceCompanyIdentification);
		
		// Problema de foward para cada role deve ser resolvido pegando o usuário da sessão com sua role.
		request.setAttribute("message", message);
		request.setAttribute("customer", customer);
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.getRequestDispatcher("modules/admin/createCustomer.jsp").forward(request, response);
		
	}

}
