package org.example;
import java.util.ArrayList;
import java.util.List;

public class EmpresaTel {

    private List<CabinaTel> cabinas;

    public EmpresaTel() {
        this.cabinas = new ArrayList<>();
    }

    public void crearCabina() {
        int nuevoId = cabinas.size() + 1;
        cabinas.add(new CabinaTel(nuevoId));
        System.out.println("Cabina " + nuevoId + " creada exitosamente.");
    }

    public CabinaTel seleccionarCabina(int idCabina) {
        for (CabinaTel cabina : cabinas) {
            if (cabina.getId() == idCabina) {
                return cabina;
            }
        }
        return null;
    }

    public void mostrarCabinasDisponibles() {
        if (cabinas.isEmpty()) {
            System.out.println("No hay cabinas disponibles. Por favor cree una cabina primero.");
            return;
        }

        System.out.println(" Cabinas Disponibles ");
        for (CabinaTel cabina : cabinas) {
            System.out.println("Cabina ID: " + cabina.getId());
        }
    }

    public void mostrarConsolidadoTotal() {
        if (cabinas.isEmpty()) {
            System.out.println("No hay cabinas para mostrar información.");
            return;
        }

        int totalLlamadas = 0;
        int totalMinutos = 0;
        int costoTotal = 0;

        System.out.println(" Consolidado Total de Todas las Cabinas ");

        for (CabinaTel cabina : cabinas) {
            System.out.println("Cabina " + cabina.getId() + ": " + cabina.getTotalLlamadas() +
                    " llamadas | " + cabina.getTotalMinutos() + " minutos | $" +
                    cabina.getCostoTotal() + " pesos");

            totalLlamadas += cabina.getTotalLlamadas();
            totalMinutos += cabina.getTotalMinutos();
            costoTotal += cabina.getCostoTotal();
        }

        System.out.println(" RESUMEN TOTAL ");
        System.out.println("Total Llamadas: " + totalLlamadas);
        System.out.println("Total Minutos: " + totalMinutos);
        System.out.println("Costo Total: $" + costoTotal + " pesos");
    }

    public boolean tieneCabinas() {
        return !cabinas.isEmpty();
    }
}



