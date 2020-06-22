<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link
	href="${pageContext.request.contextPath}/resources/css/anadirNuevoStyle.css"
	rel="stylesheet">
<!--script src="${pageContext.request.contextPath}/resources/js/sample.js"></script-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir nuevo</title>
</head>
<body>
	<div class="container-fluid">
		<div id="idContent" class="vertical-center justify-content-center">
			<div id="idAmoji" class="text-center">
				<img
					src="${pageContext.request.contextPath}/resources/images/aaamoji.png"
					alt="Amoji web icon" width="390" height="110">

				<h3>Añadir nuevo Emoticono</h3>
				<a href="listemojis.htm" id="idBtnVolver">Volver</a>
			</div>

			<form:form modelAttribute="emoji">
				Nombre: <form:input path="name" />
				<br>
				Emoticono: <form:input path="emoticon" />
				<br>
				<form:select multiple="single" path="idType">
					<form:option value="0"> --SELECT--</form:option>
					<form:options items="${listaType}" itemValue="idType"
						itemLabel="nameType" />
				</form:select>
				<button type="submit" class="btn btn-light">Añadir</button>
			</form:form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>