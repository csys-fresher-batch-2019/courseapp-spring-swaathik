<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Batches</title>
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
		<h2>AddBatches</h2>
	</center>
	<form action="batch">
		<font style="font-family: cursive">
			<center>
				Enter BatchCode:<input type="number" name="batchCode"
					placeholder="Enter Batch Code" required>
			</center> <br /> <br />

			<center>
				Enter CourseCode:<input type="number" name="courseCode"
					placeholder="Enter course Code" required>
			</center> <br /> <br />

			<center>
				Enter CourseName:<input type="text" name="courseName"
					placeholder="Enter course Name" required>
			</center> <br /> <br />

			<center>
				Enter StartingDate:<input type="date" name="startingDate"
					placeholder="Enter StartingDate" required>
			</center> <br /> <br />

			<center>
				Enter EndDate:<input type="date" name="endDate"
					placeholder="Enter endDate" required>
			</center> <br /> <br />
			<center>
				<c:if test="${not empty errorMessage}">
					<font color="red" style="font-style: normal">${errorMessage}
				</c:if>
				<br />
			</center> <br />
			<center>
				<button type="submit">ADD</button>
			</center>
	</form>
</body>
</html>