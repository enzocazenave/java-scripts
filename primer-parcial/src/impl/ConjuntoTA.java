package impl;
import api.ConjuntoTDA;
import java.util.Random;

public class ConjuntoTA implements ConjuntoTDA {
    private int []elementos;
    private int indice;

    @Override
    public void inicializarConjunto() {
        elementos = new int[100];
        indice = 0;

    }

    @Override
    public boolean pertenece(int elemento) {
        for(int i=0; i<indice; i++) {
            if(elementos[i]==elemento)
                return true;
        }

        return false;
    }

    @Override
    public void agregarElemento(int elemento) {
        if(!pertenece(elemento)) {
            elementos[indice]=elemento;
            indice++;
        }
    }

    @Override
    public void sacarElemento(int elemento) {
        int i;

        for(i=0; i<indice&&elementos[i]!=elemento;i++);

        if(i<indice) {
            elementos[i]=elementos[indice-1];
            indice--;
        }

    }

    @Override
    public int elegir() {
        Random rnd = new Random();
        int elegido = 0;

        elegido = rnd.nextInt(indice);

        return elementos[elegido];
    }

    @Override
    public boolean conjuntoVacio() {
        return (indice==0);
    }
}
