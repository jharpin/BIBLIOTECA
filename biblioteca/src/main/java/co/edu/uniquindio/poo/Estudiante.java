package co.edu.uniquindio.poo;
/*
 * Importaciones
 */
import java.util.Collection;
import java.util.LinkedList;
/*
 * Clase estudiante que toma libros de la biblioteca por medio de prestamos
 */
public class Estudiante extends Persona {

    private boolean estado;
    private Collection<Prestamo> prestamos;
/*
 * Metodo contructor para la clase estudiannte 
 */
    public Estudiante(String nombre, String cedula, String correo, int telefono, boolean estado) {
        super(nombre, cedula, correo, telefono);
        this.estado = estado;
        prestamos = new LinkedList<>();
    }
/*
 *  Metodo para tomar el estado del estudiante 
 */
    public boolean isEstado() {
        return estado;
    }
/*
 *  Metodo para modificar el estado del estudiante 
 */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
/*
 *  Metodo para tomar la lista de prestamos
 */
    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }
/*
 *  Metodo para modificar la lista de prestamos
 */
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
/*
 * Metodo para representar los datos en forma de cadena de estudiante
 */
    @Override
    public String toString() {
        return "Estudiante [estado=" + estado + ", prestamos=" + prestamos + "]";
    }

}
