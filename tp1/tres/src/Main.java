package tp1.tres.src;

public class Main {
    public static void main(String[] args) {
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();

        cola1.InicializarCola();
        cola2.InicializarCola();

        cola1.Acolar(2);
        cola1.Acolar(1);
        cola1.Acolar(5);
        cola1.Acolar(7);

        cola1.InvertirColaSinPila();
    }
}
