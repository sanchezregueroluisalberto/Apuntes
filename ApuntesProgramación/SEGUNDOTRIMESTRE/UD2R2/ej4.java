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

        Integer opcion = 0;
        String libroNuevo = "";
        Integer cantidadNuevoLibro = 0;
        String libroActualizado = "";
        Integer cantidadLibroActualizado = 0;
        boolean encontrado = false;
        while (!opcion.equals("4")) {
            do {
                try {
                    System.out.println(
                            " Elije una opcion: \n 1. Añadir un nuevo libro \n 2. Actualizar cantidad \n 3. Ver inventario \n 4. Salir");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Algo ha fallado");
                    opcion = -1;
                    scanner.nextLine();
                }

            } while (opcion < 0 && opcion < 4);

            if (opcion == 1) {

                System.out.println("Introduzca el nombre del nuevo libro: ");
                libroNuevo = scanner.nextLine();
                libros.add(libroNuevo);

                do {
                    try {
                        System.out.print("¿Cuantos libros quieres añadir?: ");
                        cantidadNuevoLibro = Integer.parseInt(scanner.nextLine());
                        cantidades.add(cantidadNuevoLibro);

                    } catch (Exception e) {
                        System.out.println("Algo ha fallado");
                        cantidadNuevoLibro = -1;
                    }
                } while (cantidadNuevoLibro < 0);
            } else if (opcion == 2) {
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
            } else if (opcion == 3) {
                System.out.println("Inventario: ");
                for (int i = 0; i < libros.size(); i++) {
                    System.out.println(libros.get(i) + " - " + cantidades.get(i));
                }
            }
        }
        ;

        scanner.close();
    }

}
