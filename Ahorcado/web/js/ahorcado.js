let palabras = [["atlantico", "Un océano"], ["Computadora", "Una máquina"], ["Asus", "Marca de Computadoras"], ["plaza", "Espacio público"], ["rueda", "Gran invento"]];
let palabra = "";
let random;
let oculta = [];
const hueco = document.getElementById("palabra");
let cont = 6;
const buttons = document.getElementsByClassName('letra');
const btnInicio = document.getElementById("reset");

// Escoger palabra al azar
function generaPalabra() {
  random = Math.floor(Math.random() * palabras.length);
  palabra = palabras[random][0].toUpperCase();
  console.log(palabra);
}

// Funcion para pintar los guiones de la palabra
function pintarGuiones(num) {
  for (let i = 0; i < num; i++) {
    oculta[i] = "_";
  }
  hueco.innerHTML = oculta.join(" ");
}

// Generar abecedario
function generaABC(a, z) {
  document.getElementById("abcdario").innerHTML = "";
  let i = a.charCodeAt(0), j = z.charCodeAt(0);
  let letra = "";
  for (; i <= j; i++) {
    letra = String.fromCharCode(i).toUpperCase();
    document.getElementById("abcdario").innerHTML += "<button value='" + letra + "' onclick='intento(\"" + letra + "\")' class='letra' id='" + letra + "'>" + letra + "</button>";
    if (i == 110) {
      document.getElementById("abcdario").innerHTML += "<button value='Ñ' onclick='intento(\"Ñ\")' class='letra' id='" + letra + "'>Ñ</button>";
    }
  }
}

// Chequear intento
function intento(letra) {
  document.getElementById(letra).disabled = true;
  if (palabra.indexOf(letra) != -1) {
    for (let i = 0; i < palabra.length; i++) {
      if (palabra[i] == letra) oculta[i] = letra;
    }
    hueco.innerHTML = oculta.join(" ");
    document.getElementById("acierto").innerHTML = "Bien!";
    document.getElementById("acierto").className += "acierto verde";
  } else {
    cont--;
    document.getElementById("intentos").innerHTML = cont;
    document.getElementById("acierto").innerHTML = "Fallo!";
    document.getElementById("acierto").className += "acierto rojo";
    document.getElementById("image" + cont).className += "fade-in";
  }
  compruebaFin();
  setTimeout(function () {
    document.getElementById("acierto").className = "";
  }, 800);
}

// Obtener pista
function pista() {
  document.getElementById("hueco-pista").innerHTML = palabras[random][1];
}

// Comprueba si ha finalizado
function compruebaFin() {
  if (oculta.indexOf("_") == -1) {
    document.getElementById("msg-final").innerHTML = "Felicidades !!";
    document.getElementById("msg-final").className += "zoom-in";
    document.getElementById("palabra").className += " encuadre";
    for (let i = 0; i < buttons.length; i++) {
      buttons[i].disabled = true;
    }
    document.getElementById("reset").innerHTML = "Empezar";
    btnInicio.onclick = function () { location.reload() };
  } else if (cont == 0) {
    document.getElementById("msg-final").innerHTML = "Game Over";
    document.getElementById("msg-final").className += "zoom-in";
    for (let i = 0; i < buttons.length; i++) {
      buttons[i].disabled = true;
    }
    document.getElementById("reset").innerHTML = "Empezar";
    btnInicio.onclick = function () { location.reload() };
  }
}

// Restablecer juego
function inicio() {
  generaPalabra();
  pintarGuiones(palabra.length);
  generaABC("a", "z");

  cont = 6;
  document.getElementById("intentos").innerHTML = cont;

  // Resetear mensajes y clases
  document.getElementById("msg-final").innerHTML = "";
  document.getElementById("msg-final").className = "";
  document.getElementById("acierto").innerHTML = "";
  document.getElementById("acierto").className = "";
  document.getElementById("hueco-pista").innerHTML = "";
  document.getElementById("palabra").className = "";

  // Resetear imágenes del ahorcado
  for (let i = 0; i <= 5; i++) {
    document.getElementById("image" + i).className = "";
  }
}

window.onload = inicio;
