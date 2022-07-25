package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Admin;
import com.helper.Helper;


public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminname = request.getParameter("adminname");
        String password = request.getParameter("password");
        Admin admin = Helper.getAdmin(adminname, password);
        HttpSession s = request.getSession();
        s.setAttribute("currentUser",admin);
        response.sendRedirect("allPosts.jsp");
	}

}
