const canciones = document.querySelectorAll("li")
for (let i = 0; i < canciones.length; i++) {
    canciones[i].style.color = "green"
    canciones[i].textContent += "🎶"

}

//otra manera de hacerlo:
//  for (let cancion of canciones) {

// cancion.style.color = "green";

// cancion.textContent += " 🎶";
// }