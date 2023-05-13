<%@taglib prefix="m" uri="basic.web.app.tags" %>
<html>
	<head>
		<title>BasicWebApp</title>
	</head>
	<body>
		<h1>Welcome Gambler</h1>
		<b>WINNER: </b>
		<m:lotto digitVar="d" digitCount="6">
			<i>${d}</i>
		</m:lotto>		
	</body>
</html>

