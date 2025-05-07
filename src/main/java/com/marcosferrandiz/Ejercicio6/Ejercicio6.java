package com.marcosferrandiz.Ejercicio6;

import com.marcosferrandiz.lib.SolicitarCosas;

import java.time.LocalDate;
import java.time.Period;

public class Ejercicio6 {
    private static Vista vista = new Vista();
    private static Gestion gestion = new Gestion();
    private static final String LETRAS_NIF = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static void main(String[] args) {
        gestion.altaPelicula("toyota","yo",Formato.BLU_RAY,120,"brad pit", "selena", 2000);
        gestion.altaPelicula("clio","yo",Formato.BLU_RAY,120,"brad pit", "selena", 1999);
        gestion.altaPelicula("peru","yo",Formato.BLU_RAY,120,"brad pit", "selena", 2025);
        gestion.altaPelicula("Arroz","yo",Formato.BLU_RAY,120,"brad pit", "selena", 1705);
        gestion.altaVideojuego("fortnite", "yo", Formato.CD, "ps5", 2000);
        gestion.altaVideojuego("minecraft", "yo", Formato.CD, "ps5", 2025);
        gestion.altaVideojuego("r6", "yo", Formato.CD, "ps5", 1950);
        int opcion;
        do {
            Vista.mostrarMenuPrincipal();
            opcion = SolicitarCosas.solicitarEntero("Introduzca que desea hacer",0,4);

            switch (opcion) {
                case 1:
                    menuAltas();
                    break;
                case 2:
                    menuListas();
                    break;
                case 3:
                    alquilarMultimedia();
                    break;
                case 4:
                    devolverMultimedia();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    /**
     * Menu de altas
     */
    public static void menuAltas(){
        int opcion = 0;
        do {
            vista.mostrarMenuAltas();
            opcion = SolicitarCosas.solicitarEntero("Introduzca que desea hacer",0,3);

            switch (opcion){
                case 1 ->{
                    darAltaPeli();
                }
                case 2->{
                    darAltaJuego();
                }
                case 3-> {
                    darAltaSocio();
                }
            }
        }while (opcion != 0);
    }

    /**
     * Menu de Listas
     */
    public static void menuListas(){
        int opcion = 0;
        do {
            vista.mostrarMenuListados();
            opcion = SolicitarCosas.solicitarEntero("Introduzca que desea hacer",0,3);

            switch (opcion){
                case 1 ->{
                    System.out.println(gestion.getMultimedia().toString());
                }
                case 2->{
                    vista.imprimirPeliculas();
                }
                case 3-> {
                    vista.imprimirVideojuegos();
                }
                case 4 ->{
                    String nif = SolicitarCosas.solicitarString("Introduzca el NIF del socio que quieres ver todos sus alquileres",9,9);
                    vista.imprimirHistoricoSocio(nif);
                }
                case 5 ->{
                    String nif = SolicitarCosas.solicitarString("Introduzca el NIF del socio que quieres ver todos sus alquileres",9,9);
                    vista.imprimirAlquielresActivoSocio(nif);
                }
                case 6->{
                    vista.imprimirEndeudados();
                }
            }
        }while (opcion != 0);
    }

    /**
     * Metodo para dar de alta una peli
     */
    public static void darAltaPeli(){
        String titulo = SolicitarCosas.solicitarStringSinLimite("Introduzca el titulo de la pelicula");
        if (gestion.comprobarSiExistePeliculaPorTitulo(titulo)){
            System.err.println("La pelicula ya existe");
            return;
        }
        String autor = SolicitarCosas.solicitarStringSinLimite("Introduzca el nombre del autor de la pelicula");
        vista.mostrarEnum();
        int idex = SolicitarCosas.solicitarEntero("Inrtoduzca el formato de la pelicula",1,4);
        Formato formato = indexToFormato(idex);
        double duracion = SolicitarCosas.solicitarDoubleConMinimo("Introduzca la duracion de la pelicula en minutos",0);
        String actor = SolicitarCosas.solicitarStringSinLimite("Intropduzca el nombre del actor");
        String actriz = SolicitarCosas.solicitarStringSinLimite("Intropduzca el nombre de la actriz");
        int anyo = SolicitarCosas.solicitarEnteroNoLimit("Introduzca el año de la pelicula");
        gestion.altaPelicula(titulo,autor,formato,duracion,actor,actriz,anyo);
    }

    /**
     * metodo para dar de alta un juego
     */
    public static void darAltaJuego(){
        String titulo = SolicitarCosas.solicitarStringSinLimite("Introduzca el titulo del videojuego");
        if (gestion.comprobarSiExisteJuegoPorTitulo(titulo)){
            System.err.println("El VideoJuego ya existe");
            return;
        }
        String autor = SolicitarCosas.solicitarStringSinLimite("Escriba el nombre del autor del videojuego");
        vista.mostrarEnum();
        int idex = SolicitarCosas.solicitarEntero("Inrtoduzca el formato del Videojuego",1,4);
        Formato formato = indexToFormato(idex);
        String plataforma = SolicitarCosas.solicitarStringSinLimite("Introduzca la plataforma del videojuego");
        int anyo = SolicitarCosas.solicitarEnteroNoLimit("Introduzca el año del videojuego");
        gestion.altaVideojuego(titulo,autor,formato,plataforma,anyo);
    }

    /**
     * Metodo para dar de alta un socio
     */
    public static void darAltaSocio(){
        String nif = SolicitarCosas.solicitarString("Introduzca el NIF del socio a dar de alta",9,9);
        if (!verificarNIF(nif)){
            System.err.println("El NIF no es valido");
            return;
        }
        if (gestion.comprobarSiExisteSocioPorNif(nif)) {
            System.err.println("El NIF ese ya eatá dado de alta");
            return;
        }

        String nombre = SolicitarCosas.solicitarStringSinLimite("Introduzca el nombre de el Socio");
        LocalDate fechNac = SolicitarCosas.solicitarFecha("Introduzca la fecha de nacimiento", "dd-MM-yyyy");
        if (saberSiEsMayor(fechNac)){
            System.err.println("El socio es menor de edad");
            return;
        }
        String poblacion = SolicitarCosas.solicitarStringSinLimite("Introduzca la poblacion de residencia");
        gestion.altaSocio(nif,nombre,fechNac,poblacion);
        System.out.println(gestion.getSocios().toString());
    }

    /**
     * metodo para verificar un NIF
     * @param nif es el nif que queremos comprobar de que sea valido
     * @return true si es valido y false si no
     */
    public static boolean verificarNIF(String nif) {
        if (nif == null || nif.length() != 9) {
            return false;
        }

        String numeroParte = nif.substring(0, 8);
        if (!numeroParte.matches("\\d{8}")) {
            return false;
        }

        char letra = Character.toUpperCase(nif.charAt(8));
        if (!Character.isLetter(letra)) {
            return false;
        }

        int numero = 0;
        for (char c : numeroParte.toCharArray()) {
            numero = numero * 10 + (c - '0');
        }
        char letraCalculada = LETRAS_NIF.charAt(numero % 23);
        return letra == letraCalculada;
    }

    /**
     * Metodo para la seleccion del enum
     * @param index Es la posicion de lo que quiere
     * @return Devuelve la seleccion en enum Formato
     */
    public static Formato indexToFormato(int index){
        boolean check = true;
        do {
            switch (index){
                case 1 -> {
                    return Formato.CD;
                }
                case 2->{
                    return Formato.DVD;
                }
                case 3->{
                    return Formato.BLU_RAY;
                }
                case 4 ->{
                    return Formato.ARCHIVO;
                }default ->{
                    System.err.println("Opción no valida, introduzca una válida");
                    check = false;
                }
            }
        }while (!check);
        return null;
    }

    /**
     * Metodo para comprobar de que sea mayor de edad
     * @param fechNac la fecha de naciemiento
     * @return True si es y false si no
     */
    public static boolean saberSiEsMayor(LocalDate fechNac){
        int edad = Period.between(fechNac,LocalDate.now()).getYears();
        if (edad < 18){
            return true;
        }
        return false;
    }

    /**
     * Metodo para alquilar multimeda
     */
    public static void alquilarMultimedia(){
        System.out.println(gestion.getSocios().toString());
        String nif = SolicitarCosas.solicitarString("Introduzca el nif del socio interesado",9,9);
        if (!gestion.comprobarSiExisteSocioPorNif(nif)){
            System.err.println("El NIF introducido no existe");
            return;
        } else if (gestion.tieneDeudas(nif)){
            System.err.println("No se le puede alquilar nada porque tiene deuda");
            return;
        } else if (!gestion.puedeAlquilar(nif)) {
            System.err.println("Aun tiene que devolver lo anterior");
            return;
        }

        System.out.println(gestion.getMultimedia().toString());
        String titulo = SolicitarCosas.solicitarStringSinLimite("Introduzca el titulo de lo que desea alquilar");
        if (!gestion.comprobarSiExisteMultimediaPorTitulo(titulo)){
            System.err.println("La multimedia no existe");
            return;
        }
        gestion.alquilarMultimedia(titulo,nif);
    }

    /**
     * Metodo para devolver multimedia
     */
    public static void devolverMultimedia(){
        System.out.println(gestion.getSocios().toString());
        String nif = SolicitarCosas.solicitarStringSinLimite("Introduzca el NIF del socio");
        if (!gestion.comprobarSiExisteSocioPorNif(nif)){
            System.err.println("No existe ningun socio con ese NIF");
            return;
        }

        System.out.println(gestion.getMultimedia().toString());
        String titulo = SolicitarCosas.solicitarStringSinLimite("Introduzca el titulo que quiere devolver");
        if (!gestion.comprobarSiExisteMultimediaPorTitulo(titulo)){
            System.err.println("No existe esa multimedia");
            return;
        }

        if (!gestion.tieneQueDevolver(titulo,nif)){
            System.err.println("No tiene que devolver eso");
            return;
        }else {
            gestion.devolver(titulo,nif);
        }

    }


}
