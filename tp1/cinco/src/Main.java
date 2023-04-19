package tp1.cinco.src;

public class Main {
    public static void main(String[] args) {
        ColaPrioridades cola1 = new ColaPrioridades();
        ColaPrioridades cola2 = new ColaPrioridades();
        cola1.inicializarCola();
        cola2.inicializarCola();

        cola1.Acolar(10, 2);
        cola1.Acolar(7, 1);
        cola1.Acolar(10, 2);
        cola2.Acolar(7,1);

        if (SonColasIguales(cola1, cola2)) {
            System.out.println("Las colas son iguales");
        } else {
            System.out.println("Las colas no son iguales");
        }
    }
    
    public static boolean SonColasIguales(ColaPrioridades cola1, ColaPrioridades cola2) {
        if (cola1.contador != cola2.contador) return false;

        ColaPrioridades cola1Aux = new ColaPrioridades(); 
        ColaPrioridades cola2Aux = new ColaPrioridades();
        cola1Aux.inicializarCola();
        cola2Aux.inicializarCola();

        boolean iguales = true;

        while (!cola1.ColaVacia()) {
            if (cola1.ValorDelPrimero() != cola2.ValorDelPrimero()) {
                iguales = false;
                break;
            }

            cola1Aux.Acolar(cola1.ValorDelPrimero(), cola1.PrioridadDelPrimero());
            cola2Aux.Acolar(cola2.ValorDelPrimero(), cola2.PrioridadDelPrimero());

            cola1.Desacolar();
            cola2.Desacolar();
        }

        while (!cola1Aux.ColaVacia()) {
            cola1.Acolar(cola1Aux.ValorDelPrimero(), cola1Aux.PrioridadDelPrimero());
            cola2.Acolar(cola2Aux.ValorDelPrimero(), cola2Aux.PrioridadDelPrimero());
            cola1Aux.Desacolar();
            cola2Aux.Desacolar();
        }

        return iguales;
    }

    public static ColaPrioridades combinarColaPrioridades(ColaPrioridades cola1, ColaPrioridades cola2) {
        ColaPrioridades cola3 = new ColaPrioridades();
        cola3.inicializarCola();

        while (!cola1.ColaVacia()) {
            cola3.Acolar(cola1.ValorDelPrimero(), cola1.PrioridadDelPrimero());
            cola1.Desacolar();
        } 

        while (!cola2.ColaVacia()) {
            cola3.Acolar(cola2.ValorDelPrimero(), cola2.PrioridadDelPrimero());
            cola2.Desacolar();
        }

        return cola3;
    }
}       