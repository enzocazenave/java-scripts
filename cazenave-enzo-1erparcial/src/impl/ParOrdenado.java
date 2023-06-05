package impl;

import api.ParOrdenadoTDA;

public class ParOrdenado implements ParOrdenadoTDA {
    int [] arr;

    public void InicializarPar() {
        arr = new int[2]; // o(1)
        // COMPLEJIDAD CONSTANTE
    }

    public void Cargar(int x, int y) {
        arr[0] = x; // o(1)
        arr[1] = y; // o(1)
        // COMPLEJIDAD CONSTANTE
    }

    public int Primero() {
        return arr[0]; // o(1)
        // COMPLEJIDAD CONSTANTE
    }

    public int Segundo() {
        return arr[1]; // o(1)
        // COMPLEJIDAD CONSTANTE
    }

    public void Reiniciar() {
        arr[0] = 0; // o(1)
        arr[1] = 0; // o(1)
        // COMPLEJIDAD CONSTANTE
    }
}
