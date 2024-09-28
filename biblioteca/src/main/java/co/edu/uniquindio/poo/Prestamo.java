package co.edu.uniquindio.poo;
/*
 * Importaciones
 */
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
/*
 * Clase representa el prestamo tomado por un estudiante en la biblioteca.
 */
public class Prestamo {

    private String codigo;
    private LocalDate fechaPrestamo, fechaEntrega;
    private double total;
    private Bibliotecario bibliotecario;
    private Estudiante estudiante;
    private Collection<DetallePrestamo> detallePrestamos;
/*
 * Metodo Constructor de la clase Prestamo
 */
    public Prestamo(String codigo, LocalDate fechaPrestamo, LocalDate fechaEntrega, Bibliotecario bibliotecario,
            Estudiante estudiante) {
        this.codigo = codigo;
        this.fechaEntrega = fechaEntrega;
        this.fechaPrestamo = fechaPrestamo;
        detallePrestamos = new LinkedList<>();
        this.total = calcularTotal();
    }
/*
 * Metodo para calcular el total del prestamo 
 */
    public double calcularTotal() {
        double total = 0;
        for (DetallePrestamo detallePrestamo : detallePrestamos) {
            total += detallePrestamo.getSubTotal();
        }
        return total;
    }
/*
 * Metodo para tomar el codigo 
 */
    public String getCodigo() {
        return codigo;
    }
/*
 * Metodo para modificar el codigo 
 */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
/*
 * Metodo para tomar la Fecha del prestamo
 */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
/*
 * Metodo para modificar la fecha del prestamo
 */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
/*
 * Metodo para tomar la fecha de entrega
 */
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }
/*
 * Metodo para modificar la fecha de entrega
 */
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
/*
 * Metodo para tomar el total del prestamo
 */
    public double getTotal() {
        return total;
    }
/*
 * Metodo para modificar el total del prestamo
 */
    public void setTotal(double total) {
        this.total = total;
    }
/*
 * Metodo para tomar el bibliotecario que asigno el prestamo al estudiante
 */
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
/*
 * Metodo para modificar el bibliotecario que asigno el prestamo al estudiante
 */
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
/*
 * Metodo para tomar al estudiante del prestamo
 */
    public Estudiante getEstudiante() {
        return estudiante;
    }
/*
 * Metodo para modificar el estudiante del prestamo
 */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
/*
 * Metodo para tomar la lista de los prestamos 
 */
    public Collection<DetallePrestamo> getDetallePrestamos() {
        return detallePrestamos;
    }
/*
 * Metodo para modificar los prestamos 
 */
    public void setDetallePrestamos(Collection<DetallePrestamo> detallePrestamos) {
        this.detallePrestamos = detallePrestamos;
    }
/*
 * Metodo para representar los datos de prestamo en forma de cadena
 */
    @Override
    public String toString() {
        return "Prestamo [codigo=" + codigo + ", fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega
                + ", total=" + total + ", bibliotecario=" + bibliotecario + ", estudiante=" + estudiante
                + ", detallePrestamos=" + detallePrestamos + "]";
    }

}
