#!/usr/bin/env kotlin

// Controles de errores (safenull)
// siempre hay que preocuparse de los nulos **

// Manejo de Nulos (Null Safety) y Control de Errores

// En kotlin, la protección contra nulos evita el famoso error NullPointerException.
// Existen dos formas principales de transformar y validar datos de entrada de forma segura.

// Opción A: Funciones 'OrNull' + Smart Cast (Idiomático en kotlin)
// Usa métodos como .toIntOrNull() que retornan null sila conversación falla en lugar
// de romper el programa.

val texto = "123"
val numero: Int? = texto.toIntOrNull()

if (numero != null) {
    // Kotlin aplica Smart Cast: aquí 'numero' ya es tratado como Int no-nulo
    println("Número válido: ${numero * 2}")
} else {
    println("Error: La cadena no es un número válido")
}

// Opción B: Bloque Try-Catch (Manejo explicito de excepciones)
// Ideal para capturar excepciones especificas del sistema cuando usas métodos directos
// como .toInt()

try {
    val texto2 = "123a"
    val numero2 = texto2.toInt()
    println("Número: ${numero}")
} catch (e: NumberFormatException) {
    println("Error: No se pudo convertir el texto a número (${e.message}")
}

// Clase de datos ( data class / DTO)
// data class son solo clases con datos no funciones (buscar mas información sobre esto**)
// Una data class se utiliza para representar estructuras que solo almacenan datos (Data
// Transfer Object o DTO)

// Caracteristicas principales
// Kotlin genera automáticamente métodos útiles entre bambalinas .equals()
// .hashCode() .toString() y .copy()
// Requieren al menos un parámetro en su constructor primario.
// No están pensadas ára contener lógica de negocio compleja no métodos extensos.

// Sintaxis correcta (requiere parámetros entre paréntesis):
data class Persona(
    val nombre: String,
    val edad: Int
)

// Uso practico:
val p1 = Persona("Isis", 35)
val p2 = p1.copy(edad = 36) // permite clonar cambiando solo ciertos atributos
println(p1) //Imprime: Persona(nombre= Isis, edad=25)

// Clases Selladas(sealed class) - Conjunto Cerrado de Tipos
// Una sealed class representa una jerarquía restringida donde todas las subclases son
// conocidas en tiempo de compilación. Es perfecta para representar estados de una aplicación
// (Exito, Error, Cargando)

// Ventaja clave: Al usar sealed class dentro de una expresión when, no necesitas
// escribir la rama else, ya que el compilador sabe con certeza cuáles son los únicos
// casos posibles.

// Definición de la jeraquía sellada
sealed class Resultado {
    data class Exito(val datos: String) : Resultado()
    data class Error(val mensaje: String) : Resultado()
    object Cargando : Resultado()
}

// Procesamiento exhaustivo con 'when'
fun procesarRespuesta(resultado: Resultado) {
    when (resultado) {
        is Resultado.Exito -> println("Operación exitosa: ${resultado.datos}")
        is Resultado.Error -> println("Ocurrio un fallo: ${resultado.mensaje}")
        Resultado.Cargando -> println("Cargando información...")
        // No requiere 'else'
    }
}


// Conjunto cerrado de tipos (para categorizar)
//sealed class

// Cosas que pueden entrar en la prueba
// menú
// cajero automatico
// venta de productos
// se debe ocupar poliformismo, sealed class,
// *todo lo que se ha pasado en clases entrara en la prueba*






