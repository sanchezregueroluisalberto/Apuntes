#!/bin/bash

es_primo() {
    num=$1
    
    if [ "$num" -lt 2 ]; then
        echo "$num no es primo"
        return
    fi
    
    for ((i=2; i*i<=num; i++)); do
        if [ $((num % i)) -eq 0 ]; then
            echo "$num no es primo"
            return
        fi
    done
    
    echo "$num es primo"
}

es_primo "$1"