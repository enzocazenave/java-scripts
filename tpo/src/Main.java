import impl.ListaAlumnos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaAlumnos ListaDeAlumnos = new ListaAlumnos();
        ListaDeAlumnos.inicializarLista();

        Scanner requestEntry = new Scanner(System.in);

        System.out.println("Cuantos alumnos desea ingresar en la lista?");
        int cantidadDeAlumnos = requestEntry.nextInt();
        System.out.println("---------------------");

        for (int i = 0; i < cantidadDeAlumnos; i ++) {
            System.out.println("Alumno ["+(i + 1)+"]");

            System.out.print("Ingrese numero de legajo: ");
            int legajo = requestEntry.nextInt();

            System.out.print("Ingrese nombre: ");
            String nombre = requestEntry.next();

            System.out.print("Ingrese apellido: ");
            String apellido = requestEntry.next();

            System.out.println("---------------------");

            ListaDeAlumnos.agregarAlumno(legajo, nombre, apellido);
        }

        ListaDeAlumnos.mostrarLista();
        ListaDeAlumnos.ordenarLista();
        ListaDeAlumnos.mostrarLista();
    }
}