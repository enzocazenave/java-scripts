import api.ConjuntoTDA;
import api.GrafoTDA;
import impl.Conjunto;
import impl.Grafo;

public class Ejercicio2 {
    public static void main(String[] args) {
        GrafoTDA grafo = new Grafo();
        grafo.InicializarGrafo();

        grafo.AgregarVertice(1);
        grafo.AgregarVertice(2);
        grafo.AgregarVertice(3);
        grafo.AgregarVertice(4);
        grafo.AgregarVertice(5);
        grafo.AgregarVertice(6);
        grafo.AgregarVertice(7);

        grafo.AgregarArista(1,2,4);

        ConjuntoTDA aislados = VerticesAislados(grafo);
        aislados.MostrarConjunto();
    }

    public static ConjuntoTDA VerticesAislados(GrafoTDA grafo) {
        ConjuntoTDA conjuntoVerticesAislados = new Conjunto();
        ConjuntoTDA conjuntoAuxiliar1 = new Conjunto();
        ConjuntoTDA conjuntoAuxiliar2 = new Conjunto();

        conjuntoVerticesAislados.InicializarConjunto();
        conjuntoAuxiliar1.InicializarConjunto();
        conjuntoAuxiliar2.InicializarConjunto();

        conjuntoAuxiliar1 = grafo.Vertices();
        int vertice1;
        int vertice2;
        boolean aislado;

        while (!conjuntoAuxiliar1.ConjuntoVacio()) {
            conjuntoAuxiliar2 = grafo.Vertices();
            vertice1 = conjuntoAuxiliar1.Elegir();
            aislado = true;

            while (aislado && !conjuntoAuxiliar2.ConjuntoVacio()) {
                vertice2 = conjuntoAuxiliar2.Elegir();

                if ((grafo.ExisteArista(vertice1, vertice2) || grafo.ExisteArista(vertice2, vertice1)) && (vertice1 != vertice2)) {
                    aislado = false;
                }
                conjuntoAuxiliar2.Sacar(vertice2);
            }

            if (aislado) conjuntoVerticesAislados.Agregar(vertice1);

            conjuntoAuxiliar1.Sacar(vertice1);
        }

        return conjuntoVerticesAislados;
    }
}
