#!/bin/bash

# Ejecutar el programa Java
javac *.java
java Agenda

# Preguntar si deseas hacer un commit
read -p "¿Deseas hacer un commit de los archivos? (y/n): " response

if [ "$response" == "y" ] || [ "$response" == "Y" ]; then
    # Solicitar una descripción para el commit
    read -p "Ingresa una descripción para el commit: " desc
    
    # Realizar el commit
    git add .
    git commit -m "$desc"
    echo "Commit realizado con éxito."
else
    echo "No se realizó ningún commit."
fi
