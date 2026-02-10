const frutas = document.getElementsByTagName("li")
const boton = document.getElementById("marcarFrutas");

for (let fruta of frutas) {
    lista.style.border = "2px solid orange"
}
boton.onclick = function() {
    for (let fruta of frutas) {
        lista.style.backgroundColor = "palegreen";
        fruta.innerHTML += "✅ "
    }
};