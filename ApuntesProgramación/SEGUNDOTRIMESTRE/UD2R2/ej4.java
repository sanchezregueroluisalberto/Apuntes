package ApuntesProgramación.SEGUNDOTRIMESTRE.UD2R2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej4 {

    // funcion de pedir opciones
    public static int pedirOpcion(Scanner escaner) {
        int opcionJuego = 0;
        do {
            try {
                System.out.println(
                        " Elije una opcion: \n 1. Añadir un nuevo libro \n 2. Actualizar cantidad \n 3. Ver inventario \n 4. Salir");
                opcionJuego = escaner.nextInt();
                escaner.nextLine();
            } catch (Exception e) {
                System.out.println("Algo ha fallado");
                opcionJuego = -1;
                escaner.nextLine();
            }

        } while (opcionJuego < 1 || opcionJuego > 4);

        return opcionJuego;
    }

    // opcion añadir libro
    public static void añadirLibro(ArrayList<String> listaLibros, ArrayList<Integer> listaCantidades,
            Scanner escaner) {

        String nuevoLibro = "";
        int cantidadLibroNuevo = 0;

        System.out.print("Introduzca el nombre del nuevo libro: ");
        nuevoLibro = escaner.nextLine();

        do {
            try {
                System.out.print("¿Cuantos libros quieres añadir?: ");
                cantidadLibroNuevo = Integer.parseInt(escaner.nextLine());
            } catch (Exception e) {
                System.out.println("Algo ha fallado");
                cantidadLibroNuevo = -1;
            }
        } while (cantidadLibroNuevo < 0);

        listaLibros.add(nuevoLibro);
        listaCantidades.add(cantidadLibroNuevo);
    }

    // opcion actualizar cantidades de libro
    public static void actualizarCantidades(ArrayList<String> listaLibros, ArrayList<Integer> listaCantidades, Scanner escaner) {
        String actualizarLibro = "";
        int actualizarCantLibro = 0;
        boolean encontrado = false;

        System.out.println("Nombre del libro a actualizar: ");
        actualizarLibro = escaner.nextLine();
        do {
            try {
                System.out.println("Cantidad nueva a añadir: ");
                actualizarCantLibro = Integer.parseInt(escaner.nextLine());

            } catch (Exception e) {
                System.out.println("Algo ha fallado");
                actualizarCantLibro = -1;
            }
            encontrado = false;
            for (int i = 0; i < listaLibros.size() && !encontrado; i++) {
                if (listaLibros.get(i).equals(actualizarLibro)) {
                    encontrado = true;
                    listaCantidades.set(i, actualizarCantLibro);
                }
            }
            if (!encontrado) {
                System.out.println("Libro no encontrado");
            }

        } while (actualizarCantLibro < 0);
    }

    // funcion de enseñar inventario
    public static void enseñoInventario(ArrayList<String> listaLibros, ArrayList<Integer> listaCantidades) {
        System.out.println("Inventario: ");

        for (int i = 0; i < listaLibros.size(); i++) {
            System.out.println(listaLibros.get(i) + " - " + listaCantidades.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> libros = new ArrayList<String>(
                Arrays.asList("El quijote", "La Biblia", "Manual de resistencia", "La criada"));
        ArrayList<Integer> cantidades = new ArrayList<Integer>(Arrays.asList(5, 3, 1, 7));

        int opcion = 0;
        String libroNuevo = "";
        int cantidadNuevoLibro = 0;
        String libroActualizado = "";
        int cantidadLibroActualizado = 0;
        while (opcion != 4) {
            opcion = pedirOpcion(scanner);
            // OPCION 1
            if (opcion == 1) {
                añadirLibro(libros, cantidades, scanner);
            } else if (opcion == 2) {
                actualizarCantidades(libros, cantidades, scanner);
            } else if (opcion == 3) {
                enseñoInventario(libros, cantidades);
            }
        }
        

        scanner.close();
    }

}
