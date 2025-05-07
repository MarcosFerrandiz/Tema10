package com.marcosferrandiz.Ejercicio6;

import java.time.LocalDate;
import java.time.Period;

public class Alquiler {
    private final Multimedia multimedia;
    private final Socio socio;
    private double precio = 4;
    private final LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private boolean devuelto;
    private double deuda;


    public Alquiler(Multimedia multimedia, Socio socio) {
        this.multimedia = multimedia;
        this.socio = socio;
        this.fechaAlquiler = LocalDate.now();
        if (multimedia instanceof Pelicula && ((Pelicula) multimedia).getAnyo() < 2012 || multimedia instanceof  Videojuego && ((Videojuego) multimedia).getAnyo() < 2010){
            precio -= 1;
        }
        this.precio = precio;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public Socio getSocio() {
        return socio;
    }

    public double getPrecio() {
        return precio;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Metodo para devolver un producto
     */
    public void devolver(){
        fechaDevolucion = LocalDate.now();
        devuelto = true;

        int dias = Period.between(fechaAlquiler,fechaDevolucion).getDays();

        if (dias > 3){
            deuda = deuda + (2 * dias);
        }
    }

    /**
     * Para saber si esta devuelto o no
     * @return True si si que esta devuelto o false si no
     */
    public boolean isDevuelto() {
        return devuelto;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "devuelto=" + devuelto +
                ", fechaDevolucion=" + fechaDevolucion +
                ", fechaAlquiler=" + fechaAlquiler +
                ", precio=" + precio +
                ", socio=" + socio +
                ", multimedia=" + multimedia +
                '}';
    }
}
