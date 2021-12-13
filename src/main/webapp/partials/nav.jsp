<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header>
	<nav class="navbar navbar-expand-md navbar-dark colorbarra" aria-label="Fourth navbar example">
        <div class="container">
        
          <a class="navbar-brand" href="#"><img src="assets/img/Logo_tierra_media.png" alt="Logo"></a>
          
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          
          <div class="collapse navbar-collapse" id="navbarsExample04">
            <ul class="navbar-nav menu ms-auto mb-2 mb-md-0" data-animation="center">
              <li class="nav-item">
                <a class="nav-link active colorfont" aria-current="page" href="/TierraMediaWeb/index.jsp">Inicio</a>
              </li>
              
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/TierraMediaWeb/catalogo.do" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">Catálogo</a>
                <ul class="dropdown-menu" aria-labelledby="dropdown04">
                  <li><a class="dropdown-item" href="/TierraMediaWeb/catalogo.do#Aventura">Aventura</a></li>
                  <li><a class="dropdown-item" href="/TierraMediaWeb/catalogo.do#Paisaje">Paisaje</a></li>
                  <li><a class="dropdown-item" href="/TierraMediaWeb/catalogo.do#Degustación">Degustación</a></li>
                </ul>
              </li>
              
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-bs-toggle="dropdown" aria-expanded="false"><c:out value="${ usuario.getNombre() }"></c:out></a>
                <ul class="dropdown-menu" aria-labelledby="dropdown05">
                  <li><a class="dropdown-item" href="#">Monedas: <c:out value="${ usuario.getPresupuesto() }"></c:out></a></li>
                  <li><a class="dropdown-item" href="#">Tiempo: <c:out value="${ usuario.getTiempo() }"></c:out></a></li>
                  <c:if test="${ usuario.isAdmin() }">
                  <li><a class="dropdown-item" href="/TierraMediaWeb/usuarios.do">Editar Usuarios</a></li>
                  </c:if>
                  <li><a class="dropdown-item" href="/TierraMediaWeb/logout">Salir</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>
</header>