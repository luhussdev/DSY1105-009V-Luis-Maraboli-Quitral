package cl.duoc.dsy1105.GestorPedidos

// 1 Modelo de datos

// Sealed class para representar los estados cerrados de una operación
sealed class ResultadoRegistro {
    data class Exito(val mensaje: String) : ResultadoRegistro()
    data class Error(val motivo: String) : ResultadoRegistro()
}

// Data class para representar el producto individual
data class Producto(
    val nombre: String,
    val precioUnitario: Int
)

// Clase principal con estado y comportamiento
class Pedido(
    val id: Int,
    val cliente: String,
    val producto: Producto,
    var cantidad: Int
) {
    var entregado: Boolean = false
        private set

    // Comportamiento: Cálculo derivado
    fun calcularTotal(): Int = producto.precioUnitario * cantidad

    fun marcarComoEntregado() {
        entregado = true
    }

    fun obtenerDetalle(): String {
        val estado = if (entregado) "[Entregado]" else "[Pendiente]"
        return "ID $id | Cliente: $cliente | Producto: ${producto.nombre} | " +
                "Cant: $cantidad | Total: ${calcularTotal()} $estado"
    }
}

// 2 Gestor y logica de negocio

class SistemaPedidos {
    private val listaPedidos = mutableListOf<Pedido>()
    private var contadorId = 1

    // Validaciones y registro
    fun registrarPedido(cliente: String, nombreProducto: String, precioStr: String, cantidadStr: String): ResultadoRegistro {
        if (cliente.isBlank() || nombreProducto.isBlank()) {
            return ResultadoRegistro.Error("El nombre del cliente y del producto no pueden estar vacios.")
        }

        // Manejo de nulos y conversiones seguras
        val precio = precioStr.toIntOrNull()
        val cantidad = cantidadStr.toIntOrNull()

        if (precio == null || precio <= 0) {
            return ResultadoRegistro.Error("El precio debe ser un número entero mayor a 0.")
        }

        if (cantidad == null || cantidad <= 0) {
            return ResultadoRegistro.Error("La cantidad debe ser un número entero mayor a 0.")
        }

        // Si tod0 está correcto, se crea el estado de forma consistente
        val nuevoProducto = Producto(nombreProducto, precio)
        val nuevoPedido = Pedido(contadorId++, cliente, nuevoProducto, cantidad)
        listaPedidos.add(nuevoPedido)

        return ResultadoRegistro.Exito("Pedid #${nuevoPedido.id} registrado exitosamente.")
    }

    fun listarPedidos() {
        if (listaPedidos.isEmpty()) {
            println("No hay pedidos registrados en el sistema.")
            return
        }
        println("\n--- LISTA DE PEDIDOS ---")
        listaPedidos.forEach { println(it.obtenerDetalle()) }
    }

    fun buscarPorId(id: Int): Pedido? {
        return listaPedidos.find { it.id == id }
    }

    // Indicadores derivados
    fun calcularMontoTotalVentas(): Int {
        return listaPedidos.sumOf { it.calcularTotal() }
    }

    fun contarPendientes(): Int {
        return listaPedidos.count { !it.entregado}
    }
}

// Ejecución prueba / main interactivo

fun main() {
    val sistema = SistemaPedidos()

    // Casos válidos y rechazados
    println("=== DEMOSTRACIÓN DE REGLAS DE NEGOCIO ====")

    val pruebas = listOf(
        // Válido
        { sistema.registrarPedido("Isis", "Hand Roll Camarón", "12000", "2") },
        // Válido
        { sistema.registrarPedido("Izzi", "Caramel Machiatto", "5990", "1")},
        // Rechazado: Precio inválido (letras)
        { sistema.registrarPedido("Isi", "Carpaccio", "treinta mil", "1")},
        // Rechazado: Cantidad negativa
        { sistema.registrarPedido("Ysy", "Lentejas", "4500", "-1")},
        // Rechazado: Cliente vacio
        { sistema.registrarPedido("", "Papas Fritas", "3000", "1")}
    )

    pruebas.forEach { ejecucion ->
        when (val resultado = ejecucion()) {
            is ResultadoRegistro.Exito -> println("[EXITO] ${resultado.mensaje}")
            is ResultadoRegistro.Error -> println("[RECHAZADO] ${resultado.motivo}")
        }
    }

    println("\n=====================================================")
    println("           MENÚ DE GESTIÓN DE PEDIDOS                  ")
    println("\n=====================================================")

    // Ciclo interactivo con menú
    var continuar = true
    while (continuar) {
        println("\nOpciones: [1] Registrar | [2] Listar | [3] Marcar entregago | [4] Ver Total Ventas | [5] Salir")
        println("Selecciona una opción: ")

        when (readlnOrNull()?.trim()) {
            "1" -> {
                println("Nombre Cliente: ")
                val cliente = readlnOrNull() ?: ""
                println("Producto: ")
                val prod = readlnOrNull() ?: ""
                println("Precio Unitario: ")
                val precio = readlnOrNull() ?: ""
                println("Cantidad: ")
                val cant = readlnOrNull() ?: ""

                when (val res = sistema.registrarPedido(cliente, prod, precio, cant)) {
                    is ResultadoRegistro.Exito -> println(">> ${res.mensaje}")
                    is ResultadoRegistro.Error -> println(">> Error de Registro: ${res.motivo}")
                }
            }
            "2" -> sistema.listarPedidos()
            "3" -> {
                println("Ingresa el ID del pedido a entregar: ")
                val idInput = readlnOrNull()?.toIntOrNull()
                if (idInput != null) {
                    val pedido = sistema.buscarPorId(idInput)
                    if (pedido != null) {
                        pedido.marcarComoEntregado()
                        println(">> Pedido #${pedido.id} marcado como entregado.")
                    }else {
                        println(">> No se encontró un pedido con ID $idInput")
                    }
                }else {
                    println(">> ID inválido.")
                }
            }
            "4" -> {
                println("\n--- INDICADORES DE VENTA ----")
                println("Total acumulado ventas: ${sistema.calcularMontoTotalVentas()}")
                println("Pedidos pendientes: ${sistema.contarPendientes()}")
            }
            "5" -> {
                println("Cerrando el sistema...")
                println("Gracias por su compra.")
                println("Desarrollado por: Luis Marabolí Quitral")
                println("Versión: 1.0")
                continuar = false
            }
            else -> println("Opción no válida. Intenta de nuevo.")
        }
    }
}
