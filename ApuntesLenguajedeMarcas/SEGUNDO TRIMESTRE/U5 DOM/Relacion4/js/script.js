// voy a ir creando variables ejercicio por ejercicio y no todas arriba
// para a la hora de repasar que me sea mas facil y no calentarme la cabeza

//ej1
let imagenClick = document.getElementById("imgClick");

imagenClick.addEventListener("click", function () {
    alert("¡Siente la Energía de Burn!")
})
//ej2
const imagen = document.getElementById("imgHover")
const srcOriginal = imagen.src;

imagen.addEventListener("mouseover", function () {
    imagen.src = "https://picsum.photos/200?random=99"
})

imagen.addEventListener("mouseout", function () {
    imagen.src = srcOriginal
})

//ej3
const input = document.getElementById("campoTexto")


input.addEventListener("keydown", function (event) {
    alert(event.key)
})

// ej4
const formulario = document.getElementById("formulario")
const resultado = document.getElementById("resultado")
formulario.addEventListener("submit", function (event) {
    event.preventDefault()

    const nombre = document.getElementById("nombre").value
    resultado.textContent = "Energia recargada, " + nombre + "!"

})

//ej5
const codigo = document.getElementById("codigo")
const mensaje = document.getElementById("mensaje")

codigo.addEventListener("focus", function () {
    this.style.borderColor = "green"
    mensaje.textContent = "Introduce tu codigo de energia"
})
codigo.addEventListener("blur", function () {
    this.style.borderColor = ""
    mensaje.textContent = ""
})