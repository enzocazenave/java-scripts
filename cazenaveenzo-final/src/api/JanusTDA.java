package api;

public interface JanusTDA {
    void InicializarJanus();    // Sin precondiciones
    void AgregarIzq(int x);     // Janus inicializada
    void AgregarDer(int x);     // Janus inicializada
    void EliminarIzq();         // Janus inicializada y no vacio
    void EliminarDer();         // Janus inicializada y no vacio
    int Izquierda();            // Janus inicializada y no vacio
    int Derecha();              // Janus inicializada y no vacio
    boolean JanusVacio();       // Pila Janus
}
