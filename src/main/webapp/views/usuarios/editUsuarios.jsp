<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>

<jsp:include page="/partials/head.jsp"></jsp:include>

<title>Editar Usuarios</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<h1>Editar Usuarios</h1>
	
	<form action="editUsuarios.adm" method="post">
		<input type="hidden" name="id" value="${ tmp_usuario.getIdUsuario() }">
		<jsp:include page="formUsuarios.jsp"></jsp:include>
	</form>
</body>
</html>