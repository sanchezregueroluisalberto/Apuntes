const animales = document.getElementsByClassName("animal");
const boton = document.getElementById("resaltarAnimales");

for (const animal of animales) {
    animal = "lightyellow";
}

boton.onclick = function() {
    for (const animal of animales) {
        animal.style.color = "green";
        animal.style.fontSize = "30px";
    }
};