package ApuntesProgramación.SEGUNDOTRIMESTRE.UD2R2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final ArrayList<String> libros = new ArrayList<String>(
                Arrays.asList("El quijote", "La Biblia", "Manual de resistencia", "La criada"));
        final ArrayList<Integer> cantidades = new ArrayList<Integer>(Arrays.asList(5, 3, 1, 7));

        String opcion = "";
        String libroNuevo = "";
        Integer cantidadNuevoLibro = 0;
        String libroActualizado = "";
        Integer cantidadLibroActualizado = 0;
        boolean encontrado = false;
        do {
            System.out.println(
                    " Elije una opcion: \n 1. Añadir un nuevo libro \n 2. Actualizar cantidad \n 3. Ver inventario \n 4. Salir");
            opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                System.out.println("Introduzca el nombre del nuevo libro: ");
                libroNuevo = scanner.nextLine();
                System.out.println("¿Cuantos libros quieres añadir?: ");
                cantidadNuevoLibro = scanner.nextInt();

                libros.add(libroNuevo);
                cantidades.add(cantidadNuevoLibro);

                scanner.nextLine();
            }
            else if (opcion.equals("2")) {
                System.out.println("Nombre del libro a actualizar: ");
                libroActualizado = scanner.nextLine();
                System.out.println("Cantidad nueva a añadir: ");
                cantidadLibroActualizado = scanner.nextInt();

                encontrado = false;

                for (int i = 0; i < libros.size() && !encontrado; i++) {
                    if (libros.get(i).equals(libroActualizado)) {
                        encontrado = true;
                        cantidades.set(i, cantidadLibroActualizado);
                    }
                }
                if (!encontrado) {
                    System.out.println("Libro no encontrado");
                }
            } else if (opcion.equals("3")) {
                System.out.println("Inventario: ");
                for (int i = 0; i < libros.size(); i++) {
                    System.out.println(libros.get(i) + " - " + cantidades.get(i));
                }
            }
        } while (!opcion.equals("4"));
        scanner.close();
    }

}
