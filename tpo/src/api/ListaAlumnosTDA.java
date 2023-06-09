package api;

import impl.Alumno;

public interface ListaAlumnosTDA {
    void inicializarLista();
    void agregarAlumno(int legajo, String nombre, String apellido);
    boolean haySiguiente();
    Alumno siguiente();
    void eliminarAlumno(int legajo);
    int cantidadAlumnos();
    boolean existeAlumno(int legajo);
    void ordenarLista();
}
