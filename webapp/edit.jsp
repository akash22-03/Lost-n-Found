<%@page import="com.helper.FactoryProvider"%>
<%@page import="com.entities.Post"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Post | LostnFound</title>
<%@include file="linkedFiles.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<%
	int postId = Integer.parseInt(request.getParameter("post_id").trim());
	Session s = FactoryProvider.getFactory().openSession();
	Post note = (Post) s.get(Post.class, postId);
	%>
	<div class="container">
		<h1>Edit your Details</h1><br>
		<form action="UpdateServlet" method="POST">
			<div class="form-group">
				<input name="postId" type="hidden" class="form-control"  value="<%=note.getId() %>">
			</div>
			<div class="form-group">
				<input required name="title" type="text" class="form-control" id="title" placeholder="Enter your Post Title" value="<%=note.getTitle() %>">
			</div>
			<div class="form-group">
				<textarea required name="content" id="content" class="form-control" style="height:175px;" placeholder="Enter your Post Description"><%=note.getContent() %></textarea>
			</div>
            <div class="form-group">
				<input required name="name" type="text" class="form-control" id="name" placeholder="Enter your Name here" value="<%=note.getName() %>">
			</div>
			<div class="form-group">
				<input required name="number" type="number" class="form-control" id="number" placeholder="Enter your Contact No. here" value="<%=note.getNumber() %>">
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>	
		</form>
	</div>
</body>
</html>