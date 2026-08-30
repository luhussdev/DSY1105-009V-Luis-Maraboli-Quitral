#!/usr/bin/env kotlin

// Colecciones

var lista = listOf("Hola", "Chao") // Listas inmutable (solo lectura)
var miLista = mutableListOf("Hola", "Chao") // crea listas mutables (permite agregar/eliminar)

// Buenas practicas: Preferir 'val' para la colección.
// Lo que cambia son sus elementos internos (.add, .remove), no la variable
// La lista mutables permiten agregar o quitar elementos con las funciones .add o .remove

fun demoColecciones(){
    miLista.add("Hola")
    miLista.add("Chao")

    // Lambdas rápidas:
    miLista.forEach { println(it) } // Recorrido
    val filtrados = miLista.filter { it.startsWith("H") } // Retorna nueva Lista
    val cantidad = miLista.count { it.length > 3 } // Retorna Int
}

// La lista igual se pueden recorrer con un for
// Expreción lambda
// lista.forEach
// lista.filter -> esto retorna una sublista
// lista.count -> retorna un número

// *********************************************************

//PPO Programación orientada a Objetos
// Constructores y Propiedades

// Constructor Primario (La forma idiomática y correcta en kotlin)
// Al anteponer 'val', Kotlin crea la propiedad y su 'getter' automáticamente.

class Alumno(
    val nombre: String,
    val rut: String,
    val anioNacimiento: Int
) {
    // Función con tipo de retorno explicito Int
    fun calcularEdad(anioActual: Int = 2026): Int {
        return anioActual - anioNacimiento
    }
    // Función con tipo de retorno explícito Boolean
    fun validarRut(): Boolean {
        return rut.isNotEmpty()
    }

}

// Encapsulamiento

class Cuenta(saldoInicial: Int) {
    // 'private' impide que el saldo sea modificado o leido desde fuera de la clase
    private var saldo = saldoInicial

    // Retorna Boolean para indicar si se pudo realizar la transacción
    fun girar(monto: Int): Boolean {
        return if(permitidoGirar(monto)) {
            saldo -= monto
            true
        } else {
            false
        }
    }

    // Función privada auxiliar (mantiene la lógica de validación protegida)
    private fun permitidoGirar(monto: Int): Boolean {
        return monto > 0 && monto <= saldo
    }

    // Metodo para consultar el saldo de forma segura (solo lectura)
    fun obtenerSaldo(): Int = saldo
}

// Herencia (open, extends y override)

// En Kotlin las clases y métodos son "final" (cerrados) por defecto.
// Debes marcar la clase y el metodo con 'open' para permitir la herencia.

open class CuentaPadre(saldoInicial: Int) {
    var saldo = saldoInicial

    // El metodo debe ser 'open' para poder sobreescribirlo con 'override'
    open fun girar(monto: Int) {
        if (monto <= saldo) saldo -= monto
    }
}

// Para heredar se usan los dos puntos ':' pasando los parámetros al constructor padre
class CuentaVista(saldoInicial: Int, val comision: Int) : CuentaPadre(saldoInicial) {

    override fun girar(monto: Int) {
        val montoTotal = monto + comision
        if (montoTotal <= saldo) {
            saldo -= montoTotal
            println("Giro de $monto realizado con comisión de $comision")
        }
    }
}

// Atributo de Clase: Si se definen parámetros en el constructor son val ni var (como saldoInicial en Cuenta),
// ese parámetro vive durante la creación de la clase y no se convierte en una propiedad persistente.
// Si se pone val o var, pasa a ser un atributo accesible en toda la clase.

// open en métodos: Si se pone open class pero no se pone open fun, la clase hija no podrá sobreescribir el metodo con override.

// Forma simplificada de clases si cuerpo: Si una clase solo almacena datos y no tiene funciones internas, no necesita llaves {}.

class Persona(val nombre: String, val edad: Int)









