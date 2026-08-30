package cl.duoc.dsy1105.ejercicios

fun separador(titulo: String) {
    println("\n==================================================")
    println("               TITULO: $titulo"                      )
    println("\n==================================================")
}

// Ejercicio 1
fun ejercicio1() {
    val nombre = "Pepé"
    val edad = 22
    val carrera = "Mecánica"
    val promedio = 5.4

    println("Estudiante: $nombre, edad: $edad, carrera: $carrera, promedio: $promedio ")
}

// Ejercicio 2
fun sumar2(a: Int, b: Int) = a + b
fun restar(a: Int, b: Int) = a - b
fun multiplica(a: Int, b: Int) = a * b
fun division(a: Int, b: Int) = a / b

fun ejercicio2() {
    val a = 10
    val b = 2

    println("La suma de $a y $b es: ${sumar2(a, b)}")
    println("La resta de $a y $b es: ${restar(a, b)}")
    println("La multiplicación de $a y $b es: ${multiplica(a, b)}")
    println("La división de $a y $b es: ${division(a, b)}")

    val esMayor = a > b
    val ambosPositivos = a > 0 && b > 0

    println("¿El primero es mayor al segundo?: $esMayor")
    println("¿Ambos son positivos?: $ambosPositivos")
}

// Ejercicio 3

fun evaluarNota(nota: Double) {
    //val nota = 5.3
    val estado = if(nota >= 4.0) "aprobado" else "Reprobado"
    println("Nota: $nota - Estado: $estado ")
}

fun ejercicio3() {
    evaluarNota(5.3)
    evaluarNota(3.9)
    evaluarNota(4.0)
}

// Ejercicio 4

fun consultarDia(dia: Int) {
    val nombreDia = when (dia) {
        1 -> "Lunes"
        2 -> "Martes"
        3 -> "Miercoles"
        4 -> "Jueves"
        5 -> "Viernes"
        6 -> "Sabado"
        7 -> "Domingo"
        else -> "Día no valido"
    }
    println("Día $dia: $nombreDia")
}

fun ejercicio4() {
    consultarDia(3)
    consultarDia(7)
    consultarDia(10)
}

// Ejercicio 5

fun ejercicio5() {
    println("--- Números del 1 al 10 ---")
    for (i in 1..10) {
        print("$i ")
    }
    println()

    println("--- Números pares ---")
    for (i in 1..10) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }
}

// Ejercicio 6

fun ejercicio6() {
    var contador = 5

    while (contador >= 1) {
        println(contador)
        contador--
    }

    println("Inicio")
}

// Ejercicio 7
fun calcularDescuento(precio: Double, porcentajeDescuento: Double): Double {
    val descuento = precio * (porcentajeDescuento / 100.0)
    return precio - descuento
}

fun ejercicio7() {
    val precioOriginal = 10000.0
    val porcentaje = 15.0

    val precioFinal = calcularDescuento(precioOriginal, porcentaje)

    println("Precio original: $precioOriginal")
    println("Descuento aplicado: $porcentaje%")
    println("Precio final a pagar: $precioFinal")
}

// Ejercicio 8
fun evaluarCorreo(correo: String?) {
    val mensaje = correo ?: "Correo no registrado"
    println("Resultado: $mensaje")
}

fun ejercicio8() {
    var correo: String? = null
    println("--- Prueba con Null ---")
    evaluarCorreo(correo)

    correo = "estudiante@duocuc.cl"
    println("--- Prueba con correo ---")
    evaluarCorreo(correo)
}

fun ejercicio9() {
    val lenguajes = listOf("kotlin", "Java", "Python", "C++", "JavaScript")

    println("Lista de lenguajes: $lenguajes")

    println("Primer elemento: ${lenguajes.first()}")

    println("Cantidad de elementos: ${lenguajes.size}")

    println("--- Recorrido con for ---")
    for (lenguaje in lenguajes) {
        println("- $lenguaje")
    }
}

fun ejercicio10() {
    val tareas = mutableListOf("Estudiar Kotlin", "Hacer ejercicio", "Comprar pan")
    println("Lista inicial: $tareas")

    // Agregar una tarea
    tareas.add("Revisar correo")
    println("Despues de agregar: $tareas")

    // Eliminar una tarea
    tareas.remove("Comprar pan")
    println("Despues de eliminar: $tareas")

    // Recorrer el resultado
    println("\n--- Lista final de tareas ---")
    for (tarea in tareas) {
        println(" - $tarea")
    }
}

// Por qué aqui si se necesita una lista mutable?
/*
listof: Al ser una lista de solo lectura (elementos fijos) no permite una manipulación dentro de la lista ya creada.

mutableListOf(): A diferencia de una lista inmutable (listOf), mutableListOf si permite la manipulación, agregando o eliminando elementos.

En ejercicio 10 se solicitaba que se agregaran e eliminar tareas por consiguiente era mejor trabajar con una lista mutable.
 */

// Ejercicio 11
fun ejercicio11() {
    val nombres = listOf("Isis", "Isa", "Isidora", "Isabel", "Izzi")

    // Recorrido con forEach
    println("--- Recorrido con forEach")
    nombres.forEach {nombre ->
        println("Hola, $nombre")
    }

    // Recorrido con un for
    println("\n --- Recorrido con for ---")
    for (nombre in nombres) {
        println("Hola, $nombre")
    }
}

fun ejercicio12() {
    val numeros = listOf(12, 5, 18, 3, 21, 9)
    println("Lista original: $numeros")

    // Filtrar valores mayores o iguales a 10
    val mayoresOIgualesA10 = numeros.filter { it >= 10}
    println("Valores >= 10: $mayoresOIgualesA10")

    // Multiplicar cada valor por 2
    val multiplicadosPorDos = numeros.map { it * 2 }
    println("Valores multiplicados por 2: $multiplicadosPorDos")

    // Contar cantidad de valores mayores a 15
    val cantidadMayorA15 = numeros.count { it > 15}
    println("Cantidad de valores > 15: $cantidadMayorA15")
}



fun main() {
    separador("EJERCICIO 1")
    ejercicio1()
    separador("EJERCICIO 2")
    ejercicio2()
    separador("EJERCICIO 3")
    ejercicio3()
    separador("EJERCICIO 4")
    ejercicio4()
    separador("EJERCICIO 5")
    ejercicio5()
    separador("EJERCICIO 6")
    ejercicio6()
    separador("EJERCICIO 7")
    ejercicio7()
    separador("EJERCICIO 8")
    ejercicio8()
    separador("EJERCICIO 9")
    ejercicio9()
    separador("EJERCICIO 10")
    ejercicio10()
    separador("EJERCICIO 11")
    ejercicio11()
    separador("EJERCICIO 12")
    ejercicio12()
}






