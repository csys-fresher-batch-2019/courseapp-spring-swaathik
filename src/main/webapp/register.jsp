<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
</head>

<body>
	<form action="Register">
		<font style="font-family: cursive; color: black">
			<style>
a {
	color: black;
}

body {
	background-color: #d8e4e6;
	background-size: cover;
	background-attachment: fixed;
}

button {
	border radius: 25px;
	background-color: #353838;
	color: white;
	padding: 10px 25px;
	text-align: center;
	display: inline-block;
	font-size: 13px;
	cursor: pointer;
	margin: 4px 2px;
}
</style> <font style="font-family: cursive;">
				<h3 align="center">Registration</h3>
				<center>
					Enter Name : <input type="text" name="name"
						placeholder="Enter Name" required autofocus />
				</center> <br /> <br />
				<center>
					Enter FatherName Or Guardian Name : <input type="text" name="fname"
						placeholder="Enter FatherName Or Guardian Name" required autofocus />
				</center> <br /> <br />
				<center>
					Enter PhoneNumber : <input type="text" name="phNo"
						placeholder="Enter PhoneNumber" required maxlength="10"
						pattern="\d{10}" title="Enter 10 digits" />
				</center> <br /> <br />
				<center>
					Enter Email : <input type="email" name="email"
						placeholder="Enter Email" required autofocus>
				</center> <br /> <br />
				<center>
					Enter Date of enroll: <input type="date" name="doj"
						placeholder="Enter date" required autofocus />
				</center> <br /> <br />
				<center>
					<center>
						Enter a username: <input type="text" name="Username"
							placeholder="Enter username" required autofocus />
					</center>
					<br /> <br />
					<center>
						Enter Password: <input type="password" name="password"
							placeholder="Enter password" required autofocus />
					</center>
					<br /> <br /> <a href="login.jsp"> Already Registered?</a> <br />
					<center>
						<c:if test="${not empty errorMessage}">
							<font color="red" style="font-style: normal">${errorMessage}
						</c:if>
						<br />
						<center>
							<button type="submit">
								<center>Register</center>
							</button>
						</center>
	</form>



</body>
</html>