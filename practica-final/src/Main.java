import impl.Cola;
import impl.Conjunto;

public class Main {
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
        colaB.Acolar(4);

        boolean resultado = contienenMismosElementos(colaA, colaB);
        
        System.out.println(resultado);
    }

    public static boolean contienenMismosElementos(Cola colaA, Cola colaB) {
        boolean resultado = true;

        Cola colaAuxiliarA = new Cola();
        Cola colaAuxiliarB = new Cola();
        Conjunto conjuntoAuxiliarA = new Conjunto();
        Conjunto conjuntoAuxiliarB = new Conjunto();

        colaAuxiliarA.InicializarCola();
        colaAuxiliarB.InicializarCola();
        conjuntoAuxiliarA.InicializarConjunto();
        conjuntoAuxiliarB.InicializarConjunto();

        while (!colaA.ColaVacia()) {
            colaAuxiliarA.Acolar(colaA.Primero());
            conjuntoAuxiliarA.Agregar(colaA.Primero());
            colaA.Desacolar();
        }

        while (!colaB.ColaVacia()) {
            colaAuxiliarB.Acolar(colaB.Primero());
            conjuntoAuxiliarB.Agregar(colaB.Primero());
            colaB.Desacolar();
        }

        while (!colaAuxiliarA.ColaVacia()) {
            int primero = colaAuxiliarA.Primero();

            if (!conjuntoAuxiliarB.Pertenece(primero)) {
                resultado = false;
            }

            colaA.Acolar(primero);
            colaAuxiliarA.Desacolar();
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
    }
}