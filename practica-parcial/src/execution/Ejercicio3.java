package execution;

import impl.Conjunto;
import impl.Pila;

public class Ejercicio3 {
        public static void main(String[] args){
            Pila pila = new Pila();

            pila.InicializarPila();

            pila.Apilar(1);
            pila.Apilar(1);
            pila.Apilar(2);
            pila.Apilar(3);
            pila.Apilar(3);
            pila.Apilar(3);
            pila.Apilar(2);
            pila.Apilar(4);

            Conjunto conjuntoDeRepetidos = elementosRepetidosDePila(pila);

            System.out.println("----- Conjunto de repetidos -----");
            while (!conjuntoDeRepetidos.conjuntoVacio()) {
                int x = conjuntoDeRepetidos.elegir();
                System.out.println(x);
                conjuntoDeRepetidos.sacarElemento(x);
            }
        }

        public static Conjunto elementosRepetidosDePila(Pila pila){
            Conjunto conjuntoAux = new Conjunto();
            Conjunto conjuntoDeRepetidos = new Conjunto();

            conjuntoAux.inicializarConjunto();
            conjuntoDeRepetidos.inicializarConjunto();

            while (!pila.PilaVacia()) {
                if (!conjuntoAux.pertenece(pila.Tope())) {
                    conjuntoAux.agregarElemento(pila.Tope());
                } else {
                    conjuntoDeRepetidos.agregarElemento(pila.Tope());
                }

                pila.Desapilar();
            }

            return conjuntoDeRepetidos;
        }
}
