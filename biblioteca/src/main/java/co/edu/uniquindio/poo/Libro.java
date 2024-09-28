package co.edu.uniquindio.poo;
/*
 *Importaciones
 */
import java.time.LocalDate;

public class Libro {

    private String codigo, isbn, autor, titulo, editorial;
    private int unidadesDisponibles;
    private LocalDate fechaPublicacion;
    private boolean estado;

    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, int unidadesDisponibles, LocalDate fechaPublicacion){
        this.codigo=codigo;
        this.isbn=isbn;
        this.autor=autor;
        this.editorial=editorial;
        this.titulo=titulo;
        this.unidadesDisponibles=unidadesDisponibles;
        this.fechaPublicacion=fechaPublicacion;
    }
/*
 *  Metodo para tomar el codigo
 */
    public String getCodigo() {
        return codigo;
    }
/*
 *  Metodo para modificar el codigo
 */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
/*
 *  Metodo para tomar el Isbn
 */
    public String getIsbn() {
        return isbn;
    }
/*
 *  Metodo para modificar el Isbn
 */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
/*
 *  Metodo para tomar el autor
 */
    public String getAutor() {
        return autor;
    }
/*
 *  Metodo para modificar el autor
 */
    public void setAutor(String autor) {
        this.autor = autor;
    }
/*
 *  Metodo para tomar el titulo
 */
    public String getTitulo() {
        return titulo;
    }
/*
 *  Metodo para modificar el titulo
 */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
/*
 *  Metodo para tomar la editorial
 */
    public String getEditorial() {
        return editorial;
    }
/*
 *  Metodo para modificar la editorial
 */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
/*
 *  Metodo para tomar las unidades disponibles
 */
    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }
/*
 *  Metodo para modificar las unidades disponibles
 */
    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }
/*
 *  Metodo para tomar la fecha de publicacion
 */
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
/*
 *  Metodo para modificar la fecha de publicacion
 */
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
/*
 *  Metodo para tomar el estado del libro
 */
    public boolean isEstado() {
        return estado;
    }
/*
 *  Metodo para modificar el estado del libro
 */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
/*
 * Metodo para representar los datos en forma de cadena de libro
 */
    @Override
    public String toString() {
        return "Libro [codigo=" + codigo + ", isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", editorial="
                + editorial + ", unidadesDisponibles=" + unidadesDisponibles + ", fechaPublicacion=" + fechaPublicacion
                + ", estado=" + estado + "]";
    }

    
    
}
