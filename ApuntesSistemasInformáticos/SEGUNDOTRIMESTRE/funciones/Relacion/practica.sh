#!/bin/bash

validar(){
    if [ $# -lt $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    else
        return 0
    fi
}

maximo(){
validar 1 "$@" || return 1
    numeroMaximo=$1

    for numero in "$@"; do
        if [ "$numero" -gt "$numeroMaximo" ]; then
            numeroMaximo=$numero
        fi
    done
    echo "El numero mas grande de los introducidos es: $numeroMaximo"
}
maximo 2 4 5 6 8 1