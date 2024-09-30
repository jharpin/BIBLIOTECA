package co.edu.uniquindio.poo;

public class DetallePrestamo {

    private int cantidad;             
    private Prestamo prestamo;           
    private Libro libro;               
    private double subTotal;              
    private double costoPorDia = 2.0;   
    private double precio;                

    /* Constructor de la clase DetallePrestamo*/
    public DetallePrestamo(int cantidad, Prestamo prestamo, Libro libro, double precio) {
        this.cantidad = cantidad;
        this.prestamo = prestamo;
        this.libro = libro;
        this.precio = precio; 
        this.subTotal = calcularSubtotal(); 
    }

    /*  Método para calcular el subtotal del préstamo*/
    public double calcularSubtotal() {
        long diasPrestamo = prestamo.calcularDiasPrestamo(); 
        return cantidad * diasPrestamo * costoPorDia; 
    }

    /* Métodos getters y setters*/
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subTotal = calcularSubtotal(); 
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getCostoPorDia() {
        return costoPorDia;
    }

    public void setCostoPorDia(double costoPorDia) {
        this.costoPorDia = costoPorDia;
        this.subTotal = calcularSubtotal(); 
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "DetallePrestamo [cantidad=" + cantidad + ", libro=" + libro + ", subTotal=" + calcularSubtotal() + "]"; 
    }
}
