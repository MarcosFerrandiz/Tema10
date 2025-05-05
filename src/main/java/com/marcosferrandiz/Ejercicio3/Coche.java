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
            //Le he puesto 30 porque si, porque le he puesto 6 para probar y me llegaba hasta 180 creo y parecía bueno
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

    /**
     * Metodo para aumentar la velocidad del vehículo, también conocido como acelerar
     * @param velocidadAcelerar Es la cantidad de velocidad que desea acelerar
     */
    public void acelerar(int velocidadAcelerar){
        if (velocidadAcelerar > 0){
            int nuevoVel = velAct + velocidadAcelerar;
            if (marchaAct > 0 && nuevoVel <= velocidadesMarchas.get(marchaAct-1)){
                velAct = nuevoVel;
            }
        }
    }

    /**
     * Metodo para disminuir la velocidad, también conocido como frenar
     * @param velocidadFrenar Es la cantidad que desea frenar
     */
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

    /**
     * Metodo para cambiar de marcha
     * @param marchaCambiar La marcha a la cual desea cambiar
     */
    void cambiarMarcha(int marchaCambiar){
        if (marchaCambiar >= 0 && marchaCambiar < velocidadesMarchas.size()){
            marchaAct = marchaCambiar;
        }
    }

    /**
     * Booleano para saber si el coche es manual o no
     * @return Devuelve true si es manual y false si no
     */
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
