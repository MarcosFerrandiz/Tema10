package com.marcosferrandiz.Ejercicio1;

public class Punto {
    private double x;
    private double y;

    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distancia(Punto punto){
        double distx = this.x - punto.getX();
        double disty = this.y - punto.getY();
        return Math.sqrt(distx * distx + disty * disty);
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
