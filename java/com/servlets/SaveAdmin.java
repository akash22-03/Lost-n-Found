package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Enumeration;

import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entities.Admin;
import com.entities.Crypto;
import com.helper.EncryptionProvider;
import com.helper.FactoryProvider;


public class SaveAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   public SaveAdmin() {

        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			String key = request.getParameter("ukey");
			String ukey = "X+1J7uEyhtLlD//SVCEjaw==";
			
			if(key.equals(ukey)) {
				String adminname = request.getParameter("adminname");
				String password = request.getParameter("password");
				
				SecretKey sKey = EncryptionProvider.key;
				byte[] IVector = EncryptionProvider.iVector;
				byte[] eAdminname = EncryptionProvider.doAESEncryption(adminname, sKey, IVector);
				byte[] ePassword = EncryptionProvider.doAESEncryption(password, sKey, IVector);
				
				Admin admin = new Admin(eAdminname,ePassword);   
				
				
				Session s = FactoryProvider.getFactory().openSession();
				Transaction tx = s.beginTransaction();
				s.save(admin);
				tx.commit();
				s.close();
				response.sendRedirect("http://localhost:9494/LostnFound/index.jsp");
			}else {
				response.setStatus(response.SC_FORBIDDEN);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
