package tp1.dos.src;

public class Main {
    public static void main(String[] args) {
        Pila pila1 = new Pila();
        Pila pila2 = new Pila();

        pila1.inicializePila();
        pila2.inicializePila();

        pila1.stack(2);
        pila1.stack(4);
        pila1.stack(6);
        pila1.stack(1);

        System.out.println(pila1.averageOfElements());
        
        

        //pila1.showPila();
        //System.out.println("--------");
        //pila2.showPila();
    }
}