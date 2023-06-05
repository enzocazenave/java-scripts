package impl;

import api.ListaAlumnosTDA;

public class ListaAlumnos implements ListaAlumnosTDA {
    private Alumno alumnoOrigen;
    private int cantidadAlumnos;

    public void inicializarLista() {
        this.alumnoOrigen = null;
        this.cantidadAlumnos = 0;
    }

    public void agregarAlumno(int legajo, String nombre, String apellido) {
        if (existeAlumno(legajo)) {
            System.out.println("El alumno ["+legajo+"] ya existe.");
            return;
        }

        alumnoOrigen = new Alumno(legajo, nombre, apellido, alumnoOrigen);
        cantidadAlumnos++;
    }

    public boolean haySiguiente() {
        return alumnoOrigen.siguiente != null;
    }

    public Alumno siguiente() {
        if (!haySiguiente()) return alumnoOrigen;

        Alumno alumnoActual = alumnoOrigen;
        alumnoOrigen = alumnoOrigen.siguiente;
        return alumnoActual;
    }

    public void eliminarAlumno(int legajo) {
        if (cantidadAlumnos() == 0 || !existeAlumno(legajo)) {
            System.out.println("El alumno [" +legajo+"] no existe.");
            return;
        }

        Alumno alumnoAnterior = alumnoOrigen;
        Alumno alumnoActual = alumnoOrigen;

        while (alumnoActual.siguiente != null && alumnoActual.legajo != legajo) {
            alumnoAnterior = alumnoActual;
            alumnoActual = alumnoActual.siguiente;
        }

        alumnoAnterior.siguiente = alumnoActual.siguiente;
    }

    public int cantidadAlumnos() {
        return this.cantidadAlumnos;
    }

    public void mostrarLista() {
        System.out.println("-----------------------");
        Alumno alumnoActual = alumnoOrigen;

        while (alumnoActual != null) {
            System.out.println("["+alumnoActual.legajo+"] " + alumnoActual.nombre + " " + alumnoActual.apellido);
            alumnoActual = alumnoActual.siguiente;
        }
        System.out.println("-----------------------");
    }

    public boolean existeAlumno(int legajo) {
        if (cantidadAlumnos() == 0) return false;
        if (alumnoOrigen.legajo == legajo) return true;

        boolean existe = false;
        Alumno alumnoActual = alumnoOrigen;

        while (alumnoActual != null) {
            if (alumnoActual.legajo == legajo) {
                existe = true;
                break;
            }

            alumnoActual = alumnoActual.siguiente;
        }

        return existe;
    }

    public void ordenarLista() {
        if (cantidadAlumnos() <= 1) return;
    }
}
