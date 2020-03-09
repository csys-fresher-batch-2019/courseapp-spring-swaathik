<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.swaathi.courseapp.factory.DAOFactory"%>
<%@page import="com.swaathi.courseapp.dao.BatchDAO"%>
<%@page import="com.swaathi.courseapp.domain.BatchClass"%>

<html>
<title>Batches</title>
<style>
body {
	background-color: #d8e4e6;
}
</style>
<body>
	<font style="font-family: cursive"> <font color="black"><h2>
				<center>BatchDetails</center>
			</h2></font> <jsp:include page="logout.jsp"></jsp:include> 
		<center>
			<font color="black"><table border="1">
					</font>
					</center>
					<thead>
						<tr>
							<th>BatchCode</th>
							<th>CourseCode</th>
							<th>CourseName</th>
							<th>StartingDate</th>
							<th>EndDate</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${output}" var="batch">
							<tr>
								<td>${batch.batchCode}</td>
								<td>${batch.courseCode}</td>
								<td>${batch.courseName}</td>
								<td>${batch.startingDate}</td>
								<td>${batch.endDate}</td>
							</tr>
						</c:forEach>
								</tbody>
				</table>
</body>
</html>