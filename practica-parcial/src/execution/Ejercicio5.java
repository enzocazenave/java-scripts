package execution;

import impl.Conjunto;
import impl.Diccionario;

public class Ejercicio5 {
    public static void main(String[] args) {
        Diccionario d1 = new Diccionario();
        Diccionario d2 = new Diccionario();
        d1.InicializarDiccionario();
        d2.InicializarDiccionario();

        d1.Agregar(0, 1);
        d1.Agregar(1, 2);
        d1.Agregar(1, 3);
        d2.Agregar(0, 4);
        d2.Agregar(0, 5);
        d2.Agregar(1, 10);
        d2.Agregar(2, 6);
        d2.Agregar(3, 7);

        Diccionario dClavesComunes = clavesComunes(d1, d2);
    }

    public static Diccionario clavesComunes(Diccionario d1, Diccionario d2) {
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

            while (!valoresD1.conjuntoVacio()) {
                int valor = valoresD1.elegir();
                diccionario.Agregar(clave, valor);
                valoresD1.sacarElemento(valor);
                System.out.println("CLAVE: " + clave + " | VALOR: " + valor);
            }

            while (!valoresD2.conjuntoVacio()) {
                int valor = valoresD2.elegir();
                diccionario.Agregar(clave, valor);
                valoresD2.sacarElemento(valor);
                System.out.println("CLAVE: " + clave + " | VALOR: " + valor);
            }

            conjuntoClavesComunes.sacarElemento(clave);
        }

        return diccionario;
    }
}
