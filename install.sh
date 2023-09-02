#!/bin/bash

echo "Compilando Agenda.java..."
javac Agenda.java

if [ $? -ne 0 ]; then
    echo "Error de compilación en Agenda.java."
    exit 1
fi

echo "Compilando dayMeeting.java..."
javac dayMeeting.java

if [ $? -ne 0 ]; then
    echo "Error de compilación en dayMeeting.java."
    exit 1
fi

echo "Compilando AgendaApp.java..."
javac AgendaApp.java

if [ $? -ne 0 ]; then
    echo "Error de compilación en dayMeeting.java."
    exit 1
fi

echo "Ejecutando el programa principal..."
java AgendaApp  # Reemplaza "MainClass" con el nombre de tu clase principal

if [ $? -ne 0 ]; then
    echo "Error al ejecutar el programa."
    exit 1
fi

echo "Programa ejecutado con éxito."
