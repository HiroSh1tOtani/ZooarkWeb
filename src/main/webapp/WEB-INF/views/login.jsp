<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login page</title>
	<link rel="stylesheet" href="<c:url value='/static/libs/bower/font-awesome/css/font-awesome.min.css' />">
	<link rel="stylesheet" href="<c:url value='/static/libs/bower/material-design-iconic-font/dist/css/material-design-iconic-font.min.css' />">
	<link rel="stylesheet" href="<c:url value='/static/libs/bower/animate.css/animate.min.css' />">
	<link rel="stylesheet" href="<c:url value='/static/assets/css/bootstrap.css' />">
	<link rel="stylesheet" href="<c:url value='/static/assets/css/app.css' />">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900,300">
</head>
<body class="simple-page">
	<div class="simple-page-wrap">
		<!-- logo -->
		<div class="simple-page-form animated flipInY" id="login-form">
			<h4 class="form-title m-b-xl text-center">Zooark</h4>
			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="post" class="form-horizontal">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
				<div class="form-group">
					<input id="username" type="text" name="username" class="form-control" placeholder="Ingresar Usuario" required>
				</div>
				<div class="form-group">
					<input id="password" type="password" name="password" class="form-control" placeholder="Ingresar Contraseña" required>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="submit" class="btn btn-primary" value="SING IN">
			</form>
		</div>
	</div>
	<!-- .simple-page-wrap -->
</body>
</html>