
let palabra = "";
let random;
let oculta = [];
let cont = 6;
let tiempoRestante=121;
let temporizador;

const hueco = document.getElementById("palabra");
const buttons = document.getElementsByClassName('letra');
const btnInicio = document.getElementById("reinicio");

// Escoger palabra al azar
function generaPalabra() {
  random = Math.floor(Math.random() * palabras.length);
  palabra = palabras[random][0].toUpperCase();
}

function iniciarTemporizador() {
    clearInterval(temporizador);
    enPausa = false;
    document.getElementById("tempo").innerHTML = tiempoRestante + " segundos";

    temporizador = setInterval(() => {
        if (!enPausa) {
            if (tiempoRestante > 0) {
                document.getElementById("tempo").innerHTML = tiempoRestante + " segundos";
                tiempoRestante--;
            } else {
                document.getElementById("tempo").innerHTML = "0 segundos";
                window.alert("Perdiste el juego :(");
                clearInterval(temporizador);
            }
        }
    }, 1000);
}

function pausarTemporizador() {
    document.getElementById('stop').style.display = "none";
    document.getElementById('reanudar').style.display = "block";
    enPausa = true;
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].disabled = true;
      }
}

function reanudarTemporizador() {
    document.getElementById('reanudar').style.display = "none";
    enPausa = false;
    document.getElementById('stop').style.display = "block";
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].disabled = false;
      }
}

// Funcion para agregar los guiones de la palabra
function pintarGuiones(num) {
    oculta = [];
    for (let i = 0; i < num; i++) {
        oculta[i] = "_";
    }
    hueco.innerHTML = oculta.join(" ");
}

// Generar abecedario
function GenerarLetras() {
    const contenedor = document.getElementById("abcdario");
    const letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    
    contenedor.innerHTML = "";
    
    for (let letra of letras) {
        let btn = document.createElement("button");
        btn.textContent = letra;
        btn.value = letra;
        btn.id = letra;
        btn.className = "letra";
        btn.onclick = () => intento(letra);
        contenedor.appendChild(btn);
    }
}

// Chequear intento
function intento(letra) {
    document.getElementById(letra).disabled = true;
    if (quitarTildes(palabra).indexOf(quitarTildes(letra)) != -1) {
      for (let i = 0; i < palabra.length; i++) {
        if (quitarTildes(palabra[i]) == quitarTildes(letra)) {
            oculta[i] = palabra[i];
        }
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
        let pistas = palabras[random][1];
        document.getElementById("hueco-pista").innerHTML = pistas[indicePista];
        indicePista++;

        if (indicePista >= pistas.length) {
            indicePista = 0;
        }
    }

// Comprueba si ha finalizado
function compruebaFin() {
    if (oculta.indexOf("_") == -1) {
      pausarTemporizador();
      document.getElementById("msg-final").innerHTML = "Felicidades !!";
      document.getElementById("msg-final").className += "zoom-in";
      document.getElementById("palabra").className += " encuadre";
      for (let i = 0; i < buttons.length; i++) {
        buttons[i].disabled = true;
      }
      document.getElementById("reinicio").innerHTML = "Empezar de nuevo";
        btnInicio.onclick = function () {
            inicio();
        };

    } else if (cont == 0) {
      pausarTemporizador();
      document.getElementById("msg-final").innerHTML = "Game Over";
      document.getElementById("msg-final").className += "zoom-in";
      hueco.innerHTML="La palabra es: "+palabra;
      for (let i = 0; i < buttons.length; i++) {
        buttons[i].disabled = true;
      }
      document.getElementById("reinicio").innerHTML = "Empezar de nuevo";
      btnInicio.onclick = function () { location.reload() };
    }
}

// Restablecer juego
function inicio() {
    iniciarTemporizador();
    tiempoRestante = 120; 
    document.getElementById('reanudar').style.display = "none";
    document.getElementById('stop').style.display = "block";
    generaPalabra();
    pintarGuiones(palabra.length);
    GenerarLetras();
    indicePista = 0;
    
    cont = 6;
    document.getElementById("intentos").innerHTML = cont;   

    document.getElementById("msg-final").innerHTML = "";
    document.getElementById("msg-final").className = "";
    document.getElementById("acierto").innerHTML = "";
    document.getElementById("acierto").className = "";
    document.getElementById("hueco-pista").innerHTML = "";
    document.getElementById("palabra").className = "";

    for (let i = 0; i <= 6; i++) {
        document.getElementById("image" + i).className = "";
    }

    document.getElementById("image6").classList.add("fade-in");
}

function quitarTildes(str) {
  return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}


document.addEventListener("keydown", function (event) {
    let letra = event.key.toUpperCase();

    if (/^[A-ZÑ]$/.test(letra)) {
        if (document.getElementById(letra) && !document.getElementById(letra).disabled) {
            intento(letra);
        }
    }
});


window.onload = inicio;