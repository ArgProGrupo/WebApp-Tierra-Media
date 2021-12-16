<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>

	<jsp:include page="/partials/head.jsp"></jsp:include>

    <title>Usuarios Tierra Media Expeditions++</title>
</head>

<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>

<main> 

<a class="btn btn-success" href="nuevoUsuario.adm" role="button">Nuevo Usuario</a>

<div class="row row-cols-1 row-cols-md-2 g-4">

<c:forEach items="${usuarios}" var="tmp_usuario">

  <div class="col">
    <div class="card">
      
      <div class="card-body">
        <h5 class="card-title"><c:out value="${ tmp_usuario.getNombre() }"></c:out></h5>
	    <ul>
		    <li class="list-group-item"><b><c:out value="${ tmp_usuario.getTipoAtraccionFavorita() }"></c:out></b></li>
		    <li class="list-group-item"><c:out value="${ tmp_usuario.getPresupuesto() }"></c:out></li>
		    <li class="list-group-item"><c:out value="${ tmp_usuario.getTiempo() }"></c:out></li>
		    <li class="list-group-item"><c:out value="${ tmp_usuario.getItinerarioUsuario() }"></c:out></li>
		    <!-- <li class="list-group-item"><c:out value="${ tmp_usuario.getItinerarioString() }"></c:out> </li> -->
	    </ul>
	    <a class="btn btn-warning" role="button" href="editUsuarios.adm?id=${ tmp_usuario.getIdUsuario() }">Editar Usuario</a>
	    <a class="btn btn-danger" role="button" href="deleteUsuarios.adm?name=${ tmp_usuario.getNombre() }">Borrar Usuario</a>
      </div>
    </div>
  </div>
  
  </c:forEach>
  </div>
</main>
</body>
</html>