package impl;

import api.ContadorTDA;

public class Contador implements ContadorTDA {
    int contador;

    public void inicializarContador() {
        contador = 0;
    }

    public void Contar() {
        contador += 1;
    }

    public void Descontar() {
        if (contador != 0) {
            contador -= 1;
        }
    }

    public void Reiniciar() {
        contador = 0;
    }

    public void Incrementar(int x) {
        contador += x;
    }

    public int Mostrar() {
        return this.contador;
    }
}
