<%@page import="com.entities.Admin"%>
<nav class="navbar navbar-expand-lg navbar-dark purple">
	<a class="navbar-brand" href="#">Lost'n'Found</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">Home<span class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="post.jsp">Post</a></li>
			<li class="nav-item"><a class="nav-link" href="allPosts.jsp">All Posts</a></li>
			<li class="nav-item"><a class="nav-link" href="lostPosts.jsp">Lost Posts</a></li>
			<li class="nav-item"><a class="nav-link" href="foundPosts.jsp">Found Posts</a></li>
		</ul>
		<%
			if(session.getAttribute("currentUser")!=null){
				%>
				<form method="POST" class="form-inline my-2 my-lg-0" action="LogoutServlet">
					<button class="btn btn-outline-light my-2 my-sm-0" type="submit">LogOut</button>
				</form>
				<%
			}
			else{
				%>
				<form method="POST" class="form-inline my-2 my-lg-0" action="LoginServlet">
					<input class="form-control mr-sm-2" name="adminname" placeholder="Admin Username">
					<input class="form-control mr-sm-2" name="password" type="password" placeholder="Admin Password">
					<button class="btn btn-outline-light my-2 my-sm-0" type="submit">LogIn</button>
				</form>
				<%
			}
		%>
		
	</div>
</nav>