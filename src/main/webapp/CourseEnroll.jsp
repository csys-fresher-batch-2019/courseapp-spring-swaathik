<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>CourseEnroll</title>
</head>
<style>
body {
	background-color: #d8e4e6;
}

button {
	border radius: 18px;
	background-color: #353838;
	color: white;
	padding: 10px 25px;
	text-align: center;
	display: inline-block;
	font-size: 13px;
	cursor: pointer;
	margin: 4px 2px;
}
</style>

<body>
	<jsp:include page="logout.jsp"></jsp:include>
	<center>
		<h2>AddCourses</h2>
	</center>
	<form action="course">
		<font style="font-family: cursive">
			<center>
				Enter CourseCode:<input type="number" name="courseCode"
					placeholder="Enter Course Code" required>
			</center> <br /> <br />

			<center>
				Enter CourseName:<input type="text" name="courseName"
					placeholder="Enter course Name" required>
			</center> <br /> <br />

			<center>
				Enter CourseFees:<input type="number" name="courseFees"
					placeholder="Enter course Fees" required>
			</center> <br /> <br />

			<center>
				Enter CourseDuration(days):<input type="number"
					name="courseDuration" placeholder="Enter CourseDuration" required>
			</center> <br /> <br />

			<center>
				Enter PreReq:<input type="text" name="preReq"
					placeholder="Enter pre Requisite" required>
			</center> <br /> <br />
			<center>
				<button type="submit">ADD</button>
			</center>
	</form>
</body>
</html>