import api.ColaTDA;
import api.ConjuntoTDA;
import api.PilaTDA;
import imp.ColaPU;
import imp.ConjuntoTA;
import imp.PilaTF;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("##### EJERCICIO 1 #####");
        PilaTDA pila = new PilaTF();
        ColaTDA cola1 = new ColaPU();
        pila.InicializarPila();
        cola1.InicializarCola();

        pila.Apilar(1);
        pila.Apilar(2);
        pila.Apilar(2);
        pila.Apilar(1);
        pila.Apilar(3);
        pila.Apilar(1);

        cola1.Acolar(3);
        cola1.Acolar(1);
        cola1.Acolar(2);

        boolean resultTest1 = mismosElementos(pila, cola1);
        System.out.println("TEST 1: " + resultTest1);

        ColaTDA cola2 = new ColaPU();
        cola2.InicializarCola();

        cola1.Acolar(1);
        cola1.Acolar(2);

        boolean resultTest2 = mismosElementos(pila, cola2);
        System.out.println("TEST 2: " + resultTest2);

        ColaTDA cola3 = new ColaPU();
        cola3.InicializarCola();

        cola3.Acolar(3);
        cola3.Acolar(2);
        cola3.Acolar(1);
        cola3.Acolar(4);

        boolean resultTest3 = mismosElementos(pila, cola3);
        System.out.println("TEST 3: " + resultTest3);
    }

    public static boolean mismosElementos(PilaTDA pila, ColaTDA cola) {
        /*
            COMPLEJIDAD: CUADRATICA
            COSTO: o(n^2)
         */
        boolean result = true; // o(1)

        ColaTDA colaAuxiliar1 = new ColaPU(); // o(1)
        ColaTDA colaAuxiliar2 = new ColaPU(); // o(1)
        ConjuntoTDA conjuntoAuxiliar1 = new ConjuntoTA(); // o(1)
        ConjuntoTDA conjuntoAuxiliar2 = new ConjuntoTA(); // o(1)

        colaAuxiliar1.InicializarCola(); // o(1)
        colaAuxiliar2.InicializarCola(); // o(1)
        conjuntoAuxiliar1.InicializarConjunto(); // o(1)
        conjuntoAuxiliar2.InicializarConjunto(); // o(1)

        while (!pila.PilaVacia()) { // o(n)
            int tope = pila.Tope(); // o(1)
            colaAuxiliar1.Acolar(tope); // o(n)
            conjuntoAuxiliar1.Agregar(tope); // o(n)
            pila.Desapilar(); // o(1)
        }

        while (!cola.ColaVacia()) { // o(n)
            int primero = cola.Primero(); // o(1)
            colaAuxiliar2.Acolar(primero); // o(n)
            conjuntoAuxiliar2.Agregar(primero); // o(n)
            cola.Desacolar(); // o(1)
        }

        while (!colaAuxiliar1.ColaVacia()) { // o(n)
            int primero = colaAuxiliar1.Primero(); // o(1)
            cola.Acolar(primero); // o(n)

            if (result && !conjuntoAuxiliar2.Pertenece(primero)) result = false; // o(n)
            colaAuxiliar1.Desacolar(); // o(1)
        }

        while (!colaAuxiliar2.ColaVacia()) { // o(n)
            int primero = colaAuxiliar2.Primero(); // o(1)
            pila.Apilar(primero); // o(1)

            if (result && !conjuntoAuxiliar1.Pertenece(primero)) result = false; // o(n)
            colaAuxiliar2.Desacolar(); // o(1)
        }

        return result; // o(1)
    }
}