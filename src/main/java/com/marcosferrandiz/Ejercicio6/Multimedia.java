package com.marcosferrandiz.Ejercicio6;

import java.util.Objects;

public class Multimedia {
    private final String titulo;
    private final String autor;
    private final Formato formato;
    private int anyo;

    public Multimedia(String titulo, String autor, Formato formato) {
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
    }

    public String getTitulo() {
        return titulo;
    }


    public String getAutor() {
        return autor;
    }


    public Formato getFormato() {
        return formato;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", formato=" + formato +
                '}';
    }
}
