# Sistema de Arriendo de Bicicletas - Guía de Arquitectura EV1

Este proyecto es un sistema de consola desarrollado en **Kotlin nativo** enfocado en demostrar el dominio de Programación Orientada a Objetos (POO), manejo de colecciones y validaciones explícitas de dominio.

---

## Planificación y Decisiones de Diseño Paso a Paso

### **Fase 1: Control de Flujo (Menú Interactivo)**
* **Decisión:** Implementación de un ciclo `while` controlado por una bandera booleana (`continuar`) y una estructura `when` para dirigir las opciones.
* **Manejo de Consola:** Uso de `readlnOrNull()?.trim()` para evitar errores por espacios accidentalmente ingresados o nulos al leer opciones.

### **Fase 2: Modelado del Dominio (`Bicicleta`)**
* **Atributos:** `id`, `tipo`, `tarifaHora`.
* **Encapsulamiento:** La propiedad `disponible` se configuró como `var disponible: Boolean = true private set`.
    * *Razón:* Evita que código externo fuerce la disponibilidad. Solo los métodos de la clase (`arrendar()` y `devolver()`) pueden cambiar este estado.
* **Lógica Interna:** Método `calcularCosto(horas)` que aplica reglas de negocio del objeto.

### **Fase 3: Almacenamiento y Validaciones**
* **Estructura de Datos:** `mutableListOf<Bicicleta>()` para permitir una colección de tamaño dinámico.
* **Sanitización de Datos:** Uso de `.toIntOrNull()` para validar enteros sin romper la ejecución ante entradas con texto (`NumberFormatException`).
* **Validación de Unicidad:** Métodos como `.any()` para rechazar registros con ID duplicados.

### **Fase 4: Operaciones de Negocio**
* **Búsqueda:** Uso de `.find` e igualdades ignorando mayúsculas (`equals(..., ignoreCase = true)`).
* **Filtros:** Uso de `.filter { it.disponible }` y `.filter { !it.disponible }` para listar el catálogo según su estado.

---

## Funcionalidades Extras de Valor Comercial

1. **Ranking de Rentabilidad:** Uso de un mapa `mutableMapOf<String, Int>()` para llevar la suma de ganancias de cada bicicleta y listar las mejores mediante `.sortedByDescending`.
2. **Descuento por Volumen:** Aplicación automática del 10% de descuento en arriendos superiores a 5 horas dentro de `calcularCosto()`.
3. **Filtro de Presupuesto:** Búsqueda avanzada de unidades con tarifa menor o igual a un monto dado mediante `.filter`.

---

## Cómo Ejecutar

1. Abre el proyecto en **IntelliJ IDEA**.
2. Ejecuta la función `main()` dentro de `Main.kt`.
3. Utiliza las opciones del menú interactivo por consola.

