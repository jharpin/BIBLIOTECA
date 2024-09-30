package co.edu.uniquindio.poo;

public class DetallePrestamo {

    private int cantidad;                // Cantidad de libros prestados
    private Prestamo prestamo;           // Objeto de tipo Prestamo asociado
    private Libro libro;                 // Objeto de tipo Libro prestado
    private double subTotal;              // Subtotal calculado del préstamo
    private double costoPorDia = 2.0;    // Costo por día de préstamo
    private double precio;                // Precio del libro (opcional, según tu lógica)

    // Constructor de la clase DetallePrestamo
    public DetallePrestamo(int cantidad, Prestamo prestamo, Libro libro, double precio) {
        this.cantidad = cantidad;
        this.prestamo = prestamo;
        this.libro = libro;
        this.precio = precio; // Asigna el precio del libro
        this.subTotal = calcularSubtotal(); // Calcula el subtotal al inicializar
    }

    // Método para calcular el subtotal del préstamo
    public double calcularSubtotal() {
        long diasPrestamo = prestamo.calcularDiasPrestamo(); // Obtiene la cantidad de días del préstamo
        return cantidad * diasPrestamo * costoPorDia; // Calcula el subtotal
    }

    // Métodos getters y setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subTotal = calcularSubtotal(); // Recalcula el subtotal al cambiar la cantidad
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
        this.costoPorDia = costoPorDia; // Cambia el costo por día
        this.subTotal = calcularSubtotal(); // Recalcula el subtotal al cambiar el costo
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "DetallePrestamo [cantidad=" + cantidad + ", libro=" + libro + ", subTotal=" + calcularSubtotal() + "]"; // Muestra el subtotal calculado
    }
}
