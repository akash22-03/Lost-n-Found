package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Post;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
    	
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String name = request.getParameter("name");
			long number = Long.parseLong(request.getParameter("number").trim());
			int postId = Integer.parseInt(request.getParameter("postId").trim());
				
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			
			Post post = s.get(Post.class, postId);
			post.setTitle(title);
			post.setContent(content);
			post.setAddeddate(new Date());
			post.setName(name);
			post.setNumber(number);
			
			tx.commit();
			s.close();	
			
			response.sendRedirect("allPosts.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
