package com.marcosferrandiz.Ejercicio3;

public class Gestion {
    private Coche coche;

    /**
     * metodo para crear un coche con una matricula validada para que sea de 7 caracteres sin espacio o 8 con espacio, en formato NNNN LLL o NNNNLLL
     * @param matricula Es la matricula del coche que queremos crear
     * @param esAutomatico Booleano para indicar si el coche es automatico o manual para que haga ciertas funciones
     */
    public void crearCoche(String matricula, boolean esAutomatico){
        if (matricula == null || (matricula.length() != 7 && matricula.length() != 8)) {
            throw new IllegalArgumentException("La matricula debe de tener 7 caracteres sin espacio, o 8 con un espacio entre los números y las letras");
        }

        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                throw new IllegalArgumentException("Los 4 primer caracteres de la matrícula deben ser números.");
            }
        }

        int letraStart = 4;
        if (matricula.length() == 8) {
            if (matricula.charAt(4) != ' ') {
                throw new IllegalArgumentException("Debes de tener un espacio entre las letras y los números si quieres poner 8 caracteres");
            }
            letraStart = 5;
        }

        for (int i = letraStart; i < letraStart + 3; i++) {
            if (!Character.isLetter(matricula.charAt(i))) {
                throw new IllegalArgumentException("Los últimos 3 caracteres de la matrícula tienen que ser letras.");
            }
        }

        if (esAutomatico){
            coche = new CocheCambioAutomatico(matricula);
        } else {
            coche = new CocheCambioManual(matricula);
        }
    }

    /**
     * Muestra toda la información del coche, mátricula, velocidad, marcha y velocidades de marchas
     * @return Devuelve un String con toda la información del coche, o en caso de que no exista un mensaje de que no existe
     */
    public String infoCoche(){
        if (coche != null){
            return coche.toString();
        }
        return "No hay ningún coche";
    }

    /**
     * Metodo para acelerar un coche
     * @param vel Es la velocidad que queremos acelerar
     */
    public void acelerarCoche(int vel){
        if (coche != null){
            coche.acelerar(vel);
        }
    }

    /**
     * Metodo para frenar un coche
     * @param vel Es la velocidad de frenado que queremos frenar
     */
    public void frenarCoche(int vel){
        if (coche != null){
            coche.frenar(vel);
        }
    }

    /**
     * Metodo para cambiar la marcha de un coche
     * @param marcha Es la marcha a la que queremos cambiar
     */
    public void cambiarMarchaCoche(int marcha){
        if (coche != null && coche.esCambioManual()){
            coche.cambiarMarcha(marcha);
        }
    }
}
