package impl;

public class Diccionario {

    class Elemento{
        int clave;
        int[] valores;
        int cantValores;
    }

    Elemento[] arr;
    int cantClaves;

    public void InicializarDiccionario() {
        arr = new Elemento[20];
        cantClaves = 0;
    }

    public void Agregar(int clave, int valor) {
        int PosC = Clave2Indice(clave);
        if (PosC == -1) {
            PosC = cantClaves;
            arr[PosC] = new Elemento();
            arr[PosC].clave = clave;
            arr[PosC].valores = new int[20];
            arr[PosC].cantValores = 0;
            cantClaves++;
        }
        int PosV = Valor2Indice(arr[PosC], valor);
        if (PosV == -1) {
            arr[PosC].valores[arr[PosC].cantValores] = valor;
            arr[PosC].cantValores++;
        }
    }

    public void Eliminar(int clave) {
        int PosC = Clave2Indice(clave);
        if (PosC != -1) {
            arr[PosC] = arr[cantClaves - 1];
            cantClaves--;
        }
    }

    public void EliminarValor(int clave, int valor) {
        int PosC = Clave2Indice(clave);
        if (PosC != -1) {
            int PosV = Valor2Indice(arr[PosC], valor);
            if (PosV != -1) {
                arr[PosC].valores[PosV] = arr[PosC].valores[arr[PosC].cantValores - 1];
                arr[PosC].cantValores--;
                if (arr[PosC].cantValores == 0)
                    Eliminar(clave);
            }
        }
    }

    public Conjunto Recuperar(int clave) {
        Conjunto c = new Conjunto();
        c.inicializarConjunto();
        int PosC = Clave2Indice(clave); // o(n)
        if (PosC != -1) {
            for(int i = 0; i < arr[PosC].cantValores; i++) { // o(n)
                c.agregarElemento(arr[PosC].valores[i]); // o(n)
            }
            return c;
        }
        return null;
    }

    public Conjunto Claves() {
        Conjunto c = new Conjunto();
        c.inicializarConjunto();
        for (int i = 0; i < cantClaves; i++)
            c.agregarElemento(arr[i].clave);
        return c;
    }

    private int Clave2Indice(int clave) {
        int i = cantClaves - 1;
        while(i >= 0 && arr[i].clave != clave)
            i--;
        return i;
    }

    private int Valor2Indice(Elemento e, int valor) {
        int i = e.cantValores - 1;
        while(i >= 0 && e.valores[i] != valor)
            i--;
        return i;
    }
}

