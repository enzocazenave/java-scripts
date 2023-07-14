import api.ConjuntoTDA;
import api.GrafoTDA;
import imp.ConjuntoTA;
import imp.GrafoLA;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("##### EJERCICIO 3 #####");
        GrafoTDA grafo = new GrafoLA();
        grafo.InicializarGrafo();

        grafo.AgregarVertice(1);
        grafo.AgregarVertice(2);
        grafo.AgregarVertice(3);
        grafo.AgregarVertice(4);
        grafo.AgregarVertice(5);
        grafo.AgregarVertice(6);
        grafo.AgregarVertice(7);

        grafo.AgregarArista(2,3,4);
        grafo.AgregarArista(2,5,4);
        grafo.AgregarArista(6,2,4);
        grafo.AgregarArista(4,5,4);

        grafo.AgregarArista(7,1,4);

        ConjuntoTDA conjuntoVerticesConectados = verticesConectados(grafo, 2);

        System.out.print("Conjunto con los vertices conectados al 2: ");
        conjuntoVerticesConectados.MostrarConjunto();
    }

    public static ConjuntoTDA verticesConectados(GrafoTDA grafo, int vertice) {
        /*
            COMPLEJIDAD: EXPONENCIAL
            COSTO: o(n^4)
         */
        ConjuntoTDA verticesGrafo = grafo.Vertices(); // o(n^2)
        ConjuntoTDA verticesConectados = new ConjuntoTA(); // o(1)
        verticesConectados.InicializarConjunto();
        int verticesGrafoElegido;

        while (!verticesGrafo.ConjuntoVacio()) { // o(n)
            verticesGrafoElegido = verticesGrafo.Elegir(); // o(1)

            if ((verticesGrafoElegido != vertice) && (grafo.ExisteArista(verticesGrafoElegido, vertice) || grafo.ExisteArista(vertice, verticesGrafoElegido))) { // o(n^2)
                verticesConectados.Agregar(verticesGrafoElegido); // o(n)
            }

            verticesGrafo.Sacar(verticesGrafoElegido); // o(n)
        }

        return verticesConectados; // o(1)
    }
}
