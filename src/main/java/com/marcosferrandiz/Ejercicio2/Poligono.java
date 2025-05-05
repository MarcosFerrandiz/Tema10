package com.marcosferrandiz.Ejercicio2;

import com.marcosferrandiz.Ejercicio1.Punto;

import java.util.List;

public class Poligono {
    private List<Punto> listaPuntos;

    public Poligono(List<Punto> listaPuntos) {
        this.listaPuntos = listaPuntos;
    }

    /**
     * Mueve todo el poligono en x e y
     * @param desplX Es la cantidad de trasladar en X
     * @param desplY Es la cantidad de trasladar en Y
     */
    public void traslada(double desplX, double desplY){
        for (Punto punto : listaPuntos){
            punto.setX(punto.getX() + desplX);
            punto.setY(punto.getY() + desplY);
        }
    }

    /**
     * Metodo para saber cuantos vertices tiene
     * @return Devuelve la cantidad de vertices de la figura
     */
    public int numVertices(){
        return listaPuntos.size();
    }

    /**
     * Metodo para calcular el perimetro
     * @return Devuelve el perimetro
     */
    public double perimetro(){
        Punto puntoSig;
        double perimetro=0;
        for (int i = 0; i < listaPuntos.size() ; i++) {
            if (i == listaPuntos.size()-1){
                puntoSig = listaPuntos.get(0);
            }else{
                puntoSig = listaPuntos.get(i+1);
            }
            perimetro += listaPuntos.get(i).distancia(puntoSig);
        }
        return perimetro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Punto punto : listaPuntos){
            sb.append(punto.toString()).append("\n");
        }
        return sb.toString();
    }
}
