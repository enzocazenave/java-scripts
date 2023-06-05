import impl.ConjuntoTA;

public class Ejercicio2 {
    public static void main(String[] args) {
        ConjuntoTA conjunto1 = new ConjuntoTA();
        ConjuntoTA conjunto2 = new ConjuntoTA();

        conjunto1.InicializarConjunto();
        conjunto2.InicializarConjunto();

        // ########### TEST 1 ###########
        System.out.println("########### TEST 1 ###########");
        conjunto1.Agregar(3);
        conjunto1.Agregar(4);
        conjunto1.Agregar(1);
        conjunto1.Agregar(2);

        conjunto2.Agregar(5);
        conjunto2.Agregar(6);
        conjunto2.Agregar(1);
        conjunto2.Agregar(2);

        ConjuntoTA conjuntoDiferenciaSimetrica1 = diferenciaSimetrica(conjunto1, conjunto2);

        while (!conjuntoDiferenciaSimetrica1.ConjuntoVacio()) {
            int x = conjuntoDiferenciaSimetrica1.Elegir();
            System.out.println(x);
            conjuntoDiferenciaSimetrica1.Sacar(x);
        }

        // ########### TEST 2 ###########
        System.out.println("########### TEST 2 ###########");
        conjunto1.Agregar(1);
        conjunto1.Agregar(2);
        conjunto1.Agregar(3);

        conjunto2.Agregar(3);
        conjunto2.Agregar(2);
        conjunto2.Agregar(1);

        ConjuntoTA conjuntoDiferenciaSimetrica2 = diferenciaSimetrica(conjunto1, conjunto2);

        while (!conjuntoDiferenciaSimetrica2.ConjuntoVacio()) {
            int x = conjuntoDiferenciaSimetrica2.Elegir();
            System.out.println(x);
            conjuntoDiferenciaSimetrica2.Sacar(x);
        }
    }

    public static ConjuntoTA diferenciaSimetrica(ConjuntoTA conjunto1, ConjuntoTA conjunto2) {
        ConjuntoTA conjuntoResultado = new ConjuntoTA(); // o(1)
        ConjuntoTA conjuntoAuxiliar = new ConjuntoTA(); // o(1)
        conjuntoResultado.InicializarConjunto(); // o(1)
        conjuntoAuxiliar.InicializarConjunto(); // o(1)

        while (!conjunto1.ConjuntoVacio()) { // o(n)
            int x = conjunto1.Elegir(); // o(1)

            if (conjunto2.Pertenece(x)) { // o(n)
                conjuntoAuxiliar.Agregar(x); // o(n)
            } else {
                conjuntoResultado.Agregar(x); // o(n)
            }

            conjunto1.Sacar(x); // o(n)
        }

        while (!conjunto2.ConjuntoVacio()) { // o(n)
            int x = conjunto2.Elegir(); // o(1)

            if (!conjuntoAuxiliar.Pertenece(x)) { // o(n)
                conjuntoResultado.Agregar(x); // o(n)
            }

            conjunto2.Sacar(x); // o(n)
        }

        return conjuntoResultado; // o(1)
    }
    /*
        DIFERENCIA SIMETRICA
        COSTO: N^3
        COMPLEJIDAD: CUBICA
    */
}