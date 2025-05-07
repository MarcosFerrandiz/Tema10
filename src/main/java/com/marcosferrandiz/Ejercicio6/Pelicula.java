package com.marcosferrandiz.Ejercicio6;

public class Pelicula extends Multimedia {

    private final double duracion;
    private final String actor;
    private final String actriz;
    private final int anyo;


    public Pelicula(String titulo, String autor, Formato formato, double duracion, String actor, String actriz, int anyo) {
        super(titulo, autor, formato);
        this.duracion = duracion;
        this.actor = actor;
        this.actriz = actriz;
        this.anyo = anyo;
    }

    public double getDuracion() {
        return duracion;
    }

    public String getActor() {
        return actor;
    }

    public String getActriz() {
        return actriz;
    }

    public int getAnyo() {
        return anyo;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "duracion=" + duracion +
                ", actor='" + actor + '\'' +
                ", actriz='" + actriz + '\'' +
                '}' +
                super.toString();
    }
}
