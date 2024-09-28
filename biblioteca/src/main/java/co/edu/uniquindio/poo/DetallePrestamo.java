package co.edu.uniquindio.poo;
/**
 * Clase que representa el detalle de un préstamo en una biblioteca.
 * Almacena la cantidad de libros prestados, el préstamo asociado.
 * representa el subtotal del prestamo.
 */
public class DetallePrestamo {

    private int cantidad;
    private Prestamo prestamo;
    private Libro libro;
    private double subTotal;
/*
 * Constructor de la clase DetallePrestamo
 */
    public DetallePrestamo(int cantidad, Prestamo prestamo, Libro libro){
        this.cantidad=cantidad;
        this.prestamo=prestamo;
        this.libro=libro;
        //this.subTotal=calcularSubtotal();
    }

    /*public double calcularSubtotal(){
        return cantidad*libro.get
    }*/
/*
 * Metodo para tomar la cantidad de libros
 */
    public int getCantidad() {
        return cantidad;
    }
/*
 * Metodo para modificar la cantidad de libros
 */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
/*
 * Metodo para tomar el prestamo
 */
    public Prestamo getPrestamo() {
        return prestamo;
    }
/*
 * Metodo para modificar el prestamo
 */
    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
/*
 * Metodo para tomar el libro
 */    
    public Libro getLibro() {
        return libro;
    }
/*
 * Metodo para modificar el libro
 */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
/*
 * Metodo para tomar el Subtotal
 */
    public double getSubTotal() {
        return subTotal;
    }
/*
 * Metodo para modificar el subtotal
 */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
/*
 * Metodo para representar los datos de DetallePrestamo en forma de cadena
 */
    @Override
    public String toString() {
        return "DetallePrestamo [cantidad=" + cantidad + ", prestamo=" + prestamo + ", libro=" + libro + ", subTotal="
                + subTotal + "]";
    }

    
    
}
