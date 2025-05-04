package com.marcosferrandiz.Ejercicio2;

import com.marcosferrandiz.Ejercicio1.Punto;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<Punto> listaPuntos = new ArrayList<>();
        listaPuntos.add(new Punto(0,0));
        listaPuntos.add(new Punto(2,0));
        listaPuntos.add(new Punto(2,2));
        listaPuntos.add(new Punto(0,2));
        Poligono poligono = new Poligono(listaPuntos);

        System.out.println("Numero de vertices: "+poligono.numVertices());
        System.out.println("Perimetro: "+poligono.perimetro());
        System.out.println(poligono.toString());
        poligono.traslada(4,-3);
        System.out.println(poligono.toString());
    }
}
