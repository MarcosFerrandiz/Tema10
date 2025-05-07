package com.marcosferrandiz.Ejercicio6;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Socio {
    private final String nif;
    private final String nombre;
    private final LocalDate fechNac;
    private String poblacion;

    public Socio(String nif, String nombre, LocalDate fechNac, String poblacion) {
        this.nif = nif;
        this.nombre = nombre;
        this.fechNac = fechNac;
        this.poblacion = poblacion;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechNac() {
        return fechNac;
    }

    public int getEdad(){
        return Period.between(fechNac,LocalDate.now()).getYears();
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(nif, socio.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nif);
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechNac=" + fechNac +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }
}
