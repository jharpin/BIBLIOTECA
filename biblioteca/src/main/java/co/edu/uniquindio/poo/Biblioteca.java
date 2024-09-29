package co.edu.uniquindio.poo;
/*
 * Importaciones
 */
import java.util.Collection;
import java.util.LinkedList;
/*
 *  Clase de una biblioteca, Almacena información sobre
 * bibliotecarios, préstamos, libros, estudiantes y el dinero recaudado.
 */  
public class Biblioteca {
    private String nombre;
    private double totalDineroRecaudo;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private Collection<Libro> libros;
    private Collection<Estudiante> estudiantes;
 /*
 *  Metodo constructor de la clase biblioteca 
 */   
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
/*
 * Metodo para tomar la lista de libros
 */
    public Collection<Libro> getLibros() {
        return libros;
    }
/*
 * Metodo para modificar la lista de libros
 */
    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }
/*
 * Metodo para tomar la lista de estudiantes
 */
    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }
/*
 * Metodo para modificar la lista de estudiantes
 */
    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
/*
 * Metodo para representar los datos en forma de cadena de la biblioteca
 */
    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", totalDineroRecaudo=" + totalDineroRecaudo + ", bibliotecarios="
                + bibliotecarios + ", prestamos=" + prestamos + ", libros=" + libros + ", estudiantes=" + estudiantes
                + "]";
    }
/*
 * Metodo para agregar un bibliotecario a la lista de bibliotecarios
 */
    public void agregarBibliotecario (Bibliotecario bibliotecario) {
        bibliotecarios.add(bibliotecario);
    }

/*
 * Metodo para agregar estudiantes a la lista de estudiantes
 */
    public void agregarEstudiante (Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

/*
 * Metodo para agregar libros a la lista de libros
 */
    public void agregarLibro (Libro libro) {
        libros.add(libro);
    }
/*
 * Metodo para crear un prestamo y añadirlo a la lista de prestamos
 */
    public void crearPrestamo (Prestamo prestamo) {
        prestamos.add(prestamo);
    }
/*
 * Metodo para consultar un libro en la lista de libros
 * El libro se busca mediante su CODIGO
 */
    public Libro buscarLibro (String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null;
 // no se si deberia poner un elif para pone un mensaje diciendo que el libro no existe   
    }
/*
 * Metodo para consultar los prestamos que estan involucrados por libro
 */
   
}
