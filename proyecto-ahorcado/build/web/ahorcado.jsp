<%-- 
    Document   : index
    Created on : 1/09/2025, 21:46:16
    Author     : edvin
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Palabra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Juego de Ahorcado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilo-ahorcado.css"/>
    </head>
    <body>
        
        <header>
            <nav class="navbar navbar-light bg-light">
            <form action="Controlador" method="get" class="form-inline">
                <input type="hidden" name="menu" value="log">
                <button class="btn btn-sm btn-outline-secondary" type="submit">Salir</button>
            </form>

          </nav>
        </header>
        
        <div class="contenedor-principal">
            <h1 class="titulo">Juego del ahorcado</h1>
            <button onclick="pausarTemporizador()" id="stop">Pausar</button>
            <button onclick="reanudarTemporizador()" id="reanudar">Reanudar</button>
                <p id="tempo"></p>
            <h1 id="msg-final"></h1>
            
            
            <div class="fila-flexible-ahorcado sin-ajuste">
                
              <picture>
                <img src="img/ahorcado_6.png" alt="" id="image6">
                <img src="img/ahorcado_5.png" alt="" id="image5">
                <img src="img/ahorcado_4.png" alt="" id="image4">
                <img src="img/ahorcado_3.png" alt="" id="image3">
                <img src="img/ahorcado_2.png" alt="" id="image2">
                <img src="img/ahorcado_1.png" alt="" id="image1">
                <img src="img/ahorcado_0.png" alt="" id="image0">
              </picture>
                
                <h2 class="palabra" id="palabra"></h2>
                <h3 id="acierto"></h3>
                   
                
                <button onclick="inicio()" id="reinicio">Elegir otra palabra</button>
            </div>
            
            <div class="fila-flexible-datos" id="turnos">
              <div class="columna">

                <h3>Intentos restantes: <span id="intentos">6</span></h3>
              </div>
              <div class="columna">
                
                <button onclick="pista()" id="pista">Pistas!</button>
                
                
                <span id="hueco-pista"></span>
              </div>
            </div>

            <div class="fila-flexible">
              <div class="columna">
                <div class="fila-flexible" id="abcdario">
                </div>
              </div>
            </div>
            
            <picture>
                <img src="" id="imagenPalabra"/>
            </picture>
          </div>
            <%List<Palabra> lista = (List<Palabra>) request.getAttribute("palabrasDB");%>

            <script>
                const palabras = [
                <% if (lista != null && !lista.isEmpty()) {
                       for (int i = 0; i < lista.size(); i++) {
                           Palabra p = lista.get(i); %>
                    ["<%= p.getNombre() %>", ["<%= p.getPista1() %>", "<%= p.getPista2() %>", "<%= p.getPista3() %>"], "img/<%= p.getImagen() %>"]<%= (i < lista.size() - 1) ? "," : "" %>
                <%     }
                   } else { %>
                    ["PRUEBA", ["Pista uno", "Pista dos", "Pista tres"], "img/prueba.png"]
                <% } %>
                ];


            </script>

        <script src="js/ahorcado.js"></script>
    </body>
</html>
