package cl.duoc.dsy1105.DesafioMax

class Bicicleta(
    val id: String,
    val tipo: String,
    val tarifaHora: Int
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

    // Calculo costo, aplicamos un dscto del 10% si arrienda por más de 5 horas
    fun calcularCosto(horas: Int): Int {
        val costoBase = horas * tarifaHora
        return if (horas > 5) {
            (costoBase * 0.90).toInt()
        } else {
            costoBase
        }
    }

    // Metodo imprimir datos
    fun obtenerDetalle(): String {
        val estado = if (disponible) "[Disponible]" else "[Arrendada]"
        return "ID: $id | Tipo: $tipo | Tarifa: $tarifaHora/hr | Estado: $estado"
    }
}




fun main() {
    // Colección mutable
    val listaBicicletas = mutableListOf<Bicicleta>()

    // Registro histórico de ingresos por bicicletas
    val ingresoPorBicicleta = mutableMapOf<String, Int>()


    var ingresoTotalAcumulado = 0
    var totalArriendosRealizados = 0
    var continuar = true

    while (continuar) {
        println("\n=============================================")
        println("         SISTEMA DE ARRIENDO DE BICICLETAS     ")
        println("\n=============================================")
        println("1.- Registrar bicicleta")
        println("2.- Buscar bicicleta por ID")
        println("3.- Arrendar bicicleta (Aplica Dcto > 5 hrs)")
        println("4.- Devolver bicicleta")
        println("5.- Listar disponibless / no disponible")
        println("6.- Ver Top Rentabilidad (Extra 1)")
        println("7.- Buscar por presupuesto / tarifa máz (Extra 3) ")
        println("8.- Ver Resumen General e Indicadores")
        println("9.- Salir")
        println("Selecciones una opción: ")

        when (readlnOrNull()?.trim()) {
            "1" -> {
                println("\n--- Registrar bicicleta ---")
                println("Ingrese ID: ")
                val id = readlnOrNull()?.trim() ?:""

                print("Ingrese Tipo (Urbana, MTB, Eléctrica): ")
                val tipo = readlnOrNull()?.trim() ?: ""

                println("Ingrese Tarifa por hora: ")
                val tarifa = readlnOrNull()?.trim()?.toIntOrNull()

                //val tarifa = tarifaInput?.toIntOrNull()

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
                println("\n--- Arrendar bicicleta ---")
                println("Ingrese el ID de la bicicleta a arrendar: ")
                val idArriendo = readlnOrNull()?.trim() ?: ""

                val bici = listaBicicletas.find { it.id.equals(idArriendo, ignoreCase = true) }

                if (bici == null) {
                    println(" ERROR: No existe ninguna bicicleta con el ID '$idArriendo'.")
                } else if (!bici.disponible) {
                    println("RECHAZADO: La bicicleta '${bici.id}' ya se encuentra arrendada.")
                } else {
                    println("Ingrese cantidad de horas de uso: ")
                    //val horasInput = readlnOrNull()?.trim()
                    //val horas = horasInput?.toIntOrNull()
                    val horas = readlnOrNull()?.trim()?.toIntOrNull()

                    if (horas == null || horas <= 0) {
                        println("ERROR: Las horas deben ser un número entero positivo.")
                    } else {
                        bici.arrendar()
                        val costoTotal = bici.calcularCosto(horas)

                        ingresoTotalAcumulado += costoTotal
                        totalArriendosRealizados++
                        ingresoPorBicicleta[bici.id] = (ingresoPorBicicleta[bici.id] ?: 0) + costoTotal

                        val msjDescuento = if (horas > 5) "(Aplica 10% de descuento)" else ""
                        println(" ARRIENDO EXITOS")
                        println("Bicicleta: ${bici.id} (${bici.tipo})")
                        println("Horas: $horas hrs | $msjDescuento")
                        println("Total a pagar: $$costoTotal")
                    }
                }
            }
            "4" -> {
                println("\n--- Devolver bicicleta ---")
                println("Ingrese el ID de la bicicleta a devolver: ")
                val idDevolucion  = readlnOrNull()?.trim() ?: ""

                val bici = listaBicicletas.find { it.id.equals(idDevolucion, ignoreCase = true) }

                if (bici == null) {
                    println("ERROR: No existe ninguna bicicleta con el ID '${idDevolucion}'.")
                } else if (bici.disponible) {
                    println("RECHAZADO: La bicicleta '{bici.id} ya está en el local (está disponible).)'")
                } else {
                    bici.devolver()
                    println("DEVOLUCION EXITOSA, La bicicleta '${bici.id}' ya está disponible.")
                }
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
                println("\n--- TOP BICICLETAS MÁS RENTABLES ---")
                if (ingresoPorBicicleta.isEmpty()) {
                    println("No hay datos de arriendos para generar el ranking.")
                } else {
                    ingresoPorBicicleta.entries
                        .sortedByDescending { it.value }
                        .take(3)
                        .forEachIndexed { i, entry ->
                            val bici = listaBicicletas.find { it.id == entry.key }
                            println(" ${i + 1}. ID: ${entry.key} (${bici?.tipo}) | Generado: $$${entry.value}")
                        }
                }
            }
            "7" -> {
                println("\n--- BÚSQUEDA POR PRESUPUESTO ---")
                println("Ingrese tarifa máxima pro hora: ")
                val tarifaMax = readlnOrNull()?.trim()?.toIntOrNull()

                if (tarifaMax == null || tarifaMax <= 0) {
                    println("ERROR: Ingrese un monto válido.")
                } else {
                    val economicas = listaBicicletas.filter { it.tarifaHora <= tarifaMax }
                    if (economicas.isEmpty()) {
                        println("No hay bicicletas con tarifa menor o igual a $$tarifaMax.")
                    } else {
                        println("Bicicletas dentro del presupuesto:")
                        economicas.forEach { println("${it.obtenerDetalle()}") }
                    }
                }
            }
            "8" -> {
                println("\n--- Ver Resumen General e Indicadores ---")
                val totalBicis = listaBicicletas.size
                val disponibles = listaBicicletas.count { it.disponible }
                val arrendadas = listaBicicletas.count { !it.disponible }
                //val tarifaPromedio = if (totalBicis > 0) listaBicicletas.map { it.tarifaHora }.average() else 0.0

                // Calculo tarifa promedio
                val tarifaPromedio = if (totalBicis > 0) listaBicicletas.map { it.tarifaHora }.average() else 0.0

                println("Total de bicicletas registrada     : $totalBicis")
                println("Bicicletas disponible              : $disponibles")
                println("Bicicletas arrendadas              : $arrendadas")
                println("--------------------------------------------")
                println("Ingreso total acumulado            : $$ingresoTotalAcumulado")
                println("Cantidad de arriendos procesados   : $totalArriendosRealizados")
                println("Tarifa promedio general            : $${"%.2f".format(tarifaPromedio)}/hr")
                println("--------------------------------------------")
            }
            "9" -> {
                println("Saliendo del programa...")
                println("Version 1.0")
                println("Desarrollado por: Luis Marabolí Quitral")
                continuar = false
            }
            else -> println("Opción no válida...")

        }
    }
}