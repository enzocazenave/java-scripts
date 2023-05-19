package execution;

import impl.Conjunto;
import impl.Diccionario;

public class Ejercicio6 {
    public static void main(String[] args) {
        Diccionario d1 = new Diccionario();
        Diccionario d2 = new Diccionario();
        d1.InicializarDiccionario();
        d2.InicializarDiccionario();

        d1.Agregar(0, 1);
        d2.Agregar(0, 1);
        d2.Agregar(0, 3);
        d1.Agregar(1,2);
        d2.Agregar(1,3);

        Diccionario dClavesComunesValoresComunes = clavesComunesValoresComunes(d1, d2);
    }

    public static Diccionario clavesComunesValoresComunes(Diccionario d1, Diccionario d2) {
        Diccionario diccionario = new Diccionario();
        Conjunto conjuntoClavesComunes = new Conjunto();

        diccionario.InicializarDiccionario();
        conjuntoClavesComunes.inicializarConjunto();

        Conjunto conjuntoDeClavesD1 = d1.Claves();
        Conjunto conjuntoDeClavesD2 = d2.Claves();

        while (!conjuntoDeClavesD1.conjuntoVacio()) {
            int clave = conjuntoDeClavesD1.elegir();

            if (conjuntoDeClavesD2.pertenece(clave)) {
                conjuntoClavesComunes.agregarElemento(clave);
            }

            conjuntoDeClavesD1.sacarElemento(clave);
        }

        while (!conjuntoClavesComunes.conjuntoVacio()) {
            int clave = conjuntoClavesComunes.elegir();
            Conjunto valoresD1 = d1.Recuperar(clave);
            Conjunto valoresD2 = d2.Recuperar(clave);
            Conjunto conjuntoValoresComunes = new Conjunto();
            conjuntoValoresComunes.inicializarConjunto();

            while (!valoresD1.conjuntoVacio()) {
                int valor = valoresD1.elegir();

                if (valoresD2.pertenece(valor)) {
                    conjuntoValoresComunes.agregarElemento(valor);
                }

                valoresD1.sacarElemento(valor);
            }

            while (!conjuntoValoresComunes.conjuntoVacio()) {
                int valor = conjuntoValoresComunes.elegir();
                diccionario.Agregar(clave, valor);
                conjuntoValoresComunes.sacarElemento(valor);
            }

            conjuntoClavesComunes.sacarElemento(clave);
        }

        return diccionario;
    }
}
