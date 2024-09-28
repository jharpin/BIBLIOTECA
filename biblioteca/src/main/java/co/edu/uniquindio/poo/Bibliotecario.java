package co.edu.uniquindio.poo;
/*
 * importaciones
 */
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
/*
 * Clase Bibliotecario, aporta los datos de la persona designada como bibliotecario
 */
public class Bibliotecario extends Persona {

    private double salario;
    private LocalDate fechaIngreso;
    private Collection<Prestamo> prestamos;
/*
 * Metodo Constructor de la clase Bibliotecario
 */
    public Bibliotecario(String nombre, String cedula, String correo, int telefono, double salario, LocalDate fechaIngreso){
        super(nombre, cedula, correo, telefono);
        this.salario=salario;
        this.fechaIngreso=fechaIngreso;
        prestamos = new LinkedList<>();
    }
/*
 * Metodo para tomar salario
 */
    public double getSalario() {
        return salario;
    }
/*
 * Metodo para modificar el salario
 */
    public void setSalario(double salario) {
        this.salario = salario;
    }
/*
 * Metodo para tomar la fecha de ingreso
 */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
/*
 * Metodo para modificar la Fecha de ingreso
 */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
 * Metodo para representar los datos de Bibliotecario en forma de cadena
 */
    @Override
    public String toString() {
        return "Bibliotecario [salario=" + salario + ", fechaIngreso=" + fechaIngreso + ", prestamos=" + prestamos
                + "]";
    }

    

    
    
}
