package impl;

import api.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {

	int[] arr;
	int cant;
	
	@Override
	public void InicializarConjunto() {
		arr = new int[20];
		cant = 0;
	}

	@Override
	public void Agregar(int x) {
		if (!Pertenece(x)) {
			arr[cant] = x;
			cant++;
		}

	}

	@Override
	public void Sacar(int x) {
		int i = 0;
		while(i < cant && arr[i] != x)
			i++;
		if (i < cant) {
			arr[i] = arr[cant - 1];
			cant--;
		}
			
	}

	@Override
	public int Elegir() {
		return arr[0];
	}

	@Override
	public boolean Pertenece(int x) {
		int i = 0;
		while(i < cant && arr[i] != x)
			i++;
		return (i < cant);
	}

	@Override
	public boolean ConjuntoVacio() {
		return (cant == 0);
	}

	public void MostrarConjunto() {
		ConjuntoTDA aux = new Conjunto();
		aux.InicializarConjunto();
		int g;
		System.out.print("{ ");
		while(!this.ConjuntoVacio()) {
			g=this.Elegir();
			this.Sacar(g);
			aux.Agregar(g);
			System.out.print(g+" ");
		}
		System.out.print("}");
		while(!aux.ConjuntoVacio()) {
			g=aux.Elegir();
			aux.Sacar(g);
			this.Agregar(g);
		}

	}
}