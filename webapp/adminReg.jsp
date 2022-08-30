<!doctype html>
<html lang="en">
<head>
<%@include file="linkedFiles.jsp"%>

<title>Register Admin | LostnFound</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<br>
	<div class="container">
		<h1>Please enter the details : </h1>
		<form id="admin-form" action="SaveAdmin" method="POST">
		<div class="form-group">
			<input required name="adminname" type="text" class="form-control" placeholder="Enter your name here">
		</div>
		<div class="form-group">
			<input required name="password" type="password" class="form-control" placeholder="Enter your password">
		</div>
		<div class="form-group">
			<input required name="ukey" type="text" class="form-control" placeholder="Enter admin's unique key">
		</div>		
		<div class="container text-center">
			<button type="submit" class="btn btn-primary">Register</button>
		</div>
		</form>
		</div>	
</body>
</html>