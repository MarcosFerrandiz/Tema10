package com.marcosferrandiz.Ejercicio3;

import com.marcosferrandiz.lib.SolicitarCosas;

public class Ejercicio3 {
    public static void main(String[] args) {
        Gestion gestion = new Gestion();

        boolean matriculaCheck = false;
        do {
            String matricula = SolicitarCosas.solicitarString("Introduzca la matricula del coche",7,8);
            try {
                boolean esAuto = SolicitarCosas.solicitarBoolean("¿El coche es automatico?");
                gestion.crearCoche(matricula,esAuto);
                matriculaCheck = true;
                System.out.println(gestion.infoCoche());

                if (!esAuto){
                    int marcha = SolicitarCosas.solicitarInt("Introduzca la marcha que desee",0);
                    gestion.cambiarMarchaCoche(marcha);
                    System.out.println("Cambiar marcha: "+ gestion.infoCoche());
                }

                int velocidad = SolicitarCosas.solicitarInt("Introduzca la velocidad que desee",0);
                gestion.acelerarCoche(velocidad);
                System.out.println("Acelerar: "+ gestion.infoCoche());

                int frenada = SolicitarCosas.solicitarInt("Introduzca cuanto desea frenar",0);
                gestion.frenarCoche(frenada);
                System.out.println("Frenar: "+ gestion.infoCoche());

            }catch (IllegalArgumentException iae){
                System.err.println(iae.getMessage());
            }
        }while (!matriculaCheck);
    }
}
