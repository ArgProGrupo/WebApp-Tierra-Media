<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>

<title>Lista de todas las atracciones</title>
</head>
<body>

<jsp:include page="/partials/nav.jsp"></jsp:include>

<h1>Lista de todas las atracciones</h1>

	<c:if test="${ usuario.isAdmin() }">
		<a href="create.adm">Crear Nueva Atracción</a>
	</c:if>
	
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
			<c:forEach items="${ atracciones }" var="atraccion">
					<tr>
						<th scope="row"><c:out value="${ atraccion.getNombre() }"></c:out></th>
						<td><c:out value="${ atraccion.getCosto() }"></c:out></td>
						<td><c:out value="${ atraccion.getTiempo() }"></c:out></td>
						<td><c:out value="${ atraccion.getCupo() }"></c:out></td>
						<td><c:out value="${ atraccion.getTipo() }"></c:out></td>
						<td>
							<c:choose>
								<c:when test="${ usuario.isAdmin() }">
									<a href="edit.adm?id=${ atraccion.getIdAtraccion() }">Editar</a>
									<a href="borrar.adm?id=${ atraccion.getIdAtraccion() }">Borrar</a>
								</c:when>
								<c:otherwise>
									<a href="comprarAtraccion.do?id=${ atraccion.getIdAtraccion() }">Comprar</a>
								</c:otherwise>
							</c:choose>
							
							</td>
						
						
					</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>