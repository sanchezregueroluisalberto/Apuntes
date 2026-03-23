const apiUrl = "https://restcountries.com/v3.1/name/"

async function obtenerPais(nombre) {
    try {
        const respuesta = await fetch(`${apiUrl}${nombre}`)
        if (!respuesta.ok) {
            throw new Error("No se encontró el pais");
        }
        const datos = await respuesta.json();
        mostrarPais(datos[0])
    } catch (error) {
        console.error("Error al obtener el Pais: " + error);
    }
}

function mostrarPais(datos) {
    const contenedor = document.getElementById("resultado-nombre");
    const idiomas = Object.values(datos.languages).join(", ");
    const monedas = Object.values(datos.currencies)[0].name;


    contenedor.innerHTML = `
    <img src= "${datos.flags.svg}">
    <p>${datos.name.common}</p>
    <p>${datos.name.official}</p>
    <p>${datos.capital}</p>
    <p>${datos.region}</p>
    <p>${datos.subregion}</p>
    <p>${datos.population} personas </p>
    <ul>${idiomas}</ul>
    <ul>${monedas}</ul>
    `;
}

document.getElementById("form-nombre").addEventListener("submit", function (event) {
    event.preventDefault();
    const input = document.getElementById("input-nombre").value.trim().toLowerCase();
    if (input) {
        obtenerPais(input);
    }
});