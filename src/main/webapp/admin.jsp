<!DOCTYPE html>
<html>
<title>Login</title>
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
</style>
<body>

	<form action="Admin">
		<font style="font-family: cursive; color: black">
			<h3 align="center">AdminLogin</h3>
			<center>
				Username : <input type="text" name="username" placeholder="Username"
					required autofocus />
			</center> <br /> <br />
			<center>
				Enter Password: <input type="password" name="password" required />
			</center> <br /> <br />
			<center>
				<button type="submit">
					<center>Submit</center>
				</button>
				</br>
				<%
					String errorMessage = (String) request.getAttribute("Error Message");
					if (errorMessage != null) {
				%>
				<font color="red" style="font-style: normal" "class="a"><%=errorMessage%>
					<%
						}
					%> </font>
			</center>
	</form>
</body>
</html>