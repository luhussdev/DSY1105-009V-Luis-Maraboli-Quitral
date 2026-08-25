#!/usr/bin/env kotlin

// Clase 24/08/2026
// Funciones

// En Kotlin no es obligatorio envolver funciones en clases (Top-Level functions)
fun miFuncion() {
    // Función sin retorno explicito (retorna Unit implicitamente)

}

// Sintanxis tradicional: parámetro: Tipo -> TipoDeRetorno
// primero el valor luego el tipo de dato
fun sumar(a: Int, b: Int): Int {
    return a + b
}

// Single-expression function (Sintaxis corta):
// Solo aplica si el cuerpo cabe en 1 línea. Infiere el tipo de retorno automáticamente.
// Sintancis corta de función. Solo si retorna algo, solo si es una línea
fun sumar1(a: Int, b: Int) = a + b
//fun sumarCorta(a: Int, b: Int) = a + b

// Colecciones en Java
// Listas ->        lista           -> Arraylist<>
// Conjuntos ->     sets            -> HashSet<>
// Mapas ->         Map<>           -> HashMap<>
//                  Interfaces      |   Clases

// La clase es una plantilla
// La clase tiene atributos, funciones/metodos
// La clase implementa lo que la interfaz dice

// Colecciones en Kotlin
// Listas ->        lista           -> Arraylist<>  -> listOf
// Conjuntos ->     sets            -> HashSet<>    -> setOf
// Mapas ->         Map<>           -> HashMap<>    -> mapOf
//                  Interfaces      |   Clases

// Lista Inmutable (Solo lectura, no se pueden agregar ni quitar elementos)
var lista = listOf(2, 4, 6)
// la funcion listOf genere lista inmutable

// Lista MUtable (Permite .add(), .remove(), etc.)
// Nota: Usa 'val' para la lista; lo que cambia es su contenido, no la referencia
// para crear listas mutables se hace asi:
var lista1 = mutableListOf(3, 5, 7)

/*
for(palabra in palabras) {
    println(palabra)
}
*/

// La lista tiene una funcion para iterar directamente
// palabras.forEach {
// palabra -> println(palabra)
// }

fun demoRecorridos() {
    val palabras = listOf("Kotlin", "Java", "Android")

    // Opción A: Bucle for tradicional
    for (palabra in palabras) {
        println(palabra)
    }

    // Opción B: forEach con parámetro explícito
    palabras.forEach { palabra ->
        println(palabra)
    }

    // Opción C: forEach idiomático usando 'it' (Sintaxis preferida en Kotlin)
    // 'it' es el nombre por defecto cuando la lambda recibe UN solo parámetro.
    palabras.forEach { println(it) }
}

/*
palabras1.forEach { palabra1 ->
    println(palabra1)
}
*/
// Para repasar esto revisar en los apuntes "Streams + Lambda, expresiones

/*
for (Integer num : numeros) {
    if(num > 5) {
        mayores5 .add(num);
    }
}
*/

// En Java
// nuevaLista = numeros.stream().filter(num => num > 5).tolist();

/*
numeros.filter{
    num => num > 5
}
*/


fun demoProgramacionFuncional() {
    val numeros = listOf(1, 4, 8, 12, 3)

    // FILTER: Filtra elementos bajo una condición booleana
    // Sintaxis con parámetro explícito:
    val mayoresA5Explicito = numeros.filter { num -> num > 5 }
    // Sintaxis idiomática con 'it':
    val mayoresA5 = numeros.filter { it > 5 } // Resultado: [8, 12]

    // MAP: Transforma cada elemento de la lista
    val duplicados = numeros.map { it * 2 } // Resultado: [2, 8, 16, 24, 6]

    // COUNT: Cuenta elementos que cumplen una condición
    val cantidadMayoresA5 = numeros.count { it > 5 } // Resultado: 2
}


// para la prueba sera algo como una aplicacion de consola
// puede que sea un menú




