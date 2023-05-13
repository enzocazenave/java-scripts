package impl;
import api.PilaTDA;

public class PilaLD implements PilaTDA {
    public class Nodo {
        int info;
        Nodo sig;
    }

    private Nodo origen;

    @Override
    public void InicializarPila() {
        origen = null;
    }

    @Override
    public void Apilar(int x) {
        Nodo nuevo = new Nodo();

        nuevo.info = x;
        nuevo.sig = origen;

        origen = nuevo;

    }

    @Override
    public void Desapilar() {
        origen = origen.sig;
    }

    @Override
    public int Tope() {
        return origen.info;
    }

    @Override
    public boolean PilaVacia() {
        return (origen == null);
    }
}
