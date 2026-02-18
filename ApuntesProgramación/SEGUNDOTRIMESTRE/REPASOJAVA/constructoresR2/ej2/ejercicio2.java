package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();
        // Faker faker = new Faker(); // Si tus métodos son static, esta línea no es
        // necesaria
        Scanner scanner = new Scanner(System.in);

        // 1. Llenamos la biblioteca (100 libros)
        for (int i = 1; i <= 100; i++) {
            String titulo = Faker.tituloLibro();
            String autor = Faker.nombreCompleto();
            String sinopsis = Faker.sinopsisLibro();

            miBiblioteca.agregarLibros(new Libro(i, titulo, autor, sinopsis, true));
        }

        // 2. El menú DEBE estar dentro del main
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- MI BIBLIOTECA ---");
            System.out.println("1. Lista de libros");
            System.out.println("2. Pedir prestado");
            System.out.println("3. Devolver");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 1) {
                System.out.println(miBiblioteca.mostrarTodosLibros());
            } else if (opcion == 2) {
                System.out.print("Título del libro: ");
                miBiblioteca.prestarLibro(scanner.nextLine());
            } else if (opcion == 3) {
                System.out.print("Título del libro: ");
                miBiblioteca.devolverLibro(scanner.nextLine());
            } else if (opcion == 0) {
                System.out.println("Programa finalizado.");
            }

        }
        scanner.close();
    }
}