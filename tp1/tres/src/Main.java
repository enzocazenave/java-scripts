package tp1.tres.src;

public class Main {
    public static void main(String[] args) {
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();

        cola1.InicializarCola();
        cola2.InicializarCola();

        cola1.Acolar(4);
        cola1.Acolar(3);
        cola1.Acolar(3);
        cola1.Acolar(4);

        if (cola1.EsCapicua()) {
            System.out.println("Es capicua");
        } else {
            System.out.println("No es capicua");
        }

        cola1.MostrarCola();
    }
}
