package execution;

import impl.Conjunto;

public class Ejercicio1 {
    public static void main(String[] args) {
        Conjunto conjunto1 = new Conjunto();
        Conjunto conjunto2 = new Conjunto();
        conjunto1.inicializarConjunto();
        conjunto2.inicializarConjunto();

        conjunto1.agregarElemento(14);
        conjunto1.agregarElemento(15);
        conjunto1.agregarElemento(16);
        conjunto1.agregarElemento(17);
        conjunto1.agregarElemento(18);
        conjunto1.agregarElemento(19);
        conjunto1.agregarElemento(20);
        conjunto1.agregarElemento(21);

        conjunto2.agregarElemento(14);
        conjunto2.agregarElemento(15);
        conjunto2.agregarElemento(16);
        conjunto2.agregarElemento(17);
        conjunto2.agregarElemento(18);
        conjunto2.agregarElemento(19);
        conjunto2.agregarElemento(20);
        conjunto2.agregarElemento(21);


        if (mismosConjuntos(conjunto1, conjunto2)) {
            System.out.println("Conjuntos iguales");
        } else {
            System.out.println("Conjuntos distintos");
        }
    }

    public static boolean mismosConjuntos(Conjunto conjunto1, Conjunto conjunto2) {
        Conjunto conjunto1Aux = new Conjunto();
        conjunto1Aux.inicializarConjunto();

        while (!conjunto1.conjuntoVacio()) {
            int x = conjunto1.elegir();
            conjunto1Aux.agregarElemento(x);
            conjunto1.sacarElemento(x);

            if (!conjunto2.pertenece(x)) return false;
        }

        while (!conjunto2.conjuntoVacio()) {
            int x = conjunto2.elegir();
            conjunto2.sacarElemento(x);

            if (!conjunto1Aux.pertenece(x)) return false;
        }

        return true;
    }
}
