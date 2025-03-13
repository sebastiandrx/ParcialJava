package org.example;

public class CabinaTel {

        private int id;
        private int llamadasLocales;
        private int llamadasLargaDistancia;
        private int llamadasCelular;
        private int minutosLocales;
        private int minutosLargaDistancia;
        private int minutosCelular;

        private static final int Local = 50;
        private static final int Larga_Distancia = 350;
        private static final int Celular = 150;

        public CabinaTel(int id) {
            this.id = id;
            reiniciar();
        }

        public void registrarLlamadaLocal(int minutos) {
            this.llamadasLocales++;
            this.minutosLocales += minutos;
        }

        public void registrarLlamadaLargaDistancia(int minutos) {
            this.llamadasLargaDistancia++;
            this.minutosLargaDistancia += minutos;
        }

        public void registrarLlamadaCelular(int minutos) {
            this.llamadasCelular++;
            this.minutosCelular += minutos;
        }

        public void reiniciar() {
            this.llamadasLocales = 0;
            this.llamadasLargaDistancia = 0;
            this.llamadasCelular = 0;
            this.minutosLocales = 0;
            this.minutosLargaDistancia = 0;
            this.minutosCelular = 0;
        }

        public int getTotalLlamadas() {
            return llamadasLocales + llamadasLargaDistancia + llamadasCelular;
        }

        public int getTotalMinutos() {
            return minutosLocales + minutosLargaDistancia + minutosCelular;
        }

        public int getCostoTotalLocal() {
            return minutosLocales * Local;
        }

        public int getCostoTotalLargaDistancia() {
            return minutosLargaDistancia * Larga_Distancia;
        }

        public int getCostoTotalCelular() {
            return minutosCelular * Celular;
        }

        public int getCostoTotal() {
            return getCostoTotalLocal() + getCostoTotalLargaDistancia() + getCostoTotalCelular();
        }

        public int getId() {
            return id;
        }

        public void mostrarInformacionDetallada() {
            System.out.println(" Información detallada de la Cabina " + id + " ");
            System.out.println("Llamadas Locales: " + llamadasLocales + " | Minutos: " + minutosLocales + " | Costo: $" + getCostoTotalLocal() + " pesos");
            System.out.println("Llamadas Larga Distancia: " + llamadasLargaDistancia + " | Minutos: " + minutosLargaDistancia + " | Costo: $" + getCostoTotalLargaDistancia() + " pesos");
            System.out.println("Llamadas Celular: " + llamadasCelular + " | Minutos: " + minutosCelular + " | Costo: $" + getCostoTotalCelular() + " pesos");
            System.out.println("Total Llamadas: " + getTotalLlamadas() + " | Total Minutos: " + getTotalMinutos() + " | Costo Total: $" + getCostoTotal() + " pesos");
        }
    }


