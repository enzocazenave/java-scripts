package tp1.tres.src;

import tp1.dos.src.Pila;

public class Cola {
    int[] a;
    int cont;

    public void InicializarCola() {
		a = new int[100];
		cont = 0;
	}
	
	public void Acolar(int x) {
		for(int i = cont - 1; i >= 0; i--) {
			a[i + 1] = a[i];
		}

		a[0] = x;
		cont++;
	}
	
	public void Desacolar() {
		cont--;
	}
	
	public boolean ColaVacia() {
		return cont == 0;
	}
	
	public int Primero() {
		return a[cont - 1];
	}
	
	public void MostrarCola() {
		Cola aux = new Cola();
		aux.InicializarCola();

		while(!this.ColaVacia()) {
			aux.Acolar(this.Primero());
			System.out.print(this.Primero() + " ");
			this.Desacolar();
		}

		while (!aux.ColaVacia()) {
			this.Acolar(aux.Primero());
			aux.Desacolar();
		}
	}

    public void PasarCola(Cola colaDestino) {
        Cola aux = new Cola();
        aux.InicializarCola();

        while (!ColaVacia()) {
            aux.Acolar(Primero());
            Desacolar();
        }

        while (!aux.ColaVacia()) {
            colaDestino.Acolar(aux.Primero());
            aux.Desacolar();
        }
    }

    public void InvertirCola() {
        Pila pilaAux = new Pila();
        pilaAux.inicializePila();

        while (!ColaVacia()) {
            pilaAux.stack(Primero());
            Desacolar();
        }

        while (!pilaAux.isPilaEmpty()) {
            Acolar(pilaAux.getLastItem());
            pilaAux.unstack();
        }
    }

    public boolean EsCapicua() {
        Pila auxPila = new Pila();
        Cola auxCola = new Cola();

        auxPila.inicializePila();
        auxCola.InicializarCola();

        boolean capicua = true;

        while (!ColaVacia()) {
            auxPila.stack(Primero());
            auxCola.Acolar(Primero());
            Desacolar();
        }

        while (!auxCola.ColaVacia()) {
            if (auxPila.getLastItem() != auxCola.Primero()) {
                capicua = false;
            }

            Acolar(auxCola.Primero());
            auxPila.unstack();
            auxCola.Desacolar();
        }

        return capicua;
    }
}