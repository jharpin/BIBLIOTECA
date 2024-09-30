package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.LinkedList;

public class Prestamo {

    private String codigo;
    private LocalDate fechaPrestamo, fechaEntrega;
    private double total;
    private Bibliotecario bibliotecario;
    private Estudiante estudiante;
    private Collection<DetallePrestamo> detallePrestamos;

    public Prestamo(String codigo, LocalDate fechaPrestamo, LocalDate fechaEntrega, Bibliotecario bibliotecario,
            Estudiante estudiante) {
        this.codigo = codigo;
        this.fechaEntrega = fechaEntrega;
        this.fechaPrestamo = fechaPrestamo;
        detallePrestamos = new LinkedList<>();
        this.total = calcularTotal();
    }

    /*Método para calcular el total del préstamo*/
    public double calcularTotal() {
        double total = 0;
        for (DetallePrestamo detallePrestamo : detallePrestamos) {
            total += detallePrestamo.calcularSubtotal(); // Sumar el subtotal de cada detalle de préstamo
        }
        return total;
    }

    /*  Método para calcular la cantidad de días del préstamo*/
    public long calcularDiasPrestamo() {
        return ChronoUnit.DAYS.between(fechaPrestamo, fechaEntrega); // Días entre la fecha de préstamo y entrega
    }
    /*Metodo para agregar detalles al prestamo */
    public void agregarDetallePrestamo(DetallePrestamo detalle) {
        detallePrestamos.add(detalle);
        this.total = calcularTotal(); 
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Collection<DetallePrestamo> getDetallePrestamos() {
        return detallePrestamos;
    }

    public void setDetallePrestamos(Collection<DetallePrestamo> detallePrestamos) {
        this.detallePrestamos = detallePrestamos;
    }

    @Override
    public String toString() {
        return "Prestamo [codigo=" + codigo + ", fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega
                + ", total=" + total + ", bibliotecario=" + bibliotecario + ", estudiante=" + estudiante
                + ", detallePrestamos=" + detallePrestamos + "]";
    }

}
