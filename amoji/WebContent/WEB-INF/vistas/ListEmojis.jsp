<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0-11/css/all.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/listaEmojisStyle.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/listaEmojisJS.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Emoticonos</title>
</head>
<body>
	<div class="container-fluid">
		<div id="idContent" class="d-flex text-center justify-content-center">
			<div id="idTable">
				<div id="idHead">
					<div id="idAmoji" class="text-center">
						<img src="${pageContext.request.contextPath}/resources/images/aaamoji.png" alt="Amoji web icon" width="390" height="110">
						<h3>Lista de Emoticonos</h3>
						<a href="menu.htm" id="idBtnVolver">Volver</a>
					</div>
					<div id="idFuntions" class="d-flex align-items-center justify-content-around">
						<div>
							<a id="idButtonAdd" class="btn btnAdd btn-light" href="anadirnuevo.htm"> <i class="fa fa-plus" aria-hidden="true"></i>
							</a>
						</div>
						<form:form method="GET" action="listaType.htm" modelAttribute="myEType">
						<a id="idBtnDltType" class="btn btnDltType btn-light" href="eliminartipo.htm"> <i class="fa fa-minus" aria-hidden="true"></i>
							</a>
							<form:select multiple="single" path="idType" required="true">
								<form:option disabled="true" value="0">--SELECT--</form:option>
								<form:options items="${listaType}" itemValue="idType" itemLabel="nameType" />
							</form:select>
							<button type="submit" class="btn btn-light">Filtrar</button>
						</form:form>
						<a class="btnUndo btn btn-light" href="/amoji/listemojis.htm"> <i class="fa fa-undo" aria-hidden="true"></i>
						</a>
					</div>
				</div>
				<div>
					<table class="table table-striped table-light">
						<thead class="thead-light">
							<tr>
								<th>Nombre</th>
								<th>Emoji</th>
								<th></th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listado}" var="registro">
								<tr>
									<td><c:out value="${registro.name}"></c:out></td>
									<td><span id='emoji<c:out value="${registro.idEmoticon}"/>'><c:out value="${registro.emoticon}"></c:out></span></td>
									<td><button id='emoji<c:out value="${registro.idEmoticon}"/>' type="button" class="btn btn-secondary fa fa-clipboard"
											data-toggle="tooltip" data-placement="top" title=""></button></td>
									<td><a class="btnModify"
										href='
				<c:url value="ActualizarEmoticono.htm">
					<c:param name="idEmoticon" value="${registro.idEmoticon}"></c:param>
				</c:url>'><i class="fas fa-edit" aria-hidden="true"></i></a></td>
									<td><a class="btnDelete"
										href='
				<c:url value="EliminarEmoticono.htm">
					<c:param name="idEmoticon" value="${registro.idEmoticon}"></c:param>
				</c:url>'><i class="fa fa-trash" aria-hidden="true"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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