<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>

	<jsp:include page="/partials/head.jsp"></jsp:include>

    <title>Usuarios Tierra Media Expeditions++</title>
</head>

<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>

<main> 

<a class="btn btn-success" href="nuevoUsuario.jsp" role="button">Nuevo Usuario</a>

<div class="row row-cols-1 row-cols-md-2 g-4">

  <div class="col">
    <div class="card">
      <img src="img/eowyn.png" class="card-img-top" alt="..." >
      <div class="card-body">
        <h5 class="card-title">Eowyn</h5>
	    <ul>
		    <li class="list-group-item"><b>Aventura</b></li>
		    <li class="list-group-item">10 monedas</li>
		    <li class="list-group-item">8 horas</li>
		    <li class="list-group-item">Itinerario: </li>
	    </ul>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="img/gandalf.png" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Gandalf</h5>
        <ul>
	        <li class="list-group-item"><b>Paisaje</b></li>
	    	<li class="list-group-item">100 monedas</li>
	    	<li class="list-group-item">8 horas</li>
	    	<li class="list-group-item">Itinerario: </li>
	    </ul>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="img/sam.png" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Sam</h5>
        <ul>
	        <li class="list-group-item"><b>Degustación</b></li>
	    	<li class="list-group-item">36 monedas</li>
	    	<li class="list-group-item">8 horas</li>
	    	<li class="list-group-item">Itinerario: </li>
	    </ul>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="img/galadriel.png" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Galadriel</h5>
        <ul>
	        <li class="list-group-item"><b>Paisaje</b></li>
	    	<li class="list-group-item">120 monedas</li>
	    	<li class="list-group-item">6 horas</li>
	    	<li class="list-group-item">Itinerario: </li>
	    </ul>
      </div>
    </div>
  </div>
</div>


</main>
</body>
</html>