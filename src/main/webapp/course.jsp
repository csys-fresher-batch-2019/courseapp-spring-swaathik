<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>
<title>CourseNames</title>
<style>
body {
	background-color: #d8e4e6;
	background-size: cover;
	background-attachment: fixed;
}

a {
	color: black;
}
</style>
<body>

	<font style="font-family: cursive; color: black"> <font
		color="black"><h2>
				<center>CourseDetails</center>
			</h2></font> <jsp:include page="logout.jsp"></jsp:include>
		<center>
			<font color="black"><table border="1">
					</font>
					</center>
					<thead>
						<tr>
							<th>CourseCode</th>
							<th>CourseName</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${output}" var="course">
							<tr>
								<td>${course.courseCode}</td>
								<td><a href="ListBatches?course_name=${course.courseName}">${course.courseName}</a></td>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>