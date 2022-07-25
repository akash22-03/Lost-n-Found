<%@page import="org.hibernate.Query"%>
<%@page import="com.entities.Post"%>
<%@page import="com.entities.Admin"%>
<%@page import="java.util.List"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Posts | LostnFound</title>
<%@include file="linkedFiles.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="container">

	<h1 class="mt-3 text-uppercase">All Posts</h1>
	
	<div class="row">
		
			<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q =  s.createQuery("from Post");
				List<Post> list = q.list();
				for(Post post : list)
				{
					%>
					<div class="col-sm-6">
						<div class="card mt-3 ">
						  <img class="card-img-top" src="pictures/<%= post.getPicture() %>" alt="Card image cap">
						  <div class="card-body">
						    <h5 class="card-title"><%= post.getTitle() %></h5>
						    <p class="card-text"><%=post.getContent() %></p>
						    <p class="card-text"><b class="text-primary">Posted By : <%=post.getName()%></b><br>
						    <b class="text-primary">Contact : <%=post.getNumber() %></b><br>
						    <b class="text-primary">Last updated : <%=post.getAddeddate() %></b></p>
						  <%
						  if(session.getAttribute("currentUser")!=null){	
						  %>  
						    <a href="DeleteServlet?post_id=<%=post.getId() %>" class="btn btn-danger">Delete</a>
						    <a href="edit.jsp?post_id=<%=post.getId() %>" class="btn btn-primary">Update</a>
						  <%
						  }
						  %>
						  </div>
						</div>
					</div>
					<%
				}
				s.close();
			%>
		
	</div>
</div>
</body>
</html>