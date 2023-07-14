package imp;

import api.JanusTDA;
import api.PilaTDA;

public class Janus implements JanusTDA {
    /*
        COMPLEJIDAD: LINEAL
        COSTO: o(1)
     */

    PilaTDA enterosIzquierda; // o(1)
    PilaTDA enterosDerecha;   // o(1)

    public void InicializarJanus() {
        enterosIzquierda = new PilaTF(); // o(1)
        enterosDerecha = new PilaTF(); // o(1)
        enterosIzquierda.InicializarPila(); // o(1)
        enterosDerecha.InicializarPila(); // o(1)
    }

    public void AgregarDer(int x) {
        enterosDerecha.Apilar(x); // o(1)
    }

    public void AgregarIzq(int x) {
        enterosIzquierda.Apilar(x); // o(1)
    }

    public void EliminarIzq() {
        if (this.JanusVacio()) return; // o(1)
        enterosIzquierda.Desapilar(); // o(1)
    }

    public void EliminarDer() {
        if (this.JanusVacio()) return; // o(1)
        enterosDerecha.Desapilar(); // o(1)
    }

    public int Izquierda() {
        return enterosIzquierda.Tope(); // o(1)
    }

    public int Derecha() {
        return enterosDerecha.Tope(); // o(1)
    }

    public boolean JanusVacio() {
        return (enterosIzquierda.PilaVacia() && enterosDerecha.PilaVacia()); // o(1)
    }
}
