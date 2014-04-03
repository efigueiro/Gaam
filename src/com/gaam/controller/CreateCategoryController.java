package com.gaam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.gaam.model.entity.Category;
import com.gaam.model.service.CategoryService;
import com.gaam.util.Msg;

/**
 * Servlet implementation class CreateInsuranceCompany
 */
@WebServlet("/createCategory")
public class CreateCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateCategoryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String message = "";
		boolean isOk;
		isOk = true;
		String name = (String) request.getParameter("name");
		Category category = new Category();

		// Procura categoria com o mesmo nome
		try {
			category = CategoryService.getInstance().retrieveByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		if(StringUtils.isNotEmpty(category.getName())) {
			isOk = false;
			message = Msg.getProperty("message.category.exist");
		}
		
		// Criando categoria
		category.setName(name);
		
		if(isOk) {
			try {
				message = CategoryService.getInstance().create(category);
			} catch (Exception e) {
				message = e.getMessage();
			}
		}
				
		request.setAttribute("message", message);
		request.getRequestDispatcher("modules/admin/medicSetup.jsp").forward(request, response);
	}
}
