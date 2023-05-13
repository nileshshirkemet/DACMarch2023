<%@taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="customer" class="db.web.app.CustomerBean" scope="session"/>
<jsp:setProperty name="customer" property="*"/>
<c:if test="${param.signout}">
	<c:set target="${customer}" property="id"/>
</c:if>
<html>
	<head>
		<title>DBWebApp</title>
	</head>
	<body>
		<h1>Welcome Customer</h1>
		<form method="POST">
			<p>		
				<b>Customer ID</b><br/>
				<input type="text" name="id"/>
			</p>
			<p>		
				<b>Password</b><br/>
				<input type="password" name="password"/>
			</p>
			<p>
				<input type="submit" name="submit" value="Login"/>
			</p>
		</form>
		<c:if test="${param.submit == 'Login'}">
			<c:choose>
				<c:when test="${customer.authenticate()}">
					<c:redirect url="order.jsp"/>
				</c:when>
				<c:otherwise>
					<b>Invalid Customer ID or Password</b>
				</c:otherwise>
			</c:choose>
		</c:if>
	</body>
</html>

