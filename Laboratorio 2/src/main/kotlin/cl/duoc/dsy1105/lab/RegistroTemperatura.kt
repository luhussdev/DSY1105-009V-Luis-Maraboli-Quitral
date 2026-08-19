package cl.duoc.dsy1105.lab

fun main(){
    val temp = listOf(18, 22, 25, 17, 29, 31, 20)
    println("Temperaturas: $temp")

    for (t in temp) {
        val clasificacion = clasificarTemperaturas(t)
        println("La temperatura $t°C es $clasificacion")
    }

    // Devuelve una nueva lista con los elementos que cumplen la nueva condición asignada
    val alta = temp.filter { it >= 25 }
    println("Temperaturas >= 25°C: $alta")
    println("Cantidad de temperaturas altas: ${alta.count()}")

    // .map transforma los valores de la colección. En este caso transforma todos los valores de la lista a un incremento de + 1
    val aumentoUnGrado = temp.map { it + 1 }
    println("Temperaturas incrementadas en 1°C: $aumentoUnGrado")

}

fun clasificarTemperaturas(temp: Int): String{
    return when {
        temp < 18 -> "Frio"
        temp in 18..24 -> "Templado"
        else -> "Caluroso"
    }
}



