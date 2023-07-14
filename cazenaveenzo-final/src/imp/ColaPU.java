package imp;

import api.ColaTDA;

public class ColaPU implements ColaTDA {

    int[] arr;
    int cant;

    @Override
    public void InicializarCola() {
        arr = new int[20];
        cant = 0;
    }

    @Override
    public void Acolar(int x) {
        for(int i = cant - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = x;
        cant++;
    }

    @Override
    public void Desacolar() {
        cant--;
    }

    @Override
    public int Primero() {
        return arr[cant - 1];
    }

    @Override
    public boolean ColaVacia() {
        return (cant == 0);
    }
}
