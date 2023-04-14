package tp1.dos.src;

public class Pila {
    int a[];
    int cont;

    public void inicializePila() {
        a = new int[100];
    }

    public void stack(int item) {
        if (cont < 100) {
            a[cont] = item;
            cont++;
        }
    }

    public void unstack() {
        if (!isPilaEmpty())
            cont--;
    }

    public boolean isPilaEmpty() {
        return cont == 0;
    }

    public int getLastItem() {
        return a[cont - 1];
    }

    public void moveAndInvertPila(Pila pilaDestino) {
        while (!isPilaEmpty()) {
            pilaDestino.stack(getLastItem());
            unstack();
        }
    }

    public void invertPila() { 
        Pila aux = new Pila(); 
        Pila aux2 = new Pila();

        while (!isPilaEmpty()) {
            aux.stack(getLastItem());
            unstack();
        }
        while (!aux.isPilaEmpty()) {
            aux2.stack(aux.getLastItem());
            aux.unstack();
        }
        while(!aux2.isPilaEmpty()) {
            stack(aux2.getLastItem());
            aux2.unstack();
        }
    }

    public void copyPila(Pila pilaDestino) {
        Pila aux = new Pila();
        aux.inicializePila();

        while (!isPilaEmpty()) {
            aux.stack(getLastItem());
            unstack();
        }

        while (!aux.isPilaEmpty()) {
            pilaDestino.stack(aux.getLastItem());
            stack(aux.getLastItem());
            aux.unstack();
        }
    }

    public int countElements() {
        Pila aux = new Pila();
        aux.inicializePila();

        int contador = 0;

        while (!isPilaEmpty()) {
            contador++;
            aux.stack(getLastItem());
            unstack();
        }

        while(!aux.isPilaEmpty()) {
            stack(aux.getLastItem());
            aux.unstack();
        }
        
        return contador;
    }

    public int additionOfElements() {
        Pila aux = new Pila();
        aux.inicializePila();

        int suma = 0;

        while (!isPilaEmpty()) {
            suma += getLastItem();
            aux.stack(getLastItem());
            unstack();
        }

        while (!isPilaEmpty()) {
            stack(aux.getLastItem());
            aux.unstack();
        }

        return suma;
    }

    public float averageOfElements() {
        Pila aux = new Pila();
        aux.inicializePila();

        float addition = 0;
        float qtty = 0;

        while (!isPilaEmpty()) {
            qtty++;
            addition += getLastItem();
            aux.stack(getLastItem());
            unstack();
        }

        while (!isPilaEmpty()) {
            stack(aux.getLastItem());
            aux.unstack();
        }

        return addition / qtty;
    }

    public void showPila() {
        if (!isPilaEmpty()) {
            for (int i = 0; i < 100; i++) {
                System.out.println(a[i]);
            }
        } else {
            System.out.println("La pila esta vacia");
        }
    }

    public int[] getPila() {
        return a;
    }
}
