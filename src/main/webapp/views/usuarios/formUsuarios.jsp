<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="input-group mb-3">
	<span class="input-group-text" id="inputGroup-sizing-default"><label
		for="name" class="col-form-label">Nombre:</label></span> <input type="text"
		class="form-control" id="name" name="username" required
		value="${tmp_user.username}" aria-label="Sizing example input"
		aria-describedby="inputGroup-sizing-lg">
</div>

<div class="input-group mb-3">
	<span class="input-group-text" id="inputGroup-sizing-default"><label
		for="password"
		class='col-form-label${tmp_user.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label></span>
	<input type="password" class="form-control" id="password"
		name="password" required value="${tmp_user.password}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("password")}'></c:out>
	</div>
</div>

<div class="input-group mb-3">
	<span class="input-group-text" id="inputGroup-sizing-default"><label
		for="admin" class="col-form-label">Administrador:</label></span> <input
		type="number" class="form-control" id="admin" name="admin" required
		value="${tmp_user.admin}">
</div>
<div class="input-group mb-3">
	<span class="input-group-text" id="inputGroup-sizing-default"><label
		for="tipoAtraccion" class="col-form-label">Tipo de Atraccion:</label></span>
	<select class="form-select" id="tipoAtraccion" name="tipoAtraccion"
		required>
		<option selected>Seleccione una opción.</option>
		<option value="AVENTURA">AVENTURA</option>
		<option value="PAISAJE">PAISAJE</option>
		<option value="DEGUSTACION">DEGUSTACIÓN</option>
	</select>
</div>

<div class="input-group mb-3">
	<span class="input-group-text" id="inputGroup-sizing-default"><label
		for="presupuesto"
		class='col-form-label${tmp_user.errors.get("preuspuesto") != null ? "is-invalid" : "" }'>
			Monedas:</label></span> <input class="form-control" type="number" id="presupuesto"
		name="presupuesto" required value="${tmp_user.presupuesto}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("presupuesto")}'></c:out>
	</div>
</div>

<div class="input-group mb-3">
	<span class="input-group-text" id="inputGroup-sizing-default"><label
		for="tiempoDisponible" class='col-form-label${tmp_user.errors.get("tiempoDisponible") != null ? "is-invalid" : "" }'>Tiempo:</label></span>
	<input class="form-control" type="number" id="tiempoDisponible"
		name="tiempoDisponible" required value="${tmp_user.tiempoDisponible}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("tiempoDisponible")}'></c:out>
	</div>
</div>
<div class="input-group mb-3">
	<span class="input-group-text" id="inputGroup-sizing-default"><label
		for="active" class="col-form-label">Active:</label></span> <input
		type="number" class="form-control" id="active" name="active" required
		value="${tmp_user.active}">
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>