package cl.duoc.dsy1105.DesafioMax

class Bicicleta(
    val id: String,
    val tipo: String,
    val tariaHora: Int
) {
    var disponible: Boolean = true
        private set

    // Metodo para cambiar el estado
    fun arrendar(): Boolean {
        if (!disponible) return false
        disponible = false
        return true
    }

    // Metodo para dispobibilidad
    fun devolver() {
        disponible = true
    }

    // Calculo costo
    fun calcularCosto(horas: Int): Int {
        return horas * tariaHora
    }

    // Metodo imprimir datos
    fun obtenerDetalle(): String {
        val estado = if (disponible) "[Disponible]" else "[Arrendada]"
        return "ID: $id | Tipo: $tipo | Tarifa: $tariaHora/hr | Estado: $estado"
    }
}




fun main() {
    // Colección mutable
    val listaBicicletas = mutableListOf<Bicicleta>()
    var continuar = true

    while (continuar) {
        println("\n=============================================")
        println("         SISTEMA DE ARRIENDO DE BICICLETAS     ")
        println("\n=============================================")
        println("1.- Registrar bicicleta")
        println("2.- Buscar bicicleta por ID")
        println("3.- Arrendar bicicleta")
        println("4.- Devolver bicicleta")
        println("5.- Listar disponibless / no disponible")
        println("6.- Ver Top Rentabilidad (Extra)")
        println("7.- Ver Resumen General e Indicadores")
        println("8.- Salir")
        println("Selecciones una opción: ")

        when (readlnOrNull()?.trim()) {
            "1" -> {
                println("\n--- Registrar bicicleta ---")
                println("Ingrese ID: ")
                val id = readlnOrNull()?.trim() ?:""

                print("Ingrese Tipo (Urbana, MTB, Eléctrica): ")
                val tipo = readlnOrNull()?.trim() ?: ""

                println("Ingrese Tarifa por hora: ")
                val tarifaInput = readlnOrNull()?.trim()

                val tarifa = tarifaInput?.toIntOrNull()

                if (id.isBlank()) {
                    println("ERROR DE REGISTRO: El ID no puede estar vacío.")
                }else if (listaBicicletas.any { it.id.equals(id, ignoreCase = true) }) {
                    println("ERROR DE REGISTRO: Ya existe una bicicleta con el ID '$id'.")
                }else if (tipo.isBlank()){
                    println("ERROR DE REGISTRO: El tipo de bicicleta no puede estar vacío.")
                }else if (tarifa == null || tarifa <= 0) {
                    println("ERROR DE REGISTRO: La tarifa dede ser un número entero mayor a 0.")
                } else {
                    // una vez superado todas las validaciones se Instancia el objeto
                    val nuevaBici = Bicicleta(id, tipo, tarifa)
                    listaBicicletas.add(nuevaBici)
                    println("EXITO, bicicleta '$id' registrada correctamente.")
                }
            }
            "2" -> {
                println("\n--- Buscar bicicleta por ID --- ")
                println("Ingrese el ID de la bicicleta a buscar: ")
                val idBuscado = readlnOrNull()?.trim() ?: ""

                if (idBuscado.isBlank()) {
                    println("ERROR: Debe ingresar un ID válido para buscar.")
                } else{
                    // con la función .find buscamos en la lista
                    val biciEncontrada = listaBicicletas.find { it.id.equals(idBuscado, ignoreCase = true) }

                    if (biciEncontrada != null) {
                        println(" BICICLETA ENCONTRADA:")
                        println(" ${biciEncontrada.obtenerDetalle()}")
                    } else {
                        println("RESULTADO: No existe ninguna bicicleta registrada con el ID '${idBuscado}'.")
                    }
                }
            }
            "3" -> {
                println("Arrendar bicicleta: ")
            }
            "4" -> {
                println("Devolver bicicleta: ")
            }
            "5" -> {
                println("\n--- Listar disponibless / no disponible ---")

                if(listaBicicletas.isEmpty()) {
                    println("No hay bicicletas registradas en el sistema.")
                } else {
                    // Filtro unidades disponibles
                    val disponibles = listaBicicletas.filter { it.disponible }
                    println("\n --- BICICLETAS DISPONIBLES (${disponibles.size}) ---")
                    if (disponibles.isEmpty()) {
                        println(" (No hay unidades disponibles actualmente)")
                    } else {
                        disponibles.forEach { println(" ${it.obtenerDetalle()}") }
                    }

                    val noDisponible = listaBicicletas.filter { !it.disponible }
                    println("\n--- BICICLETAS ARRENDADAS / NO DISPONIBLES (${noDisponible.size}) ---")
                    if (noDisponible.isEmpty()) {
                        println(" (No hay unidades en arriendo actualmente.)")
                    } else {
                        noDisponible.forEach { println(" ${it.obtenerDetalle()}") }
                    }
                }
            }
            "6" -> {
                println("Ver Top Rentabilidad (Extra): ")
            }
            "7" -> {
                println("Ver Resumen General e Indicadores")
            }
            "8" -> {
                println("Salir ")
            }
            else -> println("Opción no válida...")

        }
    }
}