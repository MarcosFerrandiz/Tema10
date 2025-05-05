package com.marcosferrandiz.Ejercicio4;

import java.util.ArrayList;

public class Ejercicio4 {
    private static ArrayList<Electrodomestico> cosasElectronicas = new ArrayList<>(10);

    public static void main(String[] args) {
        cosasElectronicas.add(new Television(1200,"negro",'a',20,72,true));
        cosasElectronicas.add(new Television(41,120));
        cosasElectronicas.add(new Television());
        cosasElectronicas.add(new Lavadora());
        cosasElectronicas.add(new Lavadora(49,600));
        cosasElectronicas.add(new Lavadora(49,"azul",'C',60,31));

        double totalTeles = 0;
        double totalLavadoras = 0;
        double totalTotalesTodo = 0;

        for (int i = 0; i < cosasElectronicas.size() ; i++) {
            System.out.println(cosasElectronicas.get(i).toString());
            System.out.println(cosasElectronicas.get(i).precioFinal());

            totalTotalesTodo += cosasElectronicas.get(i).precioFinal();

            if (cosasElectronicas.get(i) instanceof Television){
                totalTeles += cosasElectronicas.get(i).precioFinal();
            } else if (cosasElectronicas.get(i) instanceof Lavadora) {
                totalLavadoras += cosasElectronicas.get(i).precioFinal();
            }
        }
        System.out.println("Total Teles: "+ totalTeles);
        System.out.println("Total Lavadoras: "+ totalLavadoras);
        System.out.println("Total de todo el total de todo: "+ totalTotalesTodo);
    }
}
