package com.marcosferrandiz.Ejercicio4;

public class Television extends Electrodomestico{
    private final double resolucion;
    private final boolean smartTv;

    public Television() {
        this.resolucion = 20;
        this.smartTv = false;
    }

    public Television(double peso, double precioBase) {
        super(peso, precioBase);
        this.resolucion = 20;
        this.smartTv = false;
    }

    public Television(double precioBase, String color, char consumoEnergetico, double peso, double resolucion, boolean smartTv) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.smartTv = smartTv;
    }

    public double getResolucion() {
        return resolucion;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();
        if (resolucion > 40){
            precioFinal += ((precioFinal* 30) / 100);
        }
        if (smartTv){
            precioFinal += 50;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Television{" +
                "resolucion=" + resolucion +
                ", smartTv=" + smartTv +
                ", precioBase=" + precioBase +
                ", colores=" + colores +
                ", consumoEnergetico=" + consumoEnergetico +
                ", peso=" + peso +
                '}';
    }
}
