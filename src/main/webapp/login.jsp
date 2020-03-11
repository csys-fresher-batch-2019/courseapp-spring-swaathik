<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>Login</title>
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

a {
	color: black;
}
</style>
<body>


	<form action="Login">
		<font style="font-family: cursive; color: black">
			<h3 align="center">Login</h3>
			<center>
				Username : <input type="text" name="username" placeholder="Username"
					required autofocus />
			</center> <br /> <br />
			<center>
				Enter Password: <input type="password" name="password" required />
			</center>
			<center>
				<c:if test="${not empty errorMessage}">
					<font color="red" style="font-style: normal">${errorMessage}
				</c:if>
				<br />
				<button type="submit">
					<center>Submit</center>
				</button>
				<br /> <br /> <a href="register.jsp">New User?</a>
		</font>
		</center>
	</form>

</body>
</html>