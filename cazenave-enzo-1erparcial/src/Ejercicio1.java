import impl.ParOrdenado;

public class Ejercicio1 {
    public static void main(String[] args) {
        ParOrdenado parOrdenado = new ParOrdenado();
        parOrdenado.InicializarPar();

        // ########### TEST 1 ###########
        System.out.println("########### TEST 1 ###########");
        parOrdenado.Cargar(10, 20);
        System.out.println("PRIMERO: " + parOrdenado.Primero());
        System.out.println("SEGUNDO: " + parOrdenado.Segundo());

        // ########### TEST 2 ###########
        parOrdenado.Reiniciar();
        System.out.println("########### TEST 2 ###########");
        System.out.println("PRIMERO: " + parOrdenado.Primero());
        System.out.println("SEGUNDO: " + parOrdenado.Segundo());
    }
}
