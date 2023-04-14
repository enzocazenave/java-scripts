package src;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();

        pila.inicializePila();
        pila.stack(2);
        pila.stack(3);
        pila.stack(11);
        pila.stack(9);

        pila.unstack();

        //pila.showPila();

        System.out.println(pila.getLastItem());
    }
}