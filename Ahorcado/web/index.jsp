<%-- 
    Document   : index
    Created on : 1/09/2025, 21:46:16
    Author     : edvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilo-ahoracado.css"/>
    </head>
    <body>
        <div class="contenedor-principal">
            <h1 class="titulo">Juego del ahorcado</h1>
            <h1 id="msg-final"></h1>
            <h3 id="acierto"></h3>
            
            <div class="fila-flexible sin-ajuste">
              <h2 class="palabra" id="palabra"></h2>
              <picture>
                <img src="img/ahorcado_6.png" alt="" id="image6">
                <img src="img/ahorcado_5.png" alt="" id="image5">
                <img src="img/ahorcado_4.png" alt="" id="image4">
                <img src="img/ahorcado_3.png" alt="" id="image3">
                <img src="img/ahorcado_2.png" alt="" id="image2">
                <img src="img/ahorcado_1.png" alt="" id="image1">
                <img src="img/ahorcado_0.png" alt="" id="image0">
              </picture>
            </div>
            
            <div class="fila-flexible" id="turnos">
              <div class="columna">
                <h3>Intentos restantes: <span id="intentos">6</span></h3>
              </div>
              <div class="columna">
                <button onclick="inicio()" id="reinicio">Elegir otra palabra</button>
                <button onclick="pista()" id="pista">Dame una pista!</button>
                <span id="hueco-pista"></span>
              </div>
            </div>

            <div class="fila-flexible">
              <div class="columna">
                <div class="fila-flexible" id="abcdario">
                </div>
              </div>
              <div class="columna"></div>
            </div>

          </div>
        <script src="js/ahorcado.js"></script>
    </body>
</html>
