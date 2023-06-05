package api;

public interface ABBTDA {
    void InicializarArbol();
    int Raiz();
    ABBTDA HijoIzq();
    ABBTDA HijoDer();
    void AgregarElem(int x);
    void EliminarElem(int x);
    boolean ArbolVacio();
}