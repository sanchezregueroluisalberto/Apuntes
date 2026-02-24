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


area_triangulo(){
    validar_argumentos 2 "$@" || return 1
    resultado=$(( $1 * $2 / 2 ))
    echo $resultado
    
}
area_triangulo 5 6