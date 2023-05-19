import impl.Contador;

public class Ejercicio2 {
    public static void main(String[] args) {
        Contador contador = new Contador();

        contador.inicializarContador();
        contador.Contar();
        contador.Contar();
        contador.Contar();
        contador.Contar();
        contador.Descontar();

        System.out.println(contador.Mostrar());

        contador.Reiniciar();

        System.out.println(contador.Mostrar());

        contador.Incrementar(5);

        System.out.println(contador.Mostrar());
    }
}
