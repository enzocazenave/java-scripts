package execution;

import impl.Conjunto;
import impl.Diccionario;

public class Ejercicio4 {
    public static void main(String[] args) {
        Diccionario d1 = new Diccionario();
        Diccionario d2 = new Diccionario();
        d1.InicializarDiccionario();
        d2.InicializarDiccionario();

        d1.Agregar(0, 45298098);
        d1.Agregar(1, 39766864);
        d2.Agregar(0, 43892109);
        d2.Agregar(2, 39766864);
        d2.Agregar(3, 39766864);

        Diccionario dClavesPresentes = clavesPresentes(d1, d2);
    }

    public static Diccionario clavesPresentes(Diccionario d1, Diccionario d2) {
        Diccionario d = new Diccionario();
        d.InicializarDiccionario();

        Conjunto conjuntoDeClavesD1 = d1.Claves();
        Conjunto conjuntoDeClavesD2 = d2.Claves();

        while (!conjuntoDeClavesD1.conjuntoVacio()) {
            int x = conjuntoDeClavesD1.elegir();
            Conjunto valorX = d1.Recuperar(x);

            while (!valorX.conjuntoVacio()) {
                int y = valorX.elegir();
                d.Agregar(x,y);
                valorX.sacarElemento(y);
                System.out.println("CLAVE: " + x + "| VALOR: " + y);
            }

            conjuntoDeClavesD1.sacarElemento(x);
        }

        while (!conjuntoDeClavesD2.conjuntoVacio()) {
            int x = conjuntoDeClavesD2.elegir();
            Conjunto valorX = d2.Recuperar(x);

            while (!valorX.conjuntoVacio()) {
                int y = valorX.elegir();
                d.Agregar(x,y);
                valorX.sacarElemento(y);
                System.out.println("CLAVE: " + x + "| VALOR: " + y);
            }

            conjuntoDeClavesD2.sacarElemento(x);
        }

        return d;
    }
}
