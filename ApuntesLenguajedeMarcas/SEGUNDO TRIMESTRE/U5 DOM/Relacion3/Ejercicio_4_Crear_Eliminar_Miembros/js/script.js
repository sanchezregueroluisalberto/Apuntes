const lista = document.getElementById("integrantes")
const items = document.getElementsByTagName("li");
const nuevoTrompetista = document.createElement("li")
nuevoTrompetista.textContent = "Trompetista"
lista.appendChild(nuevoTrompetista)

for (let i = 0; i < items.length; i++) {
    if (items[i].textContent == "Batería") {

        lista.removeChild(items[i])
        i--; // no se para que sirve pero bueno no cambia nada aparentemente si no lo usas
    }
}