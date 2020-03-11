<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<title>CourseNames</title>
<style>
p {
	color: black;
}

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
</style>
<body>

	<jsp:include page="logout.jsp"></jsp:include>

	<font style="font-family: cursive; color: black"> <font
		color="black"><h2>
				<center>CourseDetails</center>
			</h2></font>
		<center>
			<font color="black"><table border="1">
					</font>
					</center>
					<thead>
						<tr>
							<th>CourseCode</th>
							<th>CourseName</th>
							<th>CourseFee</th>
							<th>CourseDurationDays</th>
							<th>PreRequisite</th>
						</tr>
					</thead>
					<tbody>
						<tr>

							<td>${COURSE_DETAIL.courseCode}</td>
							<td>${COURSE_DETAIL.courseName}</td>
							<td>${COURSE_DETAIL.courseFee}</td>
							<td>${COURSE_DETAIL.courseDurationDays}</td>
							<td>${COURSE_DETAIL.preReq}</td>
						</tr>






					</tbody>
				</table> <br /> <br />
</body>
<body>
	<h2>
		<center>BatchDetails</center>
	</h2>
	</font>
	<font style="font-family: cursive; color: black">
		<center>
			<font color="black"><table border="1">
					</font>
					</center>
					<thead>
						<tr>
							<th>BatchCode</th>
							<th>StartingDate</th>
							<th>EndDate</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${BATCH_CLASS}" var="batch">
							<tr>
								<td>${batch.batchCode}</td>
								<td>${batch.startingDate}</td>
								<td>${batch.endDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table> <br /> <br />
				<p>Timings:9.00 AM to 4.00 PM</p> <br />
				<p>All the days</p> <br />
				<p>To Enroll</p> <br />
				<form action='receiptGeneration.jsp'>
					<input type="hidden" name="courseName"
						value="${COURSE_DETAIL.courseName}" /> <input type="hidden"
						name="courseFee" value="${COURSE_DETAIL.courseFee}" />
					<button type="submit">Next</button>
				</form>
</body>


</html>