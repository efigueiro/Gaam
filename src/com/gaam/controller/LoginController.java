package com.gaam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.gaam.model.entity.User;
import com.gaam.model.service.LoginService;
import com.gaam.util.Msg;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User authenticated = new User();
        authenticated = (User) request.getSession().getAttribute("authenticated");
        String action = request.getParameter("action");

        if (authenticated == null || action.equals("logout")) {
                request.getSession().invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		if(StringUtils.isEmpty(password) || StringUtils.isEmpty(email)) {
			message = Msg.getProperty("message.empty.fields");
			request.setAttribute("message", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			
			User authenticated = new User();
			try {
				authenticated = LoginService.getInstance().authentication(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!StringUtils.isEmpty(authenticated.getEmail())) {
				HttpSession session = request.getSession();
                session.setAttribute("authenticated", authenticated);
                
                if(authenticated.getRole().equalsIgnoreCase("admin")){
                	request.getRequestDispatcher("modules/admin/main.jsp").forward(request, response);
                }
                
                if(authenticated.getRole().equalsIgnoreCase("medic")){
                	request.getRequestDispatcher("modules/medic/main.jsp").forward(request, response);
                }
                
                if(authenticated.getRole().equalsIgnoreCase("customer")){
                	request.getRequestDispatcher("modules/customer/main.jsp").forward(request, response);
                }
                
                if(authenticated.getRole().equalsIgnoreCase("employee")){
                	request.getRequestDispatcher("modules/employee/main.jsp").forward(request, response);
                }
                
			} else {
				message = Msg.getProperty("message.userNotFound");
                request.setAttribute("message", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}
		
	}
	
	

}
