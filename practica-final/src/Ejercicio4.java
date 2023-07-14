import api.ColaTDA;
import api.ConjuntoTDA;
import api.PilaTDA;
import impl.Cola;
import impl.Conjunto;
import impl.Pila;

public class Ejercicio4 {
    public static void main(String[] args) {
        ColaTDA cola1 = new Cola();
        PilaTDA pila = new Pila();

        cola1.InicializarCola();
        pila.InicializarPila();

        pila.Apilar(1);
        pila.Apilar(2);
        pila.Apilar(2);
        pila.Apilar(1);
        pila.Apilar(3);
        pila.Apilar(1);

        cola1.Acolar(3);
        cola1.Acolar(1);
        cola1.Acolar(2);

        System.out.println(mismosElementos(cola1, pila));

        ColaTDA cola2 = new Cola();
        cola2.InicializarCola();

        cola2.Acolar(1);
        cola2.Acolar(2);

        System.out.println(mismosElementos(cola2, pila));

        ColaTDA cola3 = new Cola();
        cola3.InicializarCola();

        cola3.Acolar(3);
        cola3.Acolar(2);
        cola3.Acolar(1);
        cola3.Acolar(4);

        System.out.println(mismosElementos(cola3, pila));

        mostrarPila(pila);
    }

    public static boolean mismosElementos(ColaTDA cola, PilaTDA pila) {
        ColaTDA colaAuxiliar1 = new Cola();
        ColaTDA colaAuxiliar2 = new Cola();
        ConjuntoTDA conjuntoAuxiliar1 = new Conjunto();
        ConjuntoTDA conjuntoAuxiliar2 = new Conjunto();

        colaAuxiliar1.InicializarCola();
        colaAuxiliar2.InicializarCola(); 
        conjuntoAuxiliar1.InicializarConjunto();
        conjuntoAuxiliar2.InicializarConjunto();

        boolean result = true;

        while (!cola.ColaVacia()) {
            int primero = cola.Primero();
            colaAuxiliar1.Acolar(primero);
            conjuntoAuxiliar1.Agregar(primero); 
            cola.Desacolar();
        }

        while (!pila.PilaVacia()) {
            int tope = pila.Tope();
            colaAuxiliar2.Acolar(tope);
            conjuntoAuxiliar2.Agregar(tope);
            pila.Desapilar();
        }

        while (!colaAuxiliar1.ColaVacia()) {
            int primero = colaAuxiliar1.Primero();
            if (result && !conjuntoAuxiliar2.Pertenece(primero)) result = false;

            cola.Acolar(primero);
            colaAuxiliar1.Desacolar();
        }

        while (!colaAuxiliar2.ColaVacia()) {
            int primero = colaAuxiliar2.Primero();
            if (result && !conjuntoAuxiliar1.Pertenece(primero)) result = false;

            pila.Apilar(primero);
            colaAuxiliar2.Desacolar();
        }

        return result;
    }

    public static void mostrarCola(ColaTDA cola) {
        ColaTDA colaAuxiliar = new Cola();
        colaAuxiliar.InicializarCola();

        while (!cola.ColaVacia()) {
            int primero = cola.Primero();
            System.out.println(primero);
            colaAuxiliar.Acolar(primero);
            cola.Desacolar();
        }

        while (!colaAuxiliar.ColaVacia()) {
            cola.Acolar(colaAuxiliar.Primero());
            colaAuxiliar.Desacolar();
        }
    }

    public static void mostrarPila(PilaTDA pila) {
        PilaTDA pilaAuxiliar = new Pila();
        pilaAuxiliar.InicializarPila();

        while (!pila.PilaVacia()) {
            int tope = pila.Tope();
            System.out.println(tope);
            pilaAuxiliar.Apilar(tope);
            pila.Desapilar();
        }

        while (!pilaAuxiliar.PilaVacia()) {
            pila.Apilar(pilaAuxiliar.Tope());
            pilaAuxiliar.Desapilar();
        }
    }
}
