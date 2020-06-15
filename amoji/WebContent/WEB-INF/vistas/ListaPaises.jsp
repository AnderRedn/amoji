<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Paises</title>
</head>
<body>

<h1>Lista de Paises</h1>

<table>
	<tr>
		<th>Codigo</th><th>Nombre</th><th>Poblacion</th>
	</tr>
	<c:forEach items="${listado}" var="registro">
		<tr>
			<td><c:out value="${registro.codigo}"></c:out></td>
			<td><c:out value="${registro.nombre}"></c:out></td>
			<td><c:out value="${registro.habitantes}"></c:out></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>