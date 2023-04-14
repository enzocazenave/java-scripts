package src;

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
    
    public void showPila() {
		Pila aux = new Pila();
		aux.inicializePila();
		while(!isPilaEmpty()){
			System.out.println(getLastItem());
			aux.stack(getLastItem());
			unstack();
		}
		while(!aux.isPilaEmpty()) {
			stack(aux.getLastItem());
			aux.unstack();
		}
	}

    public int[] getPila() {
        return a;
    }
}
