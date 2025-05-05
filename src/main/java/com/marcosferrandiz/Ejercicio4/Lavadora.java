package com.marcosferrandiz.Ejercicio4;

public class Lavadora extends Electrodomestico {
    private final double CARGA_PRED = 5;
    private final double carga;

    public Lavadora() {
        this.carga = CARGA_PRED;
    }

    public Lavadora(double peso, double precioBase) {
        super(peso, precioBase);
        this.carga = CARGA_PRED;
    }

    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }
    @Override
    public double precioFinal(){
        double precioFinal = super.precioFinal();
        if (carga > 30){
            precioFinal += 50;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Lavadora{" +
                "carga=" + carga +
                ", precioBase=" + precioBase +
                ", colores=" + colores +
                ", consumoEnergetico=" + consumoEnergetico +
                ", peso=" + peso +
                '}';
    }
}
