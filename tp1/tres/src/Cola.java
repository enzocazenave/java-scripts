package tp1.tres.src;

import src.Pila;

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
        for (int i = 0; i < 100; i++) {
            System.out.println(a[i]);
        }

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

        System.out.println("");
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

    public void InvertirColaSinPila() {
        Cola colaAux = new Cola();
        colaAux.InicializarCola();

    }

    public boolean EsCapicua() {
        Pila auxPila = new Pila();
        Cola auxCola = new Cola();

        auxPila.inicializePila();
        auxCola.InicializarCola();

        boolean capicua = false;

        while (!ColaVacia()) {
            auxPila.stack(Primero());
            auxCola.Acolar(Primero());
            Desacolar();
        }

        while (!auxCola.ColaVacia()) {
            if (auxPila.getLastItem() == auxCola.Primero()) {
                capicua = true;
            } else {
                capicua = false;
            }

            auxPila.unstack();
            auxCola.Desacolar();
        }

        while (!auxCola.ColaVacia()) {
            Acolar(auxCola.Primero());
            auxCola.Desacolar();
        }

        return capicua;
    }
}
