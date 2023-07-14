import api.ConjuntoTDA;
import api.GrafoTDA;
import impl.Conjunto;
import impl.Grafo;

public class Ejercicio3 {
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

        grafo.AgregarArista(2,3,4);
        grafo.AgregarArista(3,4,4);
        grafo.AgregarArista(4,5,4);

        grafo.AgregarArista(7,1,4);

        ConjuntoTDA conjuntoVerticesConectados = verticesConectados(grafo, 2);

        conjuntoVerticesConectados.MostrarConjunto();
    }

    public static ConjuntoTDA verticesConectados(GrafoTDA grafo, int vertice) {
        ConjuntoTDA verticesGrafo = grafo.Vertices();
        ConjuntoTDA verticesConectados = new Conjunto();
        verticesConectados.InicializarConjunto();

        while (!verticesGrafo.ConjuntoVacio()) {
            int verticesGrafoElegido = verticesGrafo.Elegir();

            if ((verticesGrafoElegido != vertice) && (grafo.ExisteArista(verticesGrafoElegido, vertice) || grafo.ExisteArista(vertice, verticesGrafoElegido))) {
                verticesConectados.Agregar(verticesGrafoElegido);
            }

            verticesGrafo.Sacar(verticesGrafoElegido);
        }

        return verticesConectados;
    }
}
