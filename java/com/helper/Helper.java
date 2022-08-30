package com.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import com.entities.Admin;
import com.entities.Post;

public class Helper 
{
	public static void saveFile(InputStream is, String path) 
	{
		try {
			byte b[] = new byte[is.available()];
			is.read(b);
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Post> getPostByCat(String cat)
    {
        List<Post> list = new ArrayList<Post>();
        try{
        	Connection con = ConnectionProvider.getConnection();
            PreparedStatement p = con.prepareStatement("select * from posts where category = ?");
            p.setString(1,cat);
            ResultSet set = p.executeQuery();
            while(set.next()){
            	String category = set.getString("category");	
    			String title = set.getString("title");
    			String content = set.getString("content");
    			String name = set.getString("name");
    			long number = set.getLong("number");
    			String picture = set.getString("picture");
    			Date date = set.getDate("addeddate");
                Post post = new Post(category, title, content, name, number, picture, date);
                list.add(post);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
	public static Admin getAdmin(String username, String password)
	{
		Connection con = ConnectionProvider.getConnection();
		Admin admin = null;
		try {
			SecretKey sKey = EncryptionProvider.key;
			byte[] IVector = EncryptionProvider.iVector;
			byte[] eAdminname = EncryptionProvider.doAESEncryption(username, sKey, IVector);
			byte[] ePassword = EncryptionProvider.doAESEncryption(password, sKey, IVector);
			
			String query = "select * from admin where adminname = ? and password = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setBytes(1, eAdminname);
            pstmt.setBytes(2, ePassword);
            ResultSet set = pstmt.executeQuery();
            
            if(set.next()) {
            	admin = new Admin();
            	admin.setAdminname(set.getBytes("adminname"));
            	admin.setPassword(set.getBytes("password"));
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}
