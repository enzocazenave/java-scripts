package impl;

public class Alumno {
    public int legajo;
    public String nombre;
    public String apellido;
    public Alumno siguiente;

    Alumno(int legajo, String nombre, String apellido, Alumno siguiente) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.siguiente = siguiente;
    }
}