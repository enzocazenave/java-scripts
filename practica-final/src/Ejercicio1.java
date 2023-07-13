import impl.Cola;
import impl.Conjunto;

public class Ejercicio1 {
    public static void main(String[] args) {
        Cola colaA = new Cola();
        Cola colaB = new Cola();

        colaA.InicializarCola();
        colaB.InicializarCola();

        colaA.Acolar(1);
        colaA.Acolar(2);
        colaA.Acolar(2);
        colaA.Acolar(1);
        colaA.Acolar(3);
        colaA.Acolar(1);
        
        colaB.Acolar(3);
        colaB.Acolar(1);
        colaB.Acolar(1);
        colaB.Acolar(2);

        boolean resultado = contienenMismosElementos(colaA, colaB);
        System.out.println("------");
        System.out.println(resultado);
        System.out.println("------");
        mostrarCola(colaA);
        System.out.println("------");
        mostrarCola(colaB);
        System.out.println("------");
    }

    public static void mostrarCola(Cola cola) {
        Cola colaAuxiliar = new Cola();
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

    public static boolean contienenMismosElementos(Cola colaA, Cola colaB) {
        boolean resultado = true; // 1

        Cola colaAuxiliarA = new Cola(); // 1
        Cola colaAuxiliarB = new Cola(); // 1
        Conjunto conjuntoAuxiliarA = new Conjunto(); // 1
        Conjunto conjuntoAuxiliarB = new Conjunto(); // 1

        colaAuxiliarA.InicializarCola(); // 1
        colaAuxiliarB.InicializarCola(); // 1
        conjuntoAuxiliarA.InicializarConjunto(); // 1
        conjuntoAuxiliarB.InicializarConjunto(); // 1

        while (!colaA.ColaVacia()) { // n
            colaAuxiliarA.Acolar(colaA.Primero()); // n
            conjuntoAuxiliarA.Agregar(colaA.Primero()); // n
            colaA.Desacolar(); // 1
        }

        while (!colaB.ColaVacia()) {
            colaAuxiliarB.Acolar(colaB.Primero());
            conjuntoAuxiliarB.Agregar(colaB.Primero());
            colaB.Desacolar();
        }

        while (!colaAuxiliarA.ColaVacia()) { // n
            int primero = colaAuxiliarA.Primero();

            if (!conjuntoAuxiliarB.Pertenece(primero)) { // n
                resultado = false;
            }

            colaA.Acolar(primero); // n
            colaAuxiliarA.Desacolar(); // n
        }

        while (!colaAuxiliarB.ColaVacia()) {
            int primero = colaAuxiliarB.Primero();

            if (!conjuntoAuxiliarA.Pertenece(primero)) {
                resultado = false;
            }

            colaB.Acolar(primero);
            colaAuxiliarB.Desacolar();
        }

        return resultado;
    } // n^2
}