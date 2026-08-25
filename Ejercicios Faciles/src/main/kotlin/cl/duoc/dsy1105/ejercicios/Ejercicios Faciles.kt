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
}






