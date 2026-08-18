package cl.duoc.dsy1105.lab

fun obtenerEstadoBateria(bateria: Int): String {
    return when {
        bateria < 20 -> "Bateria baja"
        bateria in 20..79 -> "Bateria suficiente"
        else -> "Bateria alta"
    }
}

fun main() {
    val modelo = "Galaxy A55"
    val bateria = 55
    val modoAhorroEnergia = false
    val propietario: String? = null

    println("=== TELEFONO ===")
    println("Modelo: $modelo")
    println("Bateria: $bateria")
    println("Estado: ${obtenerEstadoBateria(bateria)}")
    println("Ahorro de energia: $modoAhorroEnergia")
    println("Propietario: ${propietario ?: "Sin propietario"}")

    val cargando = true
    if (cargando) {
        println("El teléfono está conectado al cargador")
    }
}
