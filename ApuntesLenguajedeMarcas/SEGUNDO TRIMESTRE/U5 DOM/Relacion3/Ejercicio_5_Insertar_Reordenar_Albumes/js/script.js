const listaOrdenada = document.getElementById("albumes")
const referenciaTalco = document.getElementById("talco");
const nuevoLi = document.createElement("li")
const nuevoAlbumUltimoLista = document.createElement("li")
nuevoLi.textContent = "Xapomelon - La Pegatina"
listaOrdenada.insertBefore(nuevoLi, referenciaTalco)
nuevoAlbumUltimoLista.textContent = "Street Gigs - The Locos"
listaOrdenada.appendChild(nuevoAlbumUltimoLista)