package cl.duoc.dsy1105.lab03

// Bloque 2: Modelado de la clase actividad
open class Actividad(
    val titulo: String,
    val duracion: Int,
    var completada: Boolean = false
) {
    fun marcarComoCompletada() {
        completada = true
    }

    open fun obtenerDetalle(): String? {
        val estado = if (completada) "[X]" else "[ ]"
        return "$estado $titulo - $duracion min"
    }
}

// Bloque 1 Datos sueltos y deuda de modelado
fun ejecutarBloque1() {
    println("=== BLOQUE 1: Datos sueltos (lista paralelas) ===")
    val titulos = listOf("Estudiar Kotlin" , "Hacer ejercicios", "Revisar correos")
    val duracion = listOf(60, 45, 15)
    val completadas = listOf(true, false, true)

    for (i in titulos.indices) {
        val estado = if (completadas[i]) "[X]" else "[ ]"
        println("$estado ${titulos[i]} - ${duracion[i]} min")
    }
}

// Bloque 2: Devolución a colecciones de objetos
fun ejecutarBloque2() {
    println("\n=== BLOQUE 2: Colecciones de Objetos (Actividad) ===")
    val listaActividades = mutableListOf(
        Actividad("Estudiar Kotlin", 60, completada = true),
        Actividad("Hacer ejercicios", 45, completada = false),
        Actividad("Revisar correos", 15, completada = true)
    )

    // Se incorpora una nueva actividad
    listaActividades.add(Actividad("Preparar exposición", 30))

    println("--- Todas las Actividades ---")
    listaActividades.forEach { println(it.obtenerDetalle())}

    println("\n--- Tareas Pendientes (Filtradas) ---")
    listaActividades.filter { !it.completada }.forEach { println(it.obtenerDetalle()) }
}

// Funcion principal
fun main(){
    ejecutarBloque1()
    ejecutarBloque2()
}
