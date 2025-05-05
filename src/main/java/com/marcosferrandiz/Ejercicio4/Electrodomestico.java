package com.marcosferrandiz.Ejercicio4;

public class Electrodomestico {
    protected final double precioBase;
    protected final Color colores;
    protected final ConsumoEnergetico consumoEnergetico;
    protected final double peso;

    public Electrodomestico() {
        this.precioBase = 100;
        this.colores = Color.BLANCO;
        this.consumoEnergetico = ConsumoEnergetico.F;
        this.peso = 5;
    }

    public Electrodomestico(double peso, double precioBase) {
        this.peso = peso;
        this.precioBase = precioBase;
        this.colores = Color.BLANCO;
        this.consumoEnergetico = ConsumoEnergetico.F;
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.colores = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public Color getColores() {
        return colores;
    }

    public ConsumoEnergetico getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    /**
     * Metodo para com,probar de que existe el tipo de consumo que queramos
     * @param letra Es la letra del tipo de Consumo que queremos seleccionar
     * @return Devuelve la letra en forma de enum ConsumoEnergetico, en el caso de que no exista se devolverá el F
     */
    private ConsumoEnergetico comprobarConsumoEnergetico(char letra){
        letra = Character.toUpperCase(letra);
        ConsumoEnergetico arrayConsumos[] = ConsumoEnergetico.values();
        for (int i = 0; i < arrayConsumos.length ; i++) {
            if (letra == arrayConsumos[i].toString().charAt(0)){
                return arrayConsumos[i];
            }
        }
        return ConsumoEnergetico.F;
    }

    /**
     * Metodo para comprobar si el color escrito existe o es una posibilkidad
     * @param color Es el color que queremos elegir
     * @return Devuelve el color que elegimos en forma de enum Color, en el caso de que no exista se le añadira el color Blanco
     */
    private Color comprobarColor(String color){
        color.toLowerCase();
        switch (color){
            case "negro" -> {return Color.NEGRO;}
            case "rojo" ->{return Color.ROJO;}
            case "azul" ->{return Color.AZUL;}
            case "gris" ->{return Color.GRIS;}
            default -> {return Color.BLANCO;}
        }
    }

    /**
     * Metodo para calcular el precio final de un producto
     * @return Devuelve el precio final del producto añadiendole extras y de mas
     */
    public double precioFinal(){
        double precioFinal = precioBase;
        switch (consumoEnergetico){
            case A -> precioFinal += 100;
            case B -> precioFinal += 80;
            case C -> precioFinal += 60;
            case D -> precioFinal += 50;
            case E -> precioFinal += 30;
            case F -> precioFinal += 10;
        }
        if (peso >= 0 && peso <= 19){
            precioFinal += 10;
        } else if (peso >= 20 && peso <= 49) {
            precioFinal += 50;
        } else if (peso >= 50 && peso <= 79) {
            precioFinal += 80;
        } else if (peso > 80) {
            precioFinal += 100;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "precioBase=" + precioBase +
                ", colores=" + colores +
                ", consumoEnergetico=" + consumoEnergetico +
                ", peso=" + peso +
                '}';
    }
}
