import api.JanusTDA;
import imp.Janus;

public class Ejercicio4 {
    public static void main(String[] args) {
        // PRUEBAS LLEVADAS A CABO
        JanusTDA janus = new Janus();
        janus.InicializarJanus();

        janus.AgregarIzq(9);
        janus.AgregarIzq(8);
        janus.AgregarIzq(2);

        janus.AgregarDer(3);
        janus.AgregarDer(6);
        janus.AgregarDer(7);

        janus.EliminarIzq();
        janus.EliminarDer();
        janus.EliminarDer();

        System.out.println("Entero izquierdo: " + janus.Izquierda());
        System.out.println("Entero derecho: " + janus.Derecha());
    }
}
