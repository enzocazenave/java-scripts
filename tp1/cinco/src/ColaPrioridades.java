package tp1.cinco.src;

public class ColaPrioridades {
    int contador;
    Element[] elements;

    public void inicializarCola() {
        this.contador = 0;
        this.elements = new Element[100];
    }

    public void Acolar(int item, int prioridad) {
        int j;

        for (j = this.contador; j > 0 && this.elements[j -1].prioridad >= prioridad; j--) {
            this.elements[j] = this.elements[j - 1];
        }

        this.elements[j] = new Element(item, prioridad);
        this.contador++;
    }

    public void Desacolar() {
        elements[contador - 1] = null;
        contador--;
    }

    public boolean ColaVacia() {
        return contador == 0;
    }

    public int PrioridadDelPrimero() {
        return elements[contador - 1].prioridad;
    }

    public int ValorDelPrimero() {
        return elements[contador - 1].valor;
    }

    public void MostrarCola() {
		ColaPrioridades aux = new ColaPrioridades();
		aux.inicializarCola();

		while(!this.ColaVacia()) {
			aux.Acolar(this.ValorDelPrimero(), this.PrioridadDelPrimero());
			System.out.println(this.ValorDelPrimero() + " " + "["+ this.PrioridadDelPrimero() +"]");
			this.Desacolar();
		}

        System.out.println("-----------");

		while (!aux.ColaVacia()) {
			this.Acolar(aux.ValorDelPrimero(), aux.PrioridadDelPrimero());
			aux.Desacolar();
		}
	}
    
    class Element {
        int valor;
        int prioridad;

        public Element(int valor, int prioridad) {
            this.valor = valor;
            this.prioridad = prioridad;
        }
    }
}