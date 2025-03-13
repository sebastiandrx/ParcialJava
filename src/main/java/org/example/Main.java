package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmpresaTel empresa = new EmpresaTel();
        CabinaTel cabinaActual = null;
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    empresa.crearCabina();
                    break;
                case 2:
                    if (!empresa.tieneCabinas()) {
                        System.out.println("No hay cabinas disponibles. Por favor cree una cabina primero.");
                        break;
                    }

                    empresa.mostrarCabinasDisponibles();
                    System.out.print("Seleccione el ID de la cabina: ");
                    int idCabina = obtenerOpcion(scanner);

                    cabinaActual = empresa.seleccionarCabina(idCabina);

                    if (cabinaActual != null) {
                        System.out.println("Cabina " + idCabina + " seleccionada.");
                        menuCabina(scanner, cabinaActual);
                    } else {
                        System.out.println("ID de cabina inválido.");
                    }
                    break;
                case 3:
                    if (!empresa.tieneCabinas()) {
                        System.out.println("No hay cabinas disponibles. Por favor cree una cabina primero.");
                        break;
                    }

                    empresa.mostrarCabinasDisponibles();
                    System.out.print("Seleccione el ID de la cabina: ");
                    int idInfoCabina = obtenerOpcion(scanner);

                    CabinaTel cabinaInfo = empresa.seleccionarCabina(idInfoCabina);

                    if (cabinaInfo != null) {
                        cabinaInfo.mostrarInformacionDetallada();
                    } else {
                        System.out.println("ID de cabina inválido.");
                    }
                    break;
                case 4:
                    empresa.mostrarConsolidadoTotal();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        }
        while (!salir) ;

        scanner.close();
    }


    private static void mostrarMenu() {
        System.out.println("SISTEMA DE CONTROL DE GASTOS TELEFÓNICOS");
        System.out.println("1. Crear cabina telefónica");
        System.out.println("2. Escoger cabina telefónica");
        System.out.println("3. Mostrar información detallada por cabina");
        System.out.println("4. Mostrar consolidado total");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private static void menuCabina(Scanner scanner, CabinaTel cabina) {
        int opcion;

        do {
            System.out.println(" MENÚ CABINA " + cabina.getId() + ":D");
            System.out.println("1. Registrar llamada local");
            System.out.println("2. Registrar llamada larga distancia");
            System.out.println("3. Registrar llamada a celular");
            System.out.println("4. Mostrar información detallada");
            System.out.println("5. Reiniciar cabina");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingrese su opción: ");

            opcion = obtenerOpcion(scanner);
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la duración de la llamada local en minutos: ");
                    int minutosLocal = obtenerOpcion(scanner);
                    cabina.registrarLlamadaLocal(minutosLocal);
                    System.out.println("Llamada local registrada: " + minutosLocal + " minutos.");
                    break;
                case 2:
                    System.out.print("Ingrese la duración de la llamada de larga distancia en minutos: ");
                    int minutosLD = obtenerOpcion(scanner);
                    cabina.registrarLlamadaLargaDistancia(minutosLD);
                    System.out.println("Llamada de larga distancia registrada: " + minutosLD + " minutos.");
                    break;
                case 3:
                    System.out.print("Ingrese la duración de la llamada a celular en minutos: ");
                    int minutosCel = obtenerOpcion(scanner);
                    cabina.registrarLlamadaCelular(minutosCel);
                    System.out.println("Llamada a celular registrada: " + minutosCel + " minutos.");
                    break;
                case 4:
                    cabina.mostrarInformacionDetallada();
                    break;
                case 5:
                    cabina.reiniciar();
                    System.out.println("Cabina " + cabina.getId() + " reiniciada. Todos los valores establecidos a cero.");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }


    private static int obtenerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}