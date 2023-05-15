package impl;

public class Cola {
    private class Nodo{
        int info;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    public void Acolar(int x) {
        Nodo nuevo = new Nodo();

        nuevo.info = x;
        nuevo.sig = null;

        if(ultimo == null) {
            primero = nuevo;
            ultimo = nuevo;
        }else {
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
    }

    public void Desacolar() {
        if(primero == ultimo) {
            primero = null;
            ultimo = null;
        }else {
            primero = primero.sig;
        }
    }

    public int Primero() {
        return primero.info;
    }

    public boolean ColaVacia() {
        return (primero==null);
    }
}
