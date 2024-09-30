package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        /* Crear la biblioteca */
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", 0);

        /* Crear y agregar bibliotecarios */
        Bibliotecario bibliotecario1 = new Bibliotecario("Maria López", "12345678", "maria@mail.com", 123456, 2000, LocalDate.of(2015, 1, 1));
        Bibliotecario bibliotecario2 = new Bibliotecario("Juan Pérez", "87654321", "juan@mail.com", 654321, 2500, LocalDate.of(2018, 5, 10));
        biblioteca.agregarBibliotecario(bibliotecario1);
        biblioteca.agregarBibliotecario(bibliotecario2);

        /* Crear y agregar estudiantes */
        Estudiante estudiante1 = new Estudiante("Carlos Ruiz", "11223344", "carlos@mail.com", 998877, true);
        Estudiante estudiante2 = new Estudiante("Ana García", "55667788", "ana@mail.com", 556677, true);
        biblioteca.agregarEstudiante(estudiante1);
        biblioteca.agregarEstudiante(estudiante2);

        /* Crear y agregar libros */
        Libro libro1 = new Libro("001", "ISBN123", "Cervantes", "Don Quijote", "Editorial1", 30, LocalDate.of(2020, 1, 1));
        Libro libro2 = new Libro("002", "ISBN124", "Tolstoy", "Guerra y Paz", "Editorial2", 15, LocalDate.of(2021, 5, 5));
        Libro libro3 = new Libro("003", "ISBN125", "Shakespeare", "Hamlet", "Editorial3", 20, LocalDate.of(2019, 3, 12));
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        /*metodo para mostrar los libors antes del remplazo  */
        System.out.println("Libros en la biblioteca antes del reemplazo:");
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println(libro.getTitulo());
        }

        /* Reemplazar un libro existente */
        Libro libroNuevo = new Libro("001", "ISBN125", "Cervantes", "El principito", "Editorial1", 25, LocalDate.of(2024, 1, 1));
        biblioteca.reemplazarLibro(libroNuevo);

        // Mostrar libros después del reemplazo
        System.out.println("Libros en la biblioteca después del reemplazo:");
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println(libro.getTitulo());
        }
        
        /*metodo para encontrar la informacion de un libro por su codigo  */
        String codigoBuscar = "001";  
        Libro libroEncontrado = biblioteca.buscarLibroPorCodigo(codigoBuscar);
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado: " + libroEncontrado.getTitulo() + " por " + libroEncontrado.getAutor());
        } else {
            System.out.println("No se encontró ningún libro con el código: " + codigoBuscar);
        }
       /*contador de veces que se a prestado un libro por su titulo */
        String tituloBuscar = "Don Quijote"; 
        int cantidadPrestamos = biblioteca.consultarPrestamosPorTitulo(tituloBuscar);
        System.out.println("El libro '" + tituloBuscar + "' ha sido prestado " + cantidadPrestamos + " veces.");
      

        /* Crear y gestionar préstamos */
        LocalDate fechaPrestamo1 = LocalDate.now(); // Fecha de préstamo actual
        LocalDate fechaEntrega1 = fechaPrestamo1.plusDays(5); // Fecha de entrega 5 días después
        biblioteca.crearPrestamo("P001", fechaPrestamo1, fechaEntrega1, bibliotecario1, estudiante1);
        biblioteca.adicionarLibroPrestamo("P001", libro1, 2); // Añadir 2 unidades de "Don Quijote"
        biblioteca.adicionarLibroPrestamo("P001", libro2, 1); // Añadir 1 unidad de "Guerra y Paz"

        LocalDate fechaPrestamo2 = LocalDate.now(); // Fecha de préstamo actual
        LocalDate fechaEntrega2 = fechaPrestamo2.plusDays(3); // Fecha de entrega 3 días después
        biblioteca.crearPrestamo("P002", fechaPrestamo2, fechaEntrega2, bibliotecario2, estudiante2);
        biblioteca.adicionarLibroPrestamo("P002", libro3, 1); // Añadir 1 unidad de "Hamlet"

        /* Entregar préstamos y calcular el costo */
        System.out.println("\n--- Entregando Préstamos ---");
        entregarPrestamo(biblioteca, "P001", fechaEntrega1); // Entregar según la fecha establecida
        entregarPrestamo(biblioteca, "P002", fechaEntrega2); // Entregar según la fecha establecida

        /* Mostrar reportes */
        mostrarReportes(biblioteca);
    }

    /* Método auxiliar para entregar un préstamo y actualizar el dinero recaudado */
    public static void entregarPrestamo(Biblioteca biblioteca, String codigoPrestamo, LocalDate fechaEntrega) {
        Prestamo prestamo = biblioteca.buscarPrestamoPorCodigo(codigoPrestamo);
        if (prestamo != null) {
            prestamo.setFechaEntrega(fechaEntrega); // Actualizar la fecha de entrega
            double totalPrestamo = prestamo.calcularTotal();
            biblioteca.setTotalDineroRecaudo(biblioteca.getTotalDineroRecaudo() + totalPrestamo);
            System.out.println("Costo del préstamo " + codigoPrestamo + ": " + totalPrestamo);
        } else {
            System.out.println("Préstamo con código " + codigoPrestamo + " no encontrado.");
        }
    }

    /* Método auxiliar para mostrar los reportes solicitados */
    public static void mostrarReportes(Biblioteca biblioteca) {
        System.out.println("\n--- Reportes de la Biblioteca ---");

        /* Reporte: Estudiante con más préstamos */
        Estudiante estudianteConMasPrestamos = biblioteca.obtenerEstudianteConMasPrestamos();
        if (estudianteConMasPrestamos != null) {
            System.out.println("Estudiante con más préstamos: " + estudianteConMasPrestamos.getNombre());
        } else {
            System.out.println("No hay préstamos realizados por estudiantes.");
        }

        /* Reporte: Total de dinero recaudado */
        double totalRecaudado = biblioteca.calcularTotalDineroRecaudado();
        System.out.println("Total de dinero recaudado: " + totalRecaudado);

        /* Reporte: Total a pagar a bibliotecarios */
        double totalAPagarBibliotecarios = biblioteca.calcularTotalAPagarBibliotecarios();
        System.out.println("Total a pagar a los bibliotecarios: " + totalAPagarBibliotecarios);

        /* Reporte: Cantidad de préstamos realizados por cada bibliotecario */
        System.out.println("\n--- Información de los Bibliotecarios ---");
        for (Bibliotecario bibliotecario : biblioteca.getBibliotecarios()) {
            System.out.println("Bibliotecario: " + bibliotecario.getNombre() + ", Préstamos realizados: " + bibliotecario.getPrestamos().size());
        }
    }
}
