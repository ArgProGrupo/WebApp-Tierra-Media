<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>

<jsp:include page="/partials/head.jsp"></jsp:include>

<title>Nuevo Usuario</title>
</head>

<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main>

		<form action="nuevoUsuario.adm" method="post">
			 <input type="hidden" name="id" value="${ tmp_usuario.getIdUsuario() }">
			<jsp:include page="formUsuarios.jsp"></jsp:include>
		</form>

		<!-- 
<div class="input-group mb-3">
  <span class="input-group-text" id="inputGroup-sizing-lg">Nombre: </span>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="inputGroup-sizing-default">Tipo de Atracción:</span>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="inputGroup-sizing-default">Presupuesto:</span>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" id="inputGroup-sizing-default">Tiempo disponible:</span>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>
 -->

	</main>

</body>
</html>