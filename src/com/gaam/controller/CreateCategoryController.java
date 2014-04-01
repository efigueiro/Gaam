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

		String name = (String) request.getParameter("name");

		Category category = new Category();
		category.setName(name);

		
		if (StringUtils.isEmpty(name)) {
			message = Msg.getProperty("message.category.mandatory.fields");
		} else {
			try {
				message = CategoryService.getInstance().create(category);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("modules/admin/medicSetup.jsp").forward(request, response);
	}
}
