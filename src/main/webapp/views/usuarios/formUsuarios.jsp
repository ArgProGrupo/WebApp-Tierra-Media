<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<div class="mb-3">
	<label for="name" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="name" name="username" required
		value="${tmp_user.username}">
</div>

<div class="mb-3">
	<label for="password"
		class='col-form-label ${tmp_user.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label>
	<input type="password" class="form-control" id="password"
		name="password" required value="${tmp_user.password}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("password")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="admin" class="col-form-label">Administrador:</label> <input
		type="number" class="form-control" id="admin" name="admin" required
		value="${tmp_user.admin}">
</div>

<div class="mb-3">
	<label for="tipoAtraccion" class="col-form-label">Tipo
		Atraccion Favorita:</label> <input type="text" class="form-control"
		id="tipoAtraccion" name="tipoAtraccion" required
		value="${tmp_user.tipoAtraccion}">
	<!-- ${tmp_user.tipoAtraccion} -->
	<!-- ${tmp_user.errors.get("atraccionFavorita")} -->

</div>

<div class="mb-3">
	<label for="presupuesto"
		class='col-form-label ${tmp_user.errors.get("preuspuesto") != null ? "is-invalid" : "" }'>Monedas:</label>
	<input class="form-control" type="number" id="presupuesto"
		name="presupuesto" required value="${tmp_user.presupuesto}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("presupuesto")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="tiempoDisponible"
		class='col-form-label ${tmp_user.errors.get("tiempoDisponible") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="tiempoDisponible"
		name="tiempoDisponible" required value="${tmp_user.tiempoDisponible}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("tiempoDisponible")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="active" class="col-form-label">Active:</label> <input
		type="number" class="form-control" id="active" name="active" required
		value="${tmp_user.active}">
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>