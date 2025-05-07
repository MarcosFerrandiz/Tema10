package com.marcosferrandiz.Ejercicio6;

public class  Videojuego extends Multimedia {
    private final String plataforma;
    private final int anyo;

    public Videojuego(String titulo, String autor, Formato formato, String plataforma, int anyo) {
        super(titulo, autor, formato);
        this.plataforma = plataforma;
        this.anyo = anyo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getAnyo() {
        return anyo;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "plataforma='" + plataforma + '\'' +
                '}'+ super.toString();
    }
}
