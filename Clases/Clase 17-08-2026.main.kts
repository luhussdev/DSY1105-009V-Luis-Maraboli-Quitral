#!/usr/bin/env kotlin

// Clase 17/08/2026

//Operadores Matemáticos y Comparación

// En Kotlin, las comparaciones devuelven siempre un Boolean (true o false)

val a = 10
val b = 20

// Matemáticos
val suma = a + b         // 30
val resta = a - b        // -10
val multiplica = a * b   // 200
val divider = a / b      // 0 (División entera porque ambos son Int)

// Comparación

// val igual = a == b       // Asignación es '=' Comparación de igualdad es '=='
// val distinto = a != b    // true

// Operadores Lógicos (Tablas de Verdad)

// =, >, < !=

// val mayor = a > b
// val menor = a < b

// y , o -> && - ||

val esMayor = true
val tieneEntrada = false

val puedeEntrar = esMayor && tieneEntrada  // false (Requiere ambos verdaderos)
val puedeParticipar = esMayor || tieneEntrada // true (Basta con que uno sea verdadero)

// Resumen Rápido:

// && (AND): Solo es true si ambos son true
// ||(OR): Solo es false si ambos son false

// V && V = V
// F && V = F
// V && F = F
// F && F = F

// V || V = V
// F || V = V
// V || F = F
// F || F = F

// *null significa que no tiene un valor asignado

// Como funciona en Java
// String nombre = null,
// int largoNombre = nombre.size; esto arroja un error NullPointException

// Como funciona en Kotlin
// val nombre : String = null -> esto no compila, se le debe asignar un valor
// val nombre : String = "Pepe"
// val nombre = null -> no compila porque Kotlin no logra inferir el tipo de dato
// val nombre: String? = null -> así se acepta el valor nulo
// para eliminar el null se puede hacer lo siguiente:
// val nombre: String? = null
// if(nombre != null).....

val texto = "20" // -> es un String
val numero = texto .toInt() // Convierte a Int. Si el texto fuera "hola", la app se cae

// Forma segura (Recomendada en Kotlin):
val textoInvalido = "20a"
val numeroSeguro: Int? = textoInvalido.toIntOrNull() // Si falla, devuelve null en vez de romper la app


// En java seria equivalente:
/*
try {
    int numero = Integer.parseInt("20");
} catch (NumberFormaException e) {
    // Manejo del error
}
*/

// Profundizando Null Safety en Kotlin
// Para trabajar con varibales que pueden ser nulas sin usar tantos if(nombre != null):

val nombre: String? = null

// 1. Safe Call (?.): Solo ejecuta la propiedad si NO es nulo. Si es nulo, devuelve null.
val largo: Int? = nombre?.length

// 2. Operador Elvis (?:): Si la izquierda es nula, toma el valor por defecto de la derecha.
val largoDefinitivo: Int = nombre?.length ?: 0

// 3. Not-Null Assertion (!!): Le exige a Kotlin tratar la variable como no nula.
// ¡Peligro! Si es nula, arrojará NullPointerException igual que en Java
val largoForzado: Int = nombre!!.length







