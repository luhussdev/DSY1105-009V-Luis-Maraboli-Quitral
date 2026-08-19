#!/usr/bin/env kotlin

// En Kotlin los tipos de datos primitivos siempre empiezan con mayúscula inicial.

// incorrecto string -> correcto String
// incorrecto int -> correcto Int

// Tipo de datos
// String
// Int
// Boolean

// Kotlin tiene inferencia de tipos (detecta el tipo automáticamente), pero cuando los declaras explicitamente
// debes usar la mayúscula.

// Interencia (Kotlin deduce el tipo):
// val nombre = "Carlos"
// var edad = 40

// Declaración explícita:
// val nombre: String = "Carlos"
// var edad: Int = 40
// val esEstudiante: Boolean = true

// val (Value): Inmutable (solo lectura). Equivale a una constante o a final en Java.
// var (Variable): Mutable (se puede reasignar). Úsalo solo si el valor va a cambiar en el tiempo.

// Métodos para Imprimir en pantalla
// print(): Imprime el texto y deja el cursor en la misma linea.
// println(): Imprime el texto y hace un salto de línea automático.
// String Templates: Permite meter variables dentro de un texto usando $:
// println("Hola, me llamo $nombre y tengo $edad años")

// Funciones (fun)
// Función que retorna un valor: Se indica el tipo de retorno con : al final de los paréntesis.
// Función que no retorna nada (Void): En Kotlin no se usa void. Si una función no devuelve nada, si tipo es Unit (Es opcional escribirlo).
// Retorna un String
fun getApellido(): String {
    return "Maraboli"
}

// Recibe un parámetro y no retorna nada (Unit opcional)
fun setApellido(op: String) {
    println("El nuevo apellido $op")
}

// Funciones de una sola línea (Sintaxis corta)
fun getEdad(): Int = 40


// Null Safety (Manejo de Nulos)

// Esto es lo más importante de Kotlin respecto a Java. Por defecto, ninguna variable puede ser nula

var correo: String = "test@mail.com"
// correo = null // Error de compilación

var telefono: String? = null // El signo '?' permite que acepte nulos

// Operador Elvis (?:) para dar un valor por defecto si es nulo
val numeroValido = telefono ?: "Sin número registrado"





