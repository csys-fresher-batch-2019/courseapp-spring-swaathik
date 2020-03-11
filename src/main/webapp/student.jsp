<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>
<title>StudentNames</title>
<style>
body {
	background-color: #d8e4e6;
}
</style>
<body>
	<font style="font-family: cursive"> <font color="black"><h2>
				<center>StudentDetails</center>
			</h2></font> <jsp:include page="logout.jsp"></jsp:include>

		<center>
			<font color="black"><table border="1">
					</font>
					</center>
					<thead>
						<tr>
							<th>AdmNo</th>
							<th>Name</th>
							<th>Father or Guardian Name</th>
							<th>EmailId</th>
							<th>PhoneNo</th>
							<th>DateOfJoining</th>
							<th>UserName</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${output}" var="student">

							<tr>
								<td>${student.admNo}</td>
								<td>${student.fullName}</td>
								<td>${student.fatherNameOrGuardianName}</td>
								<td>${student.emailId}</td>
								<td>${student.phoneNo}</td>
								<td>${student.dateOfJoining}</td>
								<td>${student.userName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>