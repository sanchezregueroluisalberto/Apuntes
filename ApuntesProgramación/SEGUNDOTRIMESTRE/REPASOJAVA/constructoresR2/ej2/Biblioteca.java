package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej2;

import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> librosBiblioteca;

    Biblioteca() {
        this.librosBiblioteca = new ArrayList<>();
    }

    public void agregarLibros(Libro libro) {
        librosBiblioteca.add(libro);

    }

    public void prestarLibro(String titulo) {
        for (Libro libro : librosBiblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                if (libro.isDisponible()) {
                    libro.setDisponible(false);
                    System.out.println("El libro '" + titulo + "' ha sido prestado");

                } else {
                    System.out.println("Lo siento, el libro '" + titulo + "' no está disponible para prestar");
                }
            }
        }
    }

    public void devolverLibro(String titulo) {
        for (Libro libro : librosBiblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                libro.setDisponible(true);
                System.out.println("Has devuelto: " + titulo);
            }
        }
    }

    public String mostrarTodosLibros() {
        String lista = "";
        for (Libro libro : librosBiblioteca) {
            lista += libro.getTitulo() + "\n";
        }
        return lista;
    }
}