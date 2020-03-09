<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.swaathi.courseapp.factory.DAOFactory"%>
<%@page import="com.swaathi.courseapp.dao.PaymentDAO"%>
<%@page import="com.swaathi.courseapp.domain.PaymentClass"%>

<html>
<title>EnrolledStudents</title>
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
							<th>ReceiptNo</th>
							<th>FeeAmount</th>
							<th>AdmNo</th>
							<th>EnrollDate And Time</th>
							<th>CourseName</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${output}" var="EnrolledStudent">

							<tr>
								
								<td>${EnrolledStudent.receiptNo}</td>
								<td>${EnrolledStudent.amountPaid}</td>
								<td>${EnrolledStudent.admNo}</td>
								<td>${EnrolledStudent.payDate}</td>
								<td>${EnrolledStudent.reMarks}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>