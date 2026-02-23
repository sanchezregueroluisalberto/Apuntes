#!/bin/bash

# este validar es solo para $#
validar(){
    if [ $1 -ne $2 ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    fi
}

multiplicar(){
    validar 2 $# || return 1
    if [ $1 -lt 0 ] || [ $2 -lt 0 ]; then
    echo "No pueden ser menores que 0"
    return 1

    else
    resultado=$(( $1 * $2 ))
    echo $resultado
    fi
}
multiplicar 3 2