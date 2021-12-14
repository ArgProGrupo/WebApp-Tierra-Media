<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>

<jsp:include page="/partials/head.jsp"></jsp:include>

<title>Editar Atracción</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	
	<h2>Editar Atracción</h2>
	
	<form action="edit.adm" method="post">
		<input type="hidden" name="id" value="${ atraccion.getIdAtraccion() }">
		<jsp:include page="formAtracciones.jsp"></jsp:include>
	</form>

</body>
</html>