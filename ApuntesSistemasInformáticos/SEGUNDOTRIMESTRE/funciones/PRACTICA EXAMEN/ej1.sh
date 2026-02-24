#!/bin/bash

#este validar es para para $@
validar_argumentos() {
    if [ $# -ne $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    else
        return 0
    fi
}

crear_directorio(){
    validar_argumentos 1 "$@" || return 1

    ruta="$1"
    padre=$(dirname "$ruta")

    if [ -d "$ruta" ]; then
    echo "Directorio de la '$ruta' ya existe"
    return 0
    fi

    if [ ! -d "$padre" ]; then
    echo "El directorio del '$padre' no existe"
    return 1

    fi

    if [ ! -w "$padre" ]; then
    echo "El directorio '$padre' no tiene los derechos de escritura"
    return 1

    fi

    mkdir -p "$ruta"

    if [  $? -eq 0 ]; then
    echo "Directorio de '$ruta' creado "

    else

    echo "Error creando el directorio de '$ruta' "
    return 1
    fi
}
crear_directorio "C:\Users\luiss\Documents\Apuntes\ApuntesSistemasInformáticos\SEGUNDOTRIMESTRE\funciones\PRACTICA EXAMEN\juegos"