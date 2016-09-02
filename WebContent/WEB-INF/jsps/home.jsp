<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath }/Login"
		commandName="detail">
		<table>
			<tr>
				<td><strong>User Email</strong></td>
				<td><sf:input type="text" name="email" path="email" /></td><br />
					<td><sf:errors path="email"></sf:errors></td>
					<td>${detail.emailError}</td>
			</tr>
			<tr>
				<td><strong>Password</strong>:</td>
				<td><sf:input type="password" name="password" path="password" /></td> <br />
					<td><sf:errors path="password"></sf:errors></td>
					<td>${detail.passwordError}</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login" name="submit" /></td>
			</tr>
		</table>
	</sf:form>


	<!-- <form action="Login" method="post">
<strong>User Email</strong>:<input type="text" name="email"><br>
<strong>Password</strong>:<input type="password" name="password"><br>
<input type="submit" value="Login">
</form> -->
	<br> If you are new user, please
	<a href="${pageContext.request.contextPath}/register">register</a>.
	<%-- <p>
		<a href="${pageContext.request.contextPath}/home">ShowOffers</a>
	</p> --%>
</body>
</html>