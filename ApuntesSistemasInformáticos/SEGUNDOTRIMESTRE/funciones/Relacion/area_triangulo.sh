#!/bin/bash

#este validar es para para $@
validar_argumentos() {
    if [ $# -ne $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos"
        echo false
    else
        echo true
    fi
}


area_triangulo(){
    validar_argumentos 2 $@
}