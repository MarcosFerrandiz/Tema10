package com.marcosferrandiz.Ejercicio6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gestion {
    private final List<Socio> socios;
    private final List<Multimedia> multimedia;
    private final List<Alquiler> alquileres;

    public Gestion() {
        this.socios = new ArrayList<>();
        this.multimedia = new ArrayList<>();
        this.alquileres = new ArrayList<>();
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    /**
     * Metodo para dar de alta una pelicula
     * @param titulo el titulo de la pelicula
     * @param autor El autor
     * @param formato El formato de tipo Formato
     * @param duracion La duracion
     * @param actor El actor
     * @param actriz La actriz
     * @param anyo El año de la pelicula
     */
    public void altaPelicula(String titulo, String autor, Formato formato, double duracion, String actor, String actriz, int anyo){
        multimedia.add(new Pelicula(titulo,autor,formato,duracion, actor, actriz, anyo));
    }

    /**
     * Metodo para dar de alta un videojuego
     * @param titulo El titulo del videojuego
     * @param autor El autor
     * @param formato El formato de tipo Formato
     * @param plataforma La plataforma
     * @param anyo El año de lanzamiento
     */
    public void altaVideojuego(String titulo, String autor, Formato formato, String plataforma, int anyo){
        multimedia.add(new Videojuego(titulo, autor, formato, plataforma, anyo));
    }

    /**
     * Metodo para dar de alta un socio
     * @param nif El nif del socio
     * @param nombre El nombre
     * @param fechNac La fecha de nacimiento edn formato Localdate
     * @param poblacion La poblacion
     */
    public void altaSocio(String nif, String nombre, LocalDate fechNac, String poblacion){
        socios.add(new Socio(nif, nombre, fechNac, poblacion));
    }


    /**
     * metodo para buscar un socio por el nif
     * @param nif el nif del socio que queremos buscar
     * @return Devuelve el socio
     */
    public Socio buscarSocioPorNif(String nif){
        for (Socio socio : socios){
            if (socio.getNif().equals(nif)){
                return socio;
            }
        }
        return null;
    }

    /**
     * Metodo para saber si existe o no una pelicula
     * @param titulo El titulo de la pelicula
     * @return Devuelve true si existe y false si no
     */
    public boolean comprobarSiExistePeliculaPorTitulo(String titulo){
        for (Multimedia multimediaPeli : multimedia){
            if (multimediaPeli instanceof  Pelicula && multimediaPeli.getTitulo().equals(titulo)){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que sirve para saber si existe un videojuego por su titulo
     * @param titulo El titulo de el juego
     * @return devuelve true si ya existe y false si no
     */
    public boolean comprobarSiExisteJuegoPorTitulo(String titulo){
        for (Multimedia multimediaJuego : multimedia){
            if ( multimediaJuego instanceof Videojuego && multimediaJuego.getTitulo().equals(titulo)){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que sirve para saber si existe una multimedia con el titulo
     * @param titulo Es el titulo de lo que queremos saber si existe
     * @return Devuelve true si si y false si no
     */
    public boolean comprobarSiExisteMultimediaPorTitulo(String titulo){
        for (Multimedia multimedia1 : multimedia){
            if (multimedia1.getTitulo().equals(titulo)){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si existe el socio por en NIF
     * @param nif El nif del socio que queremos comprobar
     * @return Devuelve true si existe y false si no
     */
    public boolean comprobarSiExisteSocioPorNif(String nif){
        for (Socio socio : socios){
            if (socio.getNif().equals(nif)){
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para alquilar una multimedia
     * @param titulo Es el titulo de lo que queremos alquilar
     * @param nif Es el nif del socio al qie se lo queremos alquilar
     */
    public void alquilarMultimedia(String titulo, String nif){
        Multimedia multimediaAlquilar = sacarMultimediaPorTitulo(titulo);
        Socio socio = buscarSocioPorNif(nif);
        Alquiler alquiler = new Alquiler(multimediaAlquilar,socio);
        alquiler.setDevuelto(false);
        alquileres.add(alquiler);
    }

    /**
     * Sacamos la multiemdia por el titulo
     * @param titulo El titulo
     * @return Devuelve la multimedia con el titulo
     */
    public Multimedia sacarMultimediaPorTitulo(String titulo){
        for (Multimedia multimedia1 : multimedia){
            if (multimedia1.getTitulo().equals(titulo)){
                return multimedia1;
            }
        }
        return null;
    }

    /**
     * Metodo para saber si un socio puede alquilar o no porque no lo ha devuelto aun
     * @param nif El nif del socio
     * @return Devuelve true si si que puede alquilar y false si no
     */
    public boolean puedeAlquilar(String nif){
        Socio socio = buscarSocioPorNif(nif);
        for (Alquiler alquiler : alquileres){
            if (alquiler.getSocio().equals(socio) && !alquiler.isDevuelto()){
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo para saber si un socio tiene deudas
     * @param nif El nif del socio
     * @return Devuelve true si si que tiene deudas y false si no
     */
    public boolean tieneDeudas(String nif){
        Socio socio = buscarSocioPorNif(nif);
        for (Alquiler alquiler : alquileres){
            if (alquiler.getSocio().equals(socio) && alquiler.getDeuda() > 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para saber si tiene que devolver un socio un titulo
     * @param titulo El titulo de lo que tiene que devolver
     * @param nif El nif del socio
     * @return True o false
     */
    public boolean tieneQueDevolver(String titulo, String nif){
        Socio socio = buscarSocioPorNif(nif);
        for (Alquiler alquiler : alquileres){
            if ((alquiler.getMultimedia().getTitulo().equals(titulo) && alquiler.getSocio().equals(socio)) && !alquiler.isDevuelto()){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para devolver un titulo un socio
     * @param titulo El titulo de lo que devuelve
     * @param nif El nif del socio
     */
    public void devolver(String titulo, String nif){
        Socio socio = buscarSocioPorNif(nif);
        for (Alquiler alquiler : alquileres){
            if ((alquiler.getMultimedia().getTitulo().equals(titulo) && alquiler.getSocio().equals(socio)) && !alquiler.isDevuelto()){
                alquiler.devolver();
            }
        }
    }

    /**
     * Metodo para obetner todas las peliculas
     * @return Devuelve una List de todas las peliculas
     */
    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        if (multimedia.isEmpty()){
            System.err.println("Vacio");
        }
        for (Multimedia item : multimedia) {
            if (item instanceof Pelicula) {
                peliculas.add((Pelicula) item);
            }
        }
        System.out.println(peliculas);
        return peliculas;
    }

    /**
     * Metodo para obtener todos los videojuegos
     * @return Devuelve una List con todos los videojuegos
     */
    public List<Videojuego> obtenerVideojuegos() {
        List<Videojuego> videojuegos = new ArrayList<>();
        for (Multimedia item : multimedia) {
            if (item instanceof Videojuego) {
                videojuegos.add((Videojuego) item);
            }
        }
        return videojuegos;
    }

    /**
     * Metodo para ordenar una list de peliculas por orden alfabeticos
     * @return Devuelve una List de las peliculas ordenadas de forma alfabetica
     */
    public List<Pelicula> ordenarPeliculasPorTitulo() {
        List<Pelicula> peliculas = obtenerPeliculas();
        for (int i = 0; i < peliculas.size() - 1; i++) {
            for (int j = 0; j < peliculas.size() - 1 - i; j++) {
                if (peliculas.get(j).getTitulo().compareToIgnoreCase(peliculas.get(j + 1).getTitulo()) > 0) {
                    Pelicula temp = peliculas.get(j);
                    peliculas.set(j, peliculas.get(j + 1));
                    peliculas.set(j + 1, temp);
                }
            }
        }
        return peliculas;
    }

    /**
     * Metodo para ordenar una List de juegos por el año
     * @return Deuelve una List de videojuegos ordenadas por año
     */
    public List<Videojuego> ordenarVideojuegosPorAnyo() {
        List<Videojuego> videojuegos = obtenerVideojuegos();
        for (int i = 0; i < videojuegos.size() - 1; i++) {
            for (int j = 0; j < videojuegos.size() - 1 - i; j++) {
                if (videojuegos.get(j).getAnyo() > videojuegos.get(j + 1).getAnyo()) {
                    Videojuego temp = videojuegos.get(j);
                    videojuegos.set(j, videojuegos.get(j + 1));
                    videojuegos.set(j + 1, temp);
                }
            }
        }
        return videojuegos;
    }

    /**
     * Metodo para ver la gente con deudas
     * @return Devuelve una List con la gente que tiene deudas
     */
    public List<Socio> genteConDeudas(){
        List<Socio> sociosDeuda = new ArrayList<>();
        for (Alquiler alquiler : alquileres){
            if (alquiler.getDeuda() > 0){
                sociosDeuda.add(alquiler.getSocio());
            }
        }
        return sociosDeuda;
    }

    /**
     * Metodo para ver el historico de un socio
     * @param nif El nif del socio
     * @return Devuelve una List de Alquiler con todos los alquileres de un socio
     */
    public List<Alquiler> listaAlquileresHistoricoSocio(String nif){
        Socio socio = buscarSocioPorNif(nif);
        List<Alquiler> aluileresSocio = new ArrayList<>();
        for (Alquiler alquiler : alquileres){
            if (alquiler.getSocio().equals(socio)){
                aluileresSocio.add(alquiler);
            }
        }
        aluileresSocio = ordenarAlquileresHistoricosCliente(aluileresSocio);
        return aluileresSocio;
    }

    /**
     * Metodo para ordenar una List de alquileres historicos de un socio y ordenarlo
     * @param listaHistoricoNoOrdenada La lista del historico no ordenada
     * @return Devuelve una List con los alquileres historicos ordenados
     */
    public List<Alquiler> ordenarAlquileresHistoricosCliente(List<Alquiler> listaHistoricoNoOrdenada) {
        List<Alquiler> alquileresSocio = listaHistoricoNoOrdenada;
        for (int i = 0; i < alquileresSocio.size() - 1; i++) {
            for (int j = 0; j < alquileresSocio.size() - 1 - i; j++) {
                if (alquileresSocio.get(j).getFechaAlquiler().isAfter(alquileresSocio.get(j +i).getFechaAlquiler()) ) {
                    Alquiler temp = alquileresSocio.get(j);
                    alquileresSocio.set(j, alquileresSocio.get(j + 1));
                    alquileresSocio.set(j + 1, temp);
                }
            }
        }
        return alquileresSocio;
    }

    /**
     * Metodo de los alquileres de un socio activos
     * @param nif El nif del socio
     * @return Devuelve un List de alquileres activos de un socio
     */
    public List<Alquiler> listaAlquileresActualesSocio(String nif){
        Socio socio = buscarSocioPorNif(nif);
        List<Alquiler> alquielresClienteActivos = new ArrayList<>();
        for (Alquiler alquiler : alquileres){
            if (alquiler.getSocio().equals(socio) && !alquiler.isDevuelto()){
                alquielresClienteActivos.add(alquiler);
            }
        }
        return alquielresClienteActivos;
    }

}
