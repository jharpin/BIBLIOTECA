package co.edu.uniquindio.poo;
/*
 * Clase Padre Persona, la cual contiene los datos de una persona en general, con esta misma se parte para hacer bibliotecario y estudiante.
 */
public class Persona {

    private String nombre;
    private String cedula;
    private String correo;
    private int telefono;
/*
 * Metodo constructor de la clase persona
 */
    public Persona(String nombre, String cedula, String correo, int telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
    }
/*
 *  Metodo para tomar el nombre
 */
    public String getNombre() {
        return nombre;
    }
/*
 *  Metodo para modificar el nombre
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
 *  Metodo para tomar la cedula
 */
    public String getCedula() {
        return cedula;
    }
/*
 *  Metodo para modificar la cedula
 */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
/*
 *  Metodo para tomar el correo
 */
    public String getCorreo() {
        return correo;
    }
/*
 *  Metodo para modificar el correo
 */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
/*
 *  Metodo para tomar el telefono
 */
    public int getTelefono() {
        return telefono;
    }
/*
 *  Metodo para modificar el telefono
 */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
/*
 * Metodo para representar los datos en forma de cadena de persona
 */
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", telefono=" + telefono
                + "]";
    }

}
