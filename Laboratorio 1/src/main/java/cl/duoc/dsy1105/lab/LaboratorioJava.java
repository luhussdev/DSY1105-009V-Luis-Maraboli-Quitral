package cl.duoc.dsy1105.lab;

public class LaboratorioJava {

    public static String obtenerEstadoBateria(int bateria) {
        if (bateria < 20) {
            return "Bateria baja";
        } else if (bateria <= 79) {
            return "Bateria suficiente";
        } else {
            return "Bateria alta";
        }
    }

    public static void main(String[] args) {
        String modelo = "Galaxi A55";
        int bateria = 55;
        boolean modoAhorroEnergia = false;
        String propietario = null;

        String nombrePropietario = (propietario != null) ? propietario : "Sin propietario";


        System.out.println("=== TELÉFONO === ");
        System.out.println("Modelo: " + modelo);
        System.out.println("Bateria: " + bateria + "%");
        System.out.println("Estado: " +  obtenerEstadoBateria(bateria));
        System.out.println("Ahorro de energia: " + modoAhorroEnergia);
        System.out.println("Propietario: " + nombrePropietario);

        boolean cargando = true;
        if (cargando) {
            System.out.println("El teléfono está conectado al cargador");
        }
    }

}
