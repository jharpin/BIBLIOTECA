package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    private double totalDineroRecaudo;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private Collection<Libro> libros;
    private Collection<Estudiante> estudiantes;

    public Biblioteca(String nombre, double totalDineroRecaudo) {
        this.nombre = nombre;
        this.totalDineroRecaudo = totalDineroRecaudo;
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
        estudiantes = new LinkedList<>();
    }
    /*  Método para agregar un bibliotecario*/
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        bibliotecarios.add(bibliotecario);
        System.out.println("Bibliotecario agregado exitosamente: " + bibliotecario.getNombre());
    }

    /*  Método para agregar un estudiante*/
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        System.out.println("Estudiante agregado exitosamente: " + estudiante.getNombre());
    }

    /* Metodo para consultar datos de un bibliotecario dado su cédula*/
    public Bibliotecario consultarBibliotecario(String cedula) {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                return bibliotecario;
            }
        }
        System.out.println("No se encontró un bibliotecario con la cédula: " + cedula);
        return null;
    }

    /* Metodo para consultar datos de un estudiante dado su cédula*/
    public Estudiante consultarEstudiante(String cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        System.out.println("No se encontró un estudiante con la cédula: " + cedula);
        return null;
    }

    public void agregarLibro(Libro libro) {
        if (buscarLibroPorCodigo(libro.getCodigo()) == null) {
            libros.add(libro);
            System.out.println("Libro agregado exitosamente: " + libro.getTitulo());
        } else {
            System.out.println("El libro con código " + libro.getCodigo() + " ya existe.");
        }
    }

    /* Método para buscar un libro por su código*/
    public Libro buscarLibroPorCodigo(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null;
    }

    /*  Método para consultar préstamos de un libro por su título*/
    public int consultarPrestamosPorTitulo(String titulo) {
        int contador = 0;
        for (Prestamo prestamo : prestamos) {
            for (DetallePrestamo detalle : prestamo.getDetallePrestamos()) {
                if (detalle.getLibro().getTitulo().equals(titulo)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    /*  Método para reemplazar un libro por otro*/
    public void reemplazarLibro(Libro libroNuevo) {
        Libro libroExistente = buscarLibroPorCodigo(libroNuevo.getCodigo());
        if (libroExistente != null) {
            libros.remove(libroExistente);
            libros.add(libroNuevo);
            System.out.println("Libro reemplazado exitosamente: " + libroNuevo.getTitulo());
        } else {
            System.out.println("El libro con código " + libroNuevo.getCodigo() + " no existe.");
        }
    }

       /*  Método para crear un préstamo*/
    public void crearPrestamo(String codigo, LocalDate fechaPrestamo, LocalDate fechaEntrega, Bibliotecario bibliotecario, Estudiante estudiante,int id) {
        Prestamo prestamo = new Prestamo(codigo, fechaPrestamo, fechaEntrega, bibliotecario, estudiante,id);
        prestamos.add(prestamo);
        bibliotecario.getPrestamos().add(prestamo);
        estudiante.getPrestamos().add(prestamo);
        System.out.println("Préstamo creado exitosamente: " + prestamo);
    }

    /*  Método para adicionar un libro al préstamo*/
    public void adicionarLibroPrestamo(String codigoPrestamo, Libro libro, int cantidad, double costoPorDia) {
        Prestamo prestamo = buscarPrestamoPorCodigo(codigoPrestamo);
        if (prestamo != null) {
            DetallePrestamo detalle = new DetallePrestamo(cantidad, prestamo, libro, costoPorDia);
            prestamo.agregarDetallePrestamo(detalle);
            libro.prestar(cantidad);
        } else {
            System.out.println("Préstamo no encontrado con el código: " + codigoPrestamo);
        }
    }
            
        
    
    
    /*  Método para buscar un préstamo por su código*/
    public Prestamo buscarPrestamoPorCodigo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                return prestamo;
            }
        }
        return null;
    }

       /*  Método para obtener el estudiante con más préstamos*/
       public Estudiante obtenerEstudianteConMasPrestamos() {
        Estudiante estudianteConMasPrestamos = null;
        int maxPrestamos = 0;
        for (Estudiante estudiante : estudiantes) {
            int prestamos = estudiante.getPrestamos().size();
            if (prestamos > maxPrestamos) {
                maxPrestamos = prestamos;
                estudianteConMasPrestamos = estudiante;
            }
        }
        return estudianteConMasPrestamos;
    }

    /* Método para calcular el total de dinero recaudado*/
    public double calcularTotalDineroRecaudado() {
        double total = 0;
        for (Prestamo prestamo : prestamos) {
            total += prestamo.getTotal();
        }
        return total;
    }

    /*  Método para calcular el total a pagar a los bibliotecarios*/
    public double calcularTotalAPagarBibliotecarios() {
        double total = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            double comision = 0.2 * calcularTotalPrestamosBibliotecario(bibliotecario);
            double bonificacion = 0.02 * comision * calcularAntiguedad(bibliotecario);
            total += (comision + bonificacion);
        }
        return total;
    }

    /*  Método para calcular el total de préstamos realizados por un bibliotecario*/
    public double calcularTotalPrestamosBibliotecario(Bibliotecario bibliotecario) {
        double total = 0;
        for (Prestamo prestamo : bibliotecario.getPrestamos()) {
            total += prestamo.getTotal();
        }
        return total;
    }
/*
 * Metodo para contar los libros restantes
 */
public String contarLibrosRestantes() {
    StringBuilder report = new StringBuilder("Libros restantes en la biblioteca:\n");

    for (Libro libro : libros) {
        report.append(libro.getTitulo()).append(": ").append(libro.getUnidadesDisponibles()).append("\n");
    }

    return report.toString();
}

    /*  Método para calcular la antigüedad de un bibliotecario en años*/
    public int calcularAntiguedad(Bibliotecario bibliotecario) {
        return LocalDate.now().getYear() - bibliotecario.getFechaIngreso().getYear();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotalDineroRecaudo() {
        return totalDineroRecaudo;
    }

    public void setTotalDineroRecaudo(double totalDineroRecaudo) {
        this.totalDineroRecaudo = totalDineroRecaudo;
    }

    public Collection<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(Collection<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Collection<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }

    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", totalDineroRecaudo=" + totalDineroRecaudo + ", bibliotecarios="
                + bibliotecarios + ", prestamos=" + prestamos + ", libros=" + libros + ", estudiantes=" + estudiantes
                + "]";
    }

}