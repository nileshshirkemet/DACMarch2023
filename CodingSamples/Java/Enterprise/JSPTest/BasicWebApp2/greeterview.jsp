<jsp:useBean id="greeter" class="basic.web.app.GreeterBean" scope="application"/>
<jsp:setProperty name="greeter" property="person" param="guest"/>
<jsp:setProperty name="greeter" property="period"/>
<html>
	<head>
		<title>BasicWebApp</title>
	</head>
	<body>
		<h1>${greeter.message}</h1>
		<b>Number of Greetings: </b>${greeter.greetCount}
		<hr/>
		<form method="POST">
			<p>
				<b>Person: </b>
				<input type="text" required="required" name="guest"/>
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

