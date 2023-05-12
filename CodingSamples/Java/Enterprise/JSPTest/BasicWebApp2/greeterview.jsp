<html>
	<head>
		<title>BasicWebApp</title>
	</head>
	<body>
		<h1>Hello World</h1>
		<b>Number of Greetings: </b>0
		<hr/>
		<form method="POST">
			<p>
				<b>Person: </b>
				<input type="text" required="required" name="person"/>
			</p>
			<p>
				<b>Period: </b>
				<select name="period">
					<option>Night</option>
					<option>Morning</option>
					<option>Afternoon</option>
					<option>Evening</option>
				</select>
			</p>
			<input type="submit" value="Greet"/>
		</form>
	</body>
</html>

