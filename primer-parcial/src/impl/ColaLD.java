package impl;
import api.ColaTDA;

public class ColaLD implements ColaTDA {
    private class Nodo{
        int info;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    @Override
    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    @Override
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

    @Override
    public void Desacolar() {
        if(primero == ultimo) {
            primero = null;
            ultimo = null;
        }else {
            primero = primero.sig;
        }
    }

    @Override
    public int Primero() {
        return primero.info;
    }
    @Override
    public boolean ColaVacia() {
        return (primero==null);
    }
}
