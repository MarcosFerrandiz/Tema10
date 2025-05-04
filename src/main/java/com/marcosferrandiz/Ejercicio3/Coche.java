package com.marcosferrandiz.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public abstract class Coche {
    private final String matricula;
    private int velAct;
    private int marchaAct;
    private List<Integer> velocidadesMarchas;

    public Coche(String matricula, int marchas) {
        this.matricula = matricula;
        this.velAct = 0;
        this.marchaAct = 0;
        this.velocidadesMarchas = new ArrayList<>(marchas);
        for (int i = 0; i < marchas ; i++) {
            velocidadesMarchas.add((i + 1) *30);
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public int getVelAct() {
        return velAct;
    }

    public void setVelAct(int velAct) {
        if (velAct >= 0) {
            this.velAct = velAct;
        }
    }

    public int getMarchaAct() {
        return marchaAct;
    }

    public void setMarchaAct(int marchaAct) {
        if (marchaAct >= 0 && marchaAct < velocidadesMarchas.size()) {
            this.marchaAct = marchaAct;
        }    }

    public List<Integer> getVelocidadesMarchas() {
        return velocidadesMarchas;
    }

    public void setVelocidadesMarchas(List<Integer> velocidadesMarchas) {
        this.velocidadesMarchas = velocidadesMarchas;
    }

    public void acelerar(int velocidadAcelerar){
        if (velocidadAcelerar > 0){
            int nuevoVel = velAct + velocidadAcelerar;
            if (marchaAct > 0 && nuevoVel <= velocidadesMarchas.get(marchaAct-1)){
                velAct = nuevoVel;
            }
        }
    }

    public void frenar(int velocidadFrenar){
        if (velocidadFrenar > 0) {
            int nuevaVel = velAct - velocidadFrenar;
            if (nuevaVel >= 0) {
                velAct = nuevaVel;
            } else {
                velAct = 0;
            }
        }
    }

    void cambiarMarcha(int marchaCambiar){
        if (marchaCambiar >= 0 && marchaCambiar < velocidadesMarchas.size()){
            marchaAct = marchaCambiar;
        }
    }

    public abstract boolean esCambioManual();

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", velAct=" + velAct +
                ", marchaAct=" + marchaAct +
                ", velocidadesMarchas=" + velocidadesMarchas +
                '}';
    }
}
