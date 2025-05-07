package com.marcosferrandiz.Ejercicio6;

public enum Formato {
    CD,DVD,BLU_RAY,ARCHIVO;

    public int getNumero(){
        return ordinal() + 1;
    }

    @Override
    public String toString(){
        return getNumero()+". "+ name();
    }

    /**
     * Lista de todos los valores del enum
     * @return Devuelve un stringbuilder con los valores del enum
     */
    public static String listaTodos(){
        StringBuilder sb = new StringBuilder();
        for (Formato formato : values()){
            sb.append(formato.toString()).append("\n");
        }
        return sb.toString();
    }
}
