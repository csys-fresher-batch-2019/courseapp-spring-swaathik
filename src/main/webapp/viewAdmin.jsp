<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: #d8e4e6;
}

.dropbtn {
	background-color: #353838;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	right: 0;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #3e8e41;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
</style>
</head>
<body>
	<font style="font-family: cursive; color: black"> <jsp:include
			page="logout.jsp"></jsp:include>
		<center>
			<h1>Welcome Admin!!!</h1>
		</center>

		<div class="dropdown" style="float: left;">
			<button class="dropbtn">View</button>

			<div class="dropdown-content" style="left: 0;">
				<a href="ListAdminCourses">Courses</a> <a href="ListAdminBatches">Batches</a>
				<a href="ListAdminEnrollStudents">EnrolledStudents</a> <a
					href="ListAdminStudents">Students</a>
			</div>
		</div>

		<div class="dropdown" style="float: right;">
			<button class="dropbtn">Add</button>
			<div class="dropdown-content">
				<a href="CourseEnroll.jsp">Courses</a> <a href="BatchEnroll.jsp">Batches</a>

			</div>
		</div>
	</font>
</body>
</html>
