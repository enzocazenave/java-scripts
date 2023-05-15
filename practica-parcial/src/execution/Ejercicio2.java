package execution;

import impl.Cola;
import impl.Conjunto;
import impl.Pila;

public class Ejercicio2 {
    public static void main (String[] args) {
        Pila pila = new Pila();
        Cola cola = new Cola();

        pila.InicializarPila();
        cola.InicializarCola();

        pila.Apilar(10);
        pila.Apilar(14);
        pila.Apilar(17);
        pila.Apilar(15);
        pila.Apilar(15);
        pila.Apilar(15);
        pila.Apilar(12);

        cola.Acolar(14);
        cola.Acolar(10);
        cola.Acolar(12);
        cola.Acolar(15);
        cola.Acolar(17);

        if (pilaYColaIguales(pila, cola)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
    }

    public static boolean pilaYColaIguales(Pila pila, Cola cola) {
        Conjunto pilaConjunto = new Conjunto();
        Conjunto colaConjunto = new Conjunto();
        Conjunto pilaConjuntoOriginal = new Conjunto();

        pilaConjunto.inicializarConjunto();
        colaConjunto.inicializarConjunto();
        pilaConjuntoOriginal.inicializarConjunto();

        while (!pila.PilaVacia()) {
            pilaConjunto.agregarElemento(pila.Tope());
            pilaConjuntoOriginal.agregarElemento(pila.Tope());
            pila.Desapilar();
        }

        while (!cola.ColaVacia()) {
            colaConjunto.agregarElemento(cola.Primero());
            cola.Desacolar();
        }

        while (!pilaConjunto.conjuntoVacio() && !colaConjunto.conjuntoVacio()) {
            int x = pilaConjunto.elegir();
            pilaConjunto.sacarElemento(x);

            if (!colaConjunto.pertenece(x)) return false;
        }

        while (!colaConjunto.conjuntoVacio()) {
            int x = colaConjunto.elegir();
            colaConjunto.sacarElemento(x);

            if (!pilaConjuntoOriginal.pertenece(x)) return false;
        }

        return true;
    }
}
