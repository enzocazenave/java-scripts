package impl;
import java.util.Random;

public class Conjunto {
    private int []elementos;
    private int indice;

    public void inicializarConjunto() {
        elementos = new int[100];
        indice = 0;

    }

    public boolean pertenece(int elemento) {
        for(int i=0; i<indice; i++) {
            if(elementos[i]==elemento)
                return true;
        }

        return false;
    }

    public void agregarElemento(int elemento) {
        if(!pertenece(elemento)) {
            elementos[indice]=elemento;
            indice++;
        }
    }

    public void sacarElemento(int elemento) {
        int i;

        for(i=0; i<indice&&elementos[i]!=elemento;i++);

        if(i<indice) {
            elementos[i]=elementos[indice-1];
            indice--;
        }

    }

    public int elegir() {
        Random rnd = new Random();
        int elegido = 0;

        elegido = rnd.nextInt(indice);

        return elementos[elegido];
    }

    public boolean conjuntoVacio() {
        return (indice==0);
    }
}
