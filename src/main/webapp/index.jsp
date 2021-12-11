<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>

	<jsp:include page="/partials/head.jsp"></jsp:include>

<title>Tierra Media Expeditions ++</title>
</head>
<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>
	
	<main>
		
		<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="10000">
      <img src="assets/img/paisaje.jfif" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Bienvenide</h5>
        <p>¡Vení a pasear por los bosques oscuros!</p>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="assets/img/degustacion.jfif" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Tierra Media ++</h5>
        <p>¡Tomá cerveza en El Pony Pisador!</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="assets/img/aventura.jfif" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Disfrutá la experiencia</h5>
        <p>Si tenés tiempo, salvás al mundo del Señor Oscuro</p>
      </div>
    </div>
  </div>
 <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
		<div class="box">
		<div class="card" style="width: 18rem;">
  <img src="assets/img/aventura.jfif" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Aventura</h5>
    <p class="card-text">Luchá en batallas épicas contra dragones, orcos y trolls. Tenés la oportunidad única de salvar el Destino de la Tierra Media </p>
    <a href="catalogo.jsp#Aventura" class="btn btn-primary">¡A por ello!</a>
  </div>
</div>
	<div class="card" style="width: 18rem;">
  <img src="assets/img/paisaje.jfif" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Paisajes</h5>
    <p class="card-text">Escuchá el viento entre los árboles que hablan, sentí el frío de las montañas nevadas y contemplá la imponencia de los castillos medievales</p>
    <a href="catalogo.jsp#Paisaje" class="btn btn-primary"><i>Taking the hobbits to Isengard!</i></a>
  </div>
</div>
	<div class="card" style="width: 18rem;">
  <img src="assets/img/degustacion.jfif" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Degustación</h5>
    <p class="card-text">Disfrutá del hidromiel y de los postres caseros de La comarca. Embriagate con las bebidas refinadas de los elfos y bailá al son de las flautas mágicas</p>
    <a href="catalogo.jsp#Degustación" class="btn btn-primary">¡Salud!</a>
  </div>
</div>
</div>
	</main>
</body>
</html>