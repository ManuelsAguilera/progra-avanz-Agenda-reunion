@echo off
echo Compilando Agenda.java...
javac Agenda.java

if errorlevel 1 (
    echo Error de compilación en Agenda.java.
    pause
    exit /b
)

echo Compilando dayMeeting.java...
javac dayMeeting.java

if errorlevel 1 (
    echo Error de compilación en dayMeeting.java.
    pause
    exit /b
)

echo Compilando AgendaApp.java...
javac AgendaApp.java

if errorlevel 1 (
    echo Error de compilación en AgendaApp.java.
    pause
    exit /b
)

echo Ejecutando el programa principal...
java AgendaApp

if errorlevel 1 (
    echo Error al ejecutar el programa.
    pause
    exit /b
)

echo Programa ejecutado con éxito.
pause
