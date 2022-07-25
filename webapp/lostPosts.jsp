<%@page import="com.helper.Helper"%>
<%@page import="com.entities.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lost Posts | LostnFound</title>
<%@include file="linkedFiles.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
	<h1 class="mt-3 text-uppercase">Lost Posts</h1>
	<div class="row">
<%
	List<Post> posts = Helper.getPostByCat("lost");
	if(posts.size()==0){
	    out.println("<h3 class='display-3 text-center'>No Posts Availabe.</h3>");
	    return;
	}
	for(Post post : posts)
	{
		%>
		<div class="col-sm-6">
			<div class="card mt-3 ">
			  <img class="card-img-top m-4" src="pictures/<%= post.getPicture() %>" style="max-width: 490px" alt="Card image cap">
			  <div class="card-body">
			    <h5 class="card-title"><%= post.getTitle() %></h5>
			    <p class="card-text"><%=post.getContent() %></p>
			    <p class="card-text"><b class="text-primary">Posted By : <%=post.getName()%></b><br>
			    <b class="text-primary">Contact : <%=post.getNumber() %></b><br>
			    <b class="text-primary">Last updated : <%=post.getAddeddate() %></b></p>
			    <a href="DeleteServlet?note_id=<%=post.getId() %>" class="btn btn-danger">Delete</a>
			    <a href="edit.jsp?note_id=<%=post.getId() %>" class="btn btn-primary">Update</a>
			  </div>
			</div>
		</div>
		<%
	}
%>
</div>
</div>
</body>
</html>