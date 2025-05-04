package com.marcosferrandiz.Ejercicio3;

import java.util.List;

public class CocheCambioAutomatico extends Coche{
    public CocheCambioAutomatico(String matricula) {
        super(matricula, 6);
    }

    /**
     * Metodo acelerar para el coche automatico, que cambia la marcha sola
     * @param velocidadAcelerar Es la velocidad que queremos acelerar
     */
    @Override
    public void acelerar(int velocidadAcelerar) {
        if (velocidadAcelerar > 0){
            int nuevaVel = getVelAct() + velocidadAcelerar;
            for (int i = 0; i < getVelocidadesMarchas().size() ; i++) {
                if (nuevaVel <= getVelocidadesMarchas().get(i)){
                    setMarchaAct(i+1);
                    break;
                }
            }
            setVelAct(nuevaVel);
        }
    }

    /**
     * Metodo de frenada de coche automatico que cambia de marchas automaticamente
     * @param velocidadFrenar Es la velocidad que queremos frenar
     */
    @Override
    public void frenar(int velocidadFrenar) {
        if (velocidadFrenar > 0){
            int nuevaVel = getVelAct() - velocidadFrenar;
            if (nuevaVel >= 0){
                for (int i = 0; i < getVelocidadesMarchas().size() ; i++) {
                    if (nuevaVel <= getVelocidadesMarchas().get(i)){
                        setMarchaAct(i + 1);
                        break;
                    }
                }
                setVelAct(nuevaVel);
            } else {
                setVelAct(0);
                setMarchaAct(0);
            }
        }
    }

    /**
     * Metodo para saber si el coche es manual o automatico (es mas de ayuda que funcional)
     * @return Devuelve false
     */
    @Override
    public boolean esCambioManual() {
        return false;
    }
}
