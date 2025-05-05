package com.marcosferrandiz.Ejercicio3;

import java.util.List;

public class CocheCambioManual extends Coche{

    public CocheCambioManual(String matricula) {
        super(matricula, 6);
    }

    /**
     * Metodo para el cambio de marcha de forma manual
     * @param marchaCambiar La marcha a la cual desea cambiar
     */
    @Override
    public void cambiarMarcha(int marchaCambiar) {
        if (marchaCambiar >= 0){
            super.cambiarMarcha(marchaCambiar);
        }
    }

    /**
     * Metodo para saber que si que es manual
     * @return Devuelve true
     */
    @Override
    public boolean esCambioManual() {
        return true;
    }

}
