<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.swaathi.courseapp.factory.DAOFactory"%>
<%@page import="com.swaathi.courseapp.dao.CourseDAO"%>
<%@page import="com.swaathi.courseapp.domain.CourseClass"%>

<html>
<title>CourseNames</title>
<style>
body {
	background-color: #d8e4e6;
}
</style>
<body>
	<font style="font-family: cursive"> <font color="black"><h2>
				<center>CourseDetails</center>
			</h2></font> <jsp:include page="logout.jsp"></jsp:include> <%
 	ArrayList<CourseClass> a = (ArrayList) request.getAttribute("output");
 %>
		<center>
			<font color="black"><table border="1">
					</font>
					</center>
					<thead>
						<tr>
							<th>CourseCode</th>
							<th>CourseName</th>
							<th>CourseFees</th>
							<th>CourseDurationDays</th>
							<th>PreReq</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${output}" var="course">
							<tr>
								<td>${course.courseCode}</td>
								<td>${course.courseName}</td>
								<td>${course.courseFee}</td>
								<td>${course.courseDurationDays}</td>
								<td>${course.preReq}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>