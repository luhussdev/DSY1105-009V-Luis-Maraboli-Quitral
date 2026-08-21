#!/usr/bin/env kotlin

// Revisar el repode la asignatura
// Archivo: estandar del repo del estudiante
// Seguir intrucciones


// val numero = "2000"

// Version "normal" o "tradicional"
val nota = 6.5
var estado = ""

if (nota >= 4.0) {
    estado = "Aprovado"
}else{
    estado = "Reprovado"
}

// Así se puede hacer en kotlin
val nota1 = 6.5
var estado1 = if(nota1 >= 4.0) {
    "Aprobado"
}else{
    "Reprobado"
}

// Version corta que se puede hacer en Kotlin
val nota2 = 6.5
var estado2 = if(nota2 >= 4.0) "aprobado" else "Reprobado"

//
val opcion = 2
var mensaje = ""
if(opcion == 1) {
    mensaje = "Crear"
}else if(opcion == 2) {
    mensaje = "Editar"
}else if(opcion == 3) {
    mensaje = "Eliminar"
}else {
    mensaje = "No disponible"
}

// Version corta
var mensaje1 = when (opcion) {
    1 -> "Crear"
    2 -> "Editar"
    3 -> "Eliminar"
    else -> "No disponible"
}

// solo se puede utilizar para cuando tenemos solo una varible que en este caso en "opcion"

// ciclo while
var contador = 0
while (contador < 10) {
    println(contador)
    contador++
}

// ciclo for
for (numero in 1..5){
    println()
}

// tambien si tenemos solo una linea dentro del for se puede hacer una sola linea
for (numero in 1..5) println()

// rango
//in .. -> 1..5 imprime 1,2,3,4,5
// until -> 1 until 5 imprime 1,2,3,4





