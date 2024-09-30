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
    private int id;

    public Prestamo(String codigo, LocalDate fechaPrestamo, LocalDate fechaEntrega, Bibliotecario bibliotecario,
            Estudiante estudiante, int id) {
        this.codigo = codigo;
        this.fechaEntrega = fechaEntrega;
        this.fechaPrestamo = fechaPrestamo;
        detallePrestamos = new LinkedList<>();
        this.bibliotecario = bibliotecario;
        this.estudiante = estudiante;
        this.id = id;
    }

    /* Método para calcular el total del préstamo */
    public double calcularTotal() {
        double total = 0;
        for (DetallePrestamo detalle : detallePrestamos) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }

    /* Método para calcular la cantidad de días del préstamo */
    public long calcularDiasPrestamo() {
        return ChronoUnit.DAYS.between(fechaPrestamo, fechaEntrega);
    }

    /* Método para agregar detalles al préstamo */
    public void agregarDetallePrestamo(DetallePrestamo detalle) {
        detallePrestamos.add(detalle);
        this.total = calcularTotal(); // Asegura que el total se actualice
    }
    // Getters y setters...
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.total = calcularTotal(); // Recalcula el total antes de mostrarlo
        String detalles = detallePrestamos.isEmpty() ? "No hay detalles de préstamo" : detallePrestamos.toString();
        return "Préstamo [ID=" + id +
               ", Código=" + codigo +
               ", Fecha de Préstamo=" + fechaPrestamo +
               ", Fecha de Entrega=" + fechaEntrega +
               ", Bibliotecario=" + (bibliotecario != null ? bibliotecario.getNombre() : "No asignado") +
               ", Estudiante=" + (estudiante != null ? estudiante.getNombre() : "No asignado") +
               ", Total=" + total +
               ", Detalle de Préstamos=" + detalles + "]";
    }
}

