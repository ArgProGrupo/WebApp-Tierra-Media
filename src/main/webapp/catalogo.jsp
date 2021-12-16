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

<h2><a id="Aventura"></a>Aventura</h2>

	<div class="list-group">
	
	<c:forEach items="${ promociones }" var="promocion">
	
	<c:out value="${ promocion.calcularCosto() }"></c:out>
		<c:if test="${ promocion.getTipo() == 'AVENTURA' }">

		  <div class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ promocion.getNombrePromo() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		      
		      <c:choose>
			  <c:when test="${ usuario.getPresupuesto() > 1 && promocion.calcularCupo() > 0 }">
		      
		  <a role="button" href="comprarPromo.do?id=${ promocion.getIdPromocion() }" class="btn btn-primary" aria-current="true">Comprar</a>
		 
		 </c:when>
		 
		 <c:otherwise>
					<a href="#" class="btn btn-secondary rounded disabled" role="button">No se puede comprar</a>
				</c:otherwise>
				
		  </c:choose>
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small> <c:out value="Costo: ${ promocion.calcularCosto() } - 
		    					Tiempo: ${ promocion.calcularTiempo() } -
		    					Cupo: 	${ promocion.calcularCupo() }"></c:out> </small>
		  </div>
	  </c:if>
	</c:forEach>
	
<c:forEach items="${ atracciones }" var="atraccion">

		<c:if test="${ atraccion.getTipo() == 'AVENTURA' }">

		  <div class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ atraccion.getNombre() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		  <!--<form action="" method="post" class="btn btn-primary">Comprar</form> -->
		  
		  <c:choose>
			  <c:when test="${ usuario.puedeComprar(atraccion) && atraccion.getCupo() > 0  }">
			   		<a role="button" href="comprarAtraccion.do?id=${ atraccion.getIdAtraccion() }" class="btn btn-primary" aria-current="true">Comprar</a>
			  </c:when>
			  <c:otherwise>
					<a href="#" class="btn btn-secondary rounded disabled" role="button">No se puede comprar</a>
				</c:otherwise>
			</c:choose>
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small> <c:out value="Costo: ${ atraccion.getCosto() } - 
		    					Tiempo: ${ atraccion.getTiempo() } -
		    					Cupo: 	${ atraccion.getCupo() }"></c:out> </small>
		  </div>
	  </c:if>
	  
  
  </c:forEach>
  
    <h2><a id="Paisaje"></a>Paisaje</h2>
  
  <c:forEach items="${ promociones }" var="promocion">
		<c:if test="${ promocion.getTipo() == 'PAISAJE' }">

		  <div class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ promocion.getNombrePromo() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		      
		      <c:choose>
			  <c:when test="${ usuario.getPresupuesto() > 1000 && promocion.calcularCupo() > 0  }">
		  <a role="button" href="comprarPromo.do?id=${ promocion.getIdPromocion() }" class="btn btn-primary" aria-current="true">Comprar</a>
		  
		  </c:when>
		  
		  <c:otherwise>
					<a href="#" class="btn btn-secondary rounded disabled" role="button">No se puede comprar</a>
				</c:otherwise>
		  </c:choose>
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small><c:out value="Costo: ${ promocion.calcularCosto() } - 
		    					Tiempo: ${ promocion.calcularTiempo() } -
		    					Cupo: 	${ promocion.calcularCupo() }"></c:out></small>
		  </div>
	  </c:if>
	</c:forEach>
  
  <c:forEach items="${ atracciones }" var="atraccion">

		<c:if test="${ atraccion.getTipo() == 'PAISAJE' }">

		  <div class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ atraccion.getNombre() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		      
		      <c:choose>
			  <c:when test="${ usuario.puedeComprar(atraccion) && atraccion.getCupo() > 0  }">
		 <a role="button" href="comprarAtraccion.do?id=${ atraccion.getIdAtraccion() }" class="btn btn-primary" aria-current="true">Comprar</a>
		  
		  </c:when>
		  </c:choose>
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small><c:out value="Costo: ${ atraccion.getCosto() } - 
		    					Tiempo: ${ atraccion.getTiempo() } -
		    					Cupo: 	${ atraccion.getCupo() }"></c:out></small>
		  </div>
	  </c:if>
	  
  
  </c:forEach>
  
  <h2><a id="Degustación"></a>Degustación</h2>
  
  <c:forEach items="${ promociones }" var="promocion">
		<c:if test="${ promocion.getTipo() == 'DEGUSTACION' }">

		  <div class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ promocion.getNombrePromo() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		      
		      <c:choose>
			  <c:when test="${ usuario.getPresupuesto() > 1000 && promocion.calcularCupo() > 0  }">
			  
		  <a role="button" href="comprarPromo.do?id=${ promocion.getIdPromocion() }" class="btn btn-primary" aria-current="true">Comprar</a>
		  
		  </c:when>
		  
		  <c:otherwise>
					<a href="#" class="btn btn-secondary rounded disabled" role="button">No se puede comprar</a>
				</c:otherwise>
				
		  </c:choose>
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small><c:out value="Costo: ${ promocion.calcularCosto() } - 
		    					Tiempo: ${ promocion.calcularTiempo() } -
		    					Cupo: 	${ promocion.calcularCupo() }"></c:out></small>
		  </div>
	  </c:if>
	</c:forEach>
  
  <c:forEach items="${ atracciones }" var="atraccion">

		<c:if test="${ atraccion.getTipo() == 'DEGUSTACION' }">
		
		  <div class="list-group-item list-group-item-action" aria-current="true">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1"><c:out value="${ atraccion.getNombre() }"></c:out> </h5>
		      <div class="btn-group" role="group" aria-label="Button group">
		      
		      <c:choose>
			  <c:when test="${ usuario.puedeComprar(atraccion) && atraccion.getCupo() > 0  }">
			  
		  <a role="button" href="comprarAtraccion.do?id=${ atraccion.getIdAtraccion() }" class="btn btn-primary" aria-current="true">Comprar</a>
		  
		 </c:when>
		 </c:choose>
		  
	
		</div>
		    </div>
		    <p class="mb-1">Descripción</p>
		    <small><c:out value="Costo: ${ atraccion.getCosto() } - 
		    					Tiempo: ${ atraccion.getTiempo() } -
		    					Cupo: 	${ atraccion.getCupo() }"></c:out></small>
		  </div>
	  </c:if>
	  
  
  </c:forEach>
  
 </div>



</main>
</body>
</html>