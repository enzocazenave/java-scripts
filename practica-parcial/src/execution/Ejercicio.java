package execution;

import impl.Cola;
import impl.Pila;

public class Ejercicio {
    public static void main(String[] args) {
        Pila pila = new Pila();

        pila.InicializarPila();

        pila.Apilar(9);
        pila.Apilar(8);
        pila.Apilar(5);
        pila.Apilar(8);
        pila.Apilar(9);


        if (esCapicua(pila)) {
            System.out.println("Es capicua");
        } else {
            System.out.println("No es capicua");
        }
    }

    public static boolean esCapicua(Pila pila) {
        boolean resultado = true;
        Pila pilaAux = new Pila();
        Pila pilaAuxOriginal = new Pila();
        Cola colaAux = new Cola();

        pilaAux.InicializarPila();
        pilaAuxOriginal.InicializarPila();
        colaAux.InicializarCola();

        while (!pila.PilaVacia()) {
            pilaAux.Apilar(pila.Tope());
            pilaAuxOriginal.Apilar(pila.Tope());
            colaAux.Acolar(pila.Tope());
            pila.Desapilar();
        }

        while (!pilaAux.PilaVacia()) {
            if (pilaAux.Tope() != colaAux.Primero()) {
                resultado = false;
                break;
            }

            pilaAux.Desapilar();
            colaAux.Desacolar();
        }

        while (!pilaAuxOriginal.PilaVacia()) {
            pila.Apilar(pilaAuxOriginal.Tope());
            System.out.println(pilaAuxOriginal.Tope());
            pilaAuxOriginal.Desapilar();
        }

        return resultado;
    }
}
