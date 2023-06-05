import impl.ABB;

public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB();
        arbol.InicializarArbol();
        arbol.AgregarElem(2);
        arbol.AgregarElem(4);
        arbol.AgregarElem(1);
        arbol.AgregarElem(3);
        System.out.println(arbol.HijoDer());
    }
}