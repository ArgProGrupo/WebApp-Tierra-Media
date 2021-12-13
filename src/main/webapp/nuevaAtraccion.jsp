<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>

<jsp:include page="/partials/head.jsp"></jsp:include>

<title>Nueva Atracción</title>
</head>

<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>


	<main>
		<form action="createAtraccion.do" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default"><label
					for="name" class="col-form-label">Nombre:</label></span><input type="text"
					class="form-control" id="name" name="nombre" required
					value="${tmp_atraccion.nombre}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-lg">
			</div>

			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default"><label
					for="costo" class="col-form-label">Costo:</label></span><input
					type="number" class="form-control" id="costo" name="costo" required
					value="${tmp_atraccion.costo}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-lg">
			</div>

			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default"><label
					for="tiempo" class="col-form-label">Tiempo:</label></span><input
					type="number" class="form-control" id="tiempo" name="tiempo"
					required value="${tmp_atraccion.tiempo}"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-lg">
			</div>

			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default"><label
					for="cupo" class="col-form-label">Cupo:</label></span><input type="number"
					class="form-control" id="cupo" name="cupo" required
					value="${tmp_atraccion.cupo}" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-lg">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default"><label
					for="tipoAtraccion" class="col-form-label">Tipo de
						Atraccion:</label></span> <select class="form-select" id="tipoAtraccion"
					name="tipoAtraccion" required>
					<option selected>Seleccione una opción.</option>
					<option value="AVENTURA">AVENTURA</option>
					<option value="PAISAJE">PAISAJE</option>
					<option value="DEGUSTACION">DEGUSTACIÓN</option></select>
			</div>

			<div>
				<button type="submit" class="btn btn-primary">Guardar</button>
				<a onclick="window.history.back();" class="btn btn-secondary"
					role="button">Cancelar</a>
			</div>


		</form>

		<h1>Todas las atracciones</h1>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Costo</th>
					<th scope="col">Tiempo</th>
					<th scope="col">Cupo</th>
					<th scope="col">Tipo</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ atracciones }" var="tmp_atraccion">
				<tr>
					<th scope="row"><c:out value="${ tmp_atraccion.getNombre() }"></c:out></th>
					<td><c:out value="${ tmp_atraccion.getCosto() }"></c:out></td>
					<td><c:out value="${ tmp_atraccion.getTiempo() }"></c:out></td>
					<td><c:out value="${ tmp_atraccion.getCupo() }"></c:out></td>
					<td><c:out value="${ tmp_atraccion.getTipo() }"></c:out></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>


	</main>


</body>
</html>