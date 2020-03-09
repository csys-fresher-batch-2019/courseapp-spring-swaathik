
<!DOCTYPE html>
<html>
<head>

<title>Receipt</title>
</head>
<style>
body {
	background-color: #d8e4e6;
	background-size: cover;
	background-attachment: fixed;
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

h2 {
	color: black;
}
</style>

<body>

	<jsp:include page="logout.jsp"></jsp:include>
	<center>
		<h2>Enrollment</h2>
	</center>
	<form action="receipt">
		<font style="font-family: cursive; color: black"> <br /> <br />
			<center>
				AdmissionNumber:<input type="number" name="admNo" value="${admNo}"
					readonly required placeholder="Enter AdmissionNumber:" required>
			</center> <br /> <br />
			<center>
				Course Fees :<input type="number" name="amountPaid"
					value="${param.courseFee}" placeholder="Enter Amount" required
					readonly>
			</center> <br /> <br />


			<center>
				Course Name:<input type="text" name="reMarks"
					value="${param.courseName}" placeholder="Course Name" required
					readonly>
			</center> <br /> <br />
			<center>
				<button type="submit">Finish</button>
			</center>
	</form>
</body>
</html>