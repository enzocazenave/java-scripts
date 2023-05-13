package api;

public interface ConjuntoTDA {
    void inicializarConjunto();
    boolean pertenece(int elemento);
    void agregarElemento(int elemento);
    void sacarElemento(int elemento);
    int elegir();
    boolean conjuntoVacio();
}

