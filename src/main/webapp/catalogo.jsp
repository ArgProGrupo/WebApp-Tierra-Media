<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="es">
<head>

<jsp:include page="/partials/head.jsp"></jsp:include>

    <title>Catálogo Tierra Media Expeditions++</title>
</head>

<body>

<jsp:include page="/partials/nav.jsp"></jsp:include>

<main>

<a class="btn btn-success" href="atracciones.do" role="button">Nueva Atracción</a>

<h2><a id="Aventura"></a>Aventura</h2>

	<div class="list-group">
	
	<c:forEach items="${ promociones }" var="promocion">
		<c:if test="${ promocion.getTipo() == 'AVENTURA' }">

		  <a href="#" class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ promocion.getNombrePromo() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		  <button class="btn edit btn-light"><i class="fa fa-edit"></i></button>
		  <button class="btn btn-danger"><i class="fa fa-trash"></i></button>
		  <button type="button" class="btn btn-primary">Comprar</button>
		  
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small>Detalle</small>
		  </a>
	  </c:if>
	</c:forEach>
	
<c:forEach items="${ atracciones }" var="atraccion">

		<c:if test="${ atraccion.getTipo() == 'AVENTURA' }">

		  <a role="button" href="comprar.do?id=${ atraccion.getIdAtraccion() }" class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ atraccion.getNombre() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		  <button class="btn edit btn-light"><i class="fa fa-edit"></i></button>
		  <button class="btn btn-danger"><i class="fa fa-trash"></i></button>
		  <!--<form action="" method="post" class="btn btn-primary">Comprar</form> -->
		    <button type="button" class="btn btn-primary">Comprar</button> 
		  
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small>Detalle</small>
		  </a>
	  </c:if>
	  
  
  </c:forEach>
  
    <h2><a id="Paisaje"></a>Paisaje</h2>
  
  <c:forEach items="${ promociones }" var="promocion">
		<c:if test="${ promocion.getTipo() == 'PAISAJE' }">

		  <a href="#" class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ promocion.getNombrePromo() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		  <button class="btn edit btn-light"><i class="fa fa-edit"></i></button>
		  <button class="btn btn-danger"><i class="fa fa-trash"></i></button>
		  <button type="button" class="btn btn-primary">Comprar</button>
		  
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small>Detalle</small>
		  </a>
	  </c:if>
	</c:forEach>
  
  <c:forEach items="${ atracciones }" var="atraccion">

		<c:if test="${ atraccion.getTipo() == 'PAISAJE' }">

		  <a href="#" class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ atraccion.getNombre() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		  <button class="btn edit btn-light"><i class="fa fa-edit"></i></button>
		  <button class="btn btn-danger"><i class="fa fa-trash"></i></button>
		  <button type="button" class="btn btn-primary">Comprar</button>
		  
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small>Detalle</small>
		  </a>
	  </c:if>
	  
  
  </c:forEach>
  
  <h2><a id="Degustación"></a>Degustación</h2>
  
  <c:forEach items="${ promociones }" var="promocion">
		<c:if test="${ promocion.getTipo() == 'DEGUSTACION' }">

		  <a href="#" class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ promocion.getNombrePromo() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		  <button class="btn edit btn-light"><i class="fa fa-edit"></i></button>
		  <button class="btn btn-danger"><i class="fa fa-trash"></i></button>
		  <button type="button" class="btn btn-primary">Comprar</button>
		  
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small>Detalle</small>
		  </a>
	  </c:if>
	</c:forEach>
  
  <c:forEach items="${ atracciones }" var="atraccion">

		<c:if test="${ atraccion.getTipo() == 'DEGUSTACION' }">

		  <a href="#" class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ atraccion.getNombre() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		  <button class="btn edit btn-light"><i class="fa fa-edit"></i></button>
		  <button class="btn btn-danger"><i class="fa fa-trash"></i></button>
		  <button type="button" class="btn btn-primary">Comprar</button>
		  
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small>Detalle</small>
		  </a>
	  </c:if>
	  
  
  </c:forEach>
  
 </div>



</main>
</body>
</html>