package cl.duoc.dsy1105.lab

fun main(){
    val temp = listOf(18, 22, 25, 17, 29, 31, 20)
    println("Temperaturas: $temp")

    for (t in temp) {
        val clasificacion = clasificarTemperaturas(t)
        println("La temperatura $t°C es $clasificacion")
    }

}

fun clasificarTemperaturas(temp: Int): String{
    return when {
        temp < 18 -> "Frio"
        temp in 18..24 -> "Templado"
        else -> "Caluroso"
    }
}



