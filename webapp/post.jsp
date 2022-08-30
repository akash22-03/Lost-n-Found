<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="linkedFiles.jsp"%>
<title>Post | LostnFound</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<br>
	<div class="container">
		<h1>Please enter the details : </h1>
		<form action="SavePost" id="add-post-form" method="POST" enctype="multipart/form-data">
		 <div class="form-group">
               <select class="form-control" name="category">
                     <option selected disabled>---Select Category---</option>
                     <option  value="lost">Lost</option>
                     <option  value="found">Found</option>
                 </select>
           </div>
			<div class="form-group">
				<input required name="title" type="text" class="form-control" id="title" placeholder="Enter your Post Title">
			</div>
			<div class="form-group">
				<textarea required name="content" id="content" class="form-control" style="height:175px;" placeholder="Enter your Post Description"></textarea>
			</div>
			<div class="form-group">
                <label>Select your picture</label><br>
                <input type="file" name="picture"/>
            </div>
            <div class="form-group">
				<input required name="name" type="text" class="form-control" id="name" placeholder="Enter your Name here">
			</div>
			<div class="form-group">
				<input required name="number" type="number" class="form-control" id="number" placeholder="Enter your Contact No. here">
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Add</button>
			</div>
			
		</form>
	</div>
	<script src="js/post.js" type="text/javascript"></script>
</body>
</html>