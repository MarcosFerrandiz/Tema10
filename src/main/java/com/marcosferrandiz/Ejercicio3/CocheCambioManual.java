package com.marcosferrandiz.Ejercicio3;

import java.util.List;

public class CocheCambioManual extends Coche{
    public CocheCambioManual(String matricula) {
        super(matricula, 6);
    }

    @Override
    public void cambiarMarcha(int marchaCambiar) {
        if (marchaCambiar >= 0){
            super.cambiarMarcha(marchaCambiar);
        }
    }

    @Override
    public boolean esCambioManual() {
        return true;
    }

}
