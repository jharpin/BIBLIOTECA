package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    private double totalDineroRecaudo;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private Collection<Libro> libros;
    private Collection<Estudiante> estudiantes;

    public Biblioteca(String nombre, double totalDineroRecaudo) {
        this.nombre = nombre;
        this.totalDineroRecaudo = totalDineroRecaudo;
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
        estudiantes = new LinkedList<>();
    }
/*
 *  Metodo para tomar el nombre
 */
    public String getNombre() {
        return nombre;
    }
/*
 * Metodo para modificar el nombre
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
 * Metodo para tomar el TotalDinerorecaudo
 */
    public double getTotalDineroRecaudo() {
        return totalDineroRecaudo;
    }
/*
 * Metodo para modificar el dato TotalDineroRecaudo
 */
    public void setTotalDineroRecaudo(double totalDineroRecaudo) {
        this.totalDineroRecaudo = totalDineroRecaudo;
    }
/*
 * Metodo para tomar la lista de bibliotecarios
 */
    public Collection<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }
/*
 * Metodo para modificar la lista de bibliotecarios
 */
    public void setBibliotecarios(Collection<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }
/*
 * Metodo para tomar la lista de prestamos
 */
    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }
/*
 * Metodo para modificar la lista de prestamos
 */
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Collection<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }

    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", totalDineroRecaudo=" + totalDineroRecaudo + ", bibliotecarios="
                + bibliotecarios + ", prestamos=" + prestamos + ", libros=" + libros + ", estudiantes=" + estudiantes
                + "]";
    }

}
