import impl.ListaAlumnos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaAlumnos ListaDeAlumnos = new ListaAlumnos();
        ListaDeAlumnos.inicializarLista();

        Scanner requestEntry = new Scanner(System.in);

        System.out.println("Cuantos alumnos desea ingresar en la lista?");
        int cantidadDeAlumnos = requestEntry.nextInt();
        int ui = cantidadDeAlumnos + 1;
        System.out.println("---------------------");

        while (cantidadDeAlumnos != 0) {
            System.out.println("Alumno ["+(ui - cantidadDeAlumnos)+"]");

            System.out.print("Ingrese numero de legajo: ");
            int legajo = requestEntry.nextInt();

            System.out.print("Ingrese nombre: ");
            String nombre = requestEntry.next();

            System.out.print("Ingrese apellido: ");
            String apellido = requestEntry.next();

            System.out.println("---------------------");
            
            if (!ListaDeAlumnos.existeAlumno(legajo)) {
                ListaDeAlumnos.agregarAlumno(legajo, nombre, apellido);
                cantidadDeAlumnos--;
                continue;
            }

            System.out.println("El alumno con legajo " + legajo + " ya existe, vuelva a ingresar los datos.");
        }

        System.out.println("LISTA DE ALUMNOS DESORDENADA");
        ListaDeAlumnos.mostrarLista();
        ListaDeAlumnos.ordenarLista();
        System.out.println("LISTA DE ALUMNOS ORDENADA");
        ListaDeAlumnos.mostrarLista();
    }
}