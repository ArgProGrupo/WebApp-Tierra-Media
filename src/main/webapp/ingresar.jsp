<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>

	<jsp:include page="/partials/head.jsp"></jsp:include>

    <title>Ingresar</title>
</head>

<body>

	

    <main class="form-signin">
        <div class="container w-50 mt-5 rounded shadow">
            <form action="ingresar" method="post">
                <div class="col-md-12 text-center">
                    <img class="mb-4" src="img/Logo_tierra_media.png" alt="Logo" width="150" height="100">
                </div>
                <h1 class="h3 mb-3 fw-normal">Ingresá tu nombre de usuario y contraseña</h1>
                
                <!-- 
                <div class="form-floating mb-3">
                    <input type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                    <label for="floatingInput">Email Usuario</label>
                
                </div>
                 -->
                 
                <div class="form-floating mb-3">
                    <input type="text" name="username" class="form-control" id="floatingUsername" placeholder="Squarejuggernaut">
                    <label for="floatingUsername">Nombre Usuario</label>
                
                </div>
                
                <div class="form-floating mb-3">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Contraseña</label>
                </div>
                
                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Recordarme
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
                <p class="mt-5 mb-3 text-muted"> - </p>
            </form>
        </div>
    </main>
    <% String flash = (String) request.getAttribute("flash"); %>
	
	<% if (flash != null) { %>
	<%= flash %>
	<% } %>
</body>
    
</html>