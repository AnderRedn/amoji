<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/asciiImageStyle.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/asciiImageJS.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Arte Ascii</title>
</head>
<body>
	<div class="container-fluid">
		<div id="idContent" class="">
			<div id="idAmoji" class="text-center">
				<img src="${pageContext.request.contextPath}/resources/images/aaamoji.png" alt="Amoji web icon" width="390" height="110">
				<h3>Conversor Ascii</h3>
				<p id="idP">Se recomienda el uso de fuentes de la familia "monospace" al copiar</p>
				<a href="menu.htm" id="idBtnVolver">Volver</a>
			</div>
			<div class="d-flex flex-column text-center">
				<div>
					<p>
						<input type="file" name="picture" />
					</p>
				</div>
				<div class="d-flex flex-column justify-content-center">
					<div>
						<canvas id="preview" style="display: none;"></canvas>
					</div>
					<div class="d-flex justify-content-center" data-toggle="tooltip">
						<pre class="text-center" id="ascii"></pre>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>