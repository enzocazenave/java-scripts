package impl;

import api.PilaTDA;

public class Pila implements PilaTDA {

	int[] arr;		// Aquí se guardan los números de la pila. El tope al final
	int cant;		// Cantidad de elementos en la pila
	
	@Override
	public void InicializarPila() {
		arr = new int[20];
		cant = 0;
	}

	@Override
	public void Apilar(int x) {
		arr[cant] = x;
		cant++;
	}

	@Override
	public void Desapilar() {
		cant--;
	}

	@Override
	public int Tope() {
		return arr[cant-1];
	}

	@Override
	public boolean PilaVacia() {
		return (cant == 0);
	}
}