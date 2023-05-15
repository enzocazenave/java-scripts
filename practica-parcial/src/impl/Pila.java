package impl;

public class Pila {
    public class Nodo {
        int info;
        Nodo sig;
    }

    private Nodo origen;

    public void InicializarPila() {
        origen = null;
    }

    public void Apilar(int x) {
        Nodo nuevo = new Nodo();

        nuevo.info = x;
        nuevo.sig = origen;

        origen = nuevo;
    }

    public void Desapilar() {
        origen = origen.sig;
    }

    public int Tope() {
        return origen.info;
    }

    public boolean PilaVacia() {
        return (origen == null);
    }
}
