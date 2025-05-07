package com.marcosferrandiz.Ejercicio6;

import java.util.List;

public class Vista {
    private static Formato formato;
    private static Gestion gestion = new Gestion();
    public static void mostrarMenuPrincipal() {
        System.out.println("=== Sistema de Gestión de Multimedia ===");
        System.out.println("1. Altas");
        System.out.println("2. Listados");
        System.out.println("3. Alquilar multimedia a socio");
        System.out.println("4. Devolver multimedia");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void mostrarMenuAltas() {
        System.out.println("=== Menú de Altas ===");
        System.out.println("1. Alta de una nueva Película");
        System.out.println("2. Alta de un nuevo Videojuego");
        System.out.println("3. Alta de un nuevo Socio");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    public static void mostrarMenuListados() {
        System.out.println("=== Menú de Listados ===");
        System.out.println("1. Listado de todos los objetos multimedia");
        System.out.println("2. Listado de todas las películas ordenadas por título");
        System.out.println("3. Listado de todos los videojuegos ordenados por año");
        System.out.println("4. Listado del histórico de alquileres de un socio ordenados por fecha de alquiler");
        System.out.println("5. Listado de los alquileres actuales de un socio");
        System.out.println("6. Listado de los socios con recargos pendientes");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    public static void mostrarEnum(){
        System.out.println( formato.listaTodos());
    }


    public void imprimirPeliculas() {
        List<Pelicula> peliculas = gestion.ordenarPeliculasPorTitulo();
        System.out.println("Películas ordenadas alfabéticamente por título:");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void imprimirVideojuegos() {
        List<Videojuego> videojuegos = gestion.ordenarVideojuegosPorAnyo();
        System.out.println("Videojuegos ordenados por año:");
        for (Videojuego videojuego : videojuegos) {
            System.out.println(videojuego);
        }
    }

    public void imprimirHistoricoSocio(String nif) {
        List<Alquiler> alquileres = gestion.listaAlquileresHistoricoSocio(nif);
        System.out.println("Historico clientes ordenado por fecha:");
        for (Alquiler alquiler : alquileres) {
            System.out.println(alquiler);
        }
    }

    public void imprimirEndeudados(){
        List<Socio> sociosEndeudados = gestion.genteConDeudas();
        System.out.println("Gente con deudas:");
        for (Socio socio : sociosEndeudados){
            System.out.println(socio);
        }
    }

    public void imprimirAlquielresActivoSocio(String nif){
        List<Alquiler> alquielresActivos = gestion.listaAlquileresActualesSocio(nif);
        for (Alquiler alquiler : alquielresActivos){
            System.out.println(alquiler);
        }
    }
}
