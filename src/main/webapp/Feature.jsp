
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h2>Features</h2>
	<ul>
		<li><a href="Register">Register</a></li>
		<li><a href="Login">Login</a></li>
	</ul>
	Select Movie
	<select name="movie">
		<option value="darbar">Darbar</option>
		<option value="sarkar">Sarkar</option>
	</select> 10:59 Table: Display Movies:
	<table border="1">
		<thead>
			<tr>
				<th>#</th>
				<th>Movie Name</th>
			</tr>
		<tbody>
			<tr>
				<td>1</td>
				<td>Darbar</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Sarkar</td>
			</tr>
		</tbody>
	</table>
	<img src="assets/images/images.png" width="100" height="100"
		alt="Darbar" /> Select Source Station:
	<input list="source_station_list">
	<datalist id="source_station_list">
	<option value="MGR Chennai Central - MAS">
	<option value="Bangalore">
	<option value="Madurai">
	</datalist>

</body>
</html>