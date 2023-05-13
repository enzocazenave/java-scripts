import impl.ColaLD;
import impl.ConjuntoTA;
import impl.PilaLD;

public class Ejercicio1 {
    public static void main(String[] args) {
        // TEST 1
        System.out.println("TEST 1");
        PilaLD pilaTest1 = new PilaLD();
        ColaLD colaTest1 = new ColaLD();
        pilaTest1.InicializarPila();
        colaTest1.InicializarCola();

        colaTest1.Acolar(7);
        colaTest1.Acolar(1);
        colaTest1.Acolar(1);
        colaTest1.Acolar(7);
        colaTest1.Acolar(3);
        colaTest1.Acolar(2);
        colaTest1.Acolar(3);
        colaTest1.Acolar(20);

        pilaTest1.Apilar(4);
        pilaTest1.Apilar(20);
        pilaTest1.Apilar(2);
        pilaTest1.Apilar(30);
        pilaTest1.Apilar(21);
        pilaTest1.Apilar(1);
        pilaTest1.Apilar(15);

        ConjuntoTA conjuntoTest1 = mismosElementos(pilaTest1, colaTest1);

        while (!conjuntoTest1.conjuntoVacio()) {
            int x = conjuntoTest1.elegir();
            System.out.println(x);
            conjuntoTest1.sacarElemento(x);
        }

        System.out.println("----------------------------");

        // TEST 2
        System.out.println("TEST 2");
        PilaLD pilaTest2 = new PilaLD();
        ColaLD colaTest2 = new ColaLD();
        pilaTest2.InicializarPila();
        colaTest2.InicializarCola();

        pilaTest2.Apilar(1);
        pilaTest2.Apilar(2);
        pilaTest2.Apilar(3);

        colaTest2.Acolar(30);
        colaTest2.Acolar(4);
        colaTest2.Acolar(10);

        ConjuntoTA conjuntoTest2 = mismosElementos(pilaTest2, colaTest2);

        while (!conjuntoTest2.conjuntoVacio()) {
            int x = conjuntoTest2.elegir();
            System.out.println(x);
            conjuntoTest2.sacarElemento(x);
        }
    }

    public static ConjuntoTA mismosElementos(PilaLD pila, ColaLD cola) {
        ConjuntoTA conjuntoDeRepetidos = new ConjuntoTA();
        ConjuntoTA conjuntoAux = new ConjuntoTA();

        conjuntoDeRepetidos.inicializarConjunto();
        conjuntoAux.inicializarConjunto();

        while (!pila.PilaVacia()) {
            conjuntoAux.agregarElemento(pila.Tope());
            pila.Desapilar();
        }

        while (!cola.ColaVacia()) {
            if (conjuntoAux.pertenece(cola.Primero()))
                conjuntoDeRepetidos.agregarElemento(cola.Primero());


            cola.Desacolar();
        }

        return conjuntoDeRepetidos;
    }
}