<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>index</title>
	</head>
	<body>
		<a href="#">fastcampus</a>
				<a href="#">Home</a>
				<a href="${pageContext.request.contextPath}/boardList">Board</a>
				<%
					String loginId = (String) session.getAttribute("loginId");
					if (loginId == null) {
				%>
					<a href="${pageContext.request.contextPath}/loginForm">Login</a>
			
				<%
					} else {
				%>
					<a href="${pageContext.request.contextPath}/logout">Logout</a>
				<%
					}
				%>

				<a href="#">Sign in</a>
				<h1>This is HOME<br></h1>
						<h1>This is HOME<br></h1>
						<h1>This is HOME<br></h1>
	</body>
</html>