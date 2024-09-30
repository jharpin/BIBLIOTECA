package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.LinkedList;

public class Bibliotecario extends Persona {

    private double salario;
    private LocalDate fechaIngreso;
    private Collection<Prestamo> prestamos;

    public Bibliotecario(String nombre, String cedula, String correo, int telefono, double salario, LocalDate fechaIngreso){
        super(nombre, cedula, correo, telefono);
        this.salario=salario;
        this.fechaIngreso=fechaIngreso;
        prestamos = new LinkedList<>();
    }
    /*Metodo para calcular el salario */
    public double calcularSalario() {
        double totalComision = 0;
        for (Prestamo prestamo : prestamos) {
            totalComision += prestamo.getTotal() * 0.2; // 20% de comisión por cada préstamo
        }
    /*  Bonificación de 2% por cada año de antigüedad*/
    int aniosAntiguedad = (int) ChronoUnit.YEARS.between(fechaIngreso, LocalDate.now());
        double bonificacion = totalComision * 0.02 * aniosAntiguedad;
        return salario + totalComision + bonificacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Bibliotecario [salario=" + salario + ", fechaIngreso=" + fechaIngreso + ", prestamos=" + prestamos
                + "]";
    }

    

    
    
}
