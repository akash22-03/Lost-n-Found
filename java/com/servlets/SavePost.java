package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Post;
import com.helper.FactoryProvider;
import com.helper.Helper;

@MultipartConfig
public class SavePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SavePost()
    {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			String category = request.getParameter("category");	
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String name = request.getParameter("name");
			long number = Long.parseLong(request.getParameter("number"));
			Part part = request.getPart("picture");

			Post post = new Post(category,title,content,name,number,part.getSubmittedFileName(), new Date());
			
			//String path = "C:/Users/akash/Documents/Hibernate/LostnFound/src/main/webapp/pictures/"+part.getSubmittedFileName();
            String path = request.getRealPath("/")+"pictures"+File.separator+part.getSubmittedFileName(); 
			Helper.saveFile(part.getInputStream(), path);
            
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(post);
			
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
