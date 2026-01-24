package ApuntesProgramación.SEGUNDOTRIMESTRE.UD2R2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej4 {
    static Scanner scanner = new Scanner(System.in);

    // funcion de pedir opciones
    public static Integer pedirOpcion() {
        Integer opcionJuego = 0;
        do {
            try {
                System.out.println(
                        " Elije una opcion: \n 1. Añadir un nuevo libro \n 2. Actualizar cantidad \n 3. Ver inventario \n 4. Salir");
                opcionJuego = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Algo ha fallado");
                opcionJuego = -1;
                scanner.nextLine();
            }

        } while (opcionJuego < 1 || opcionJuego > 4);

        return opcionJuego;
    }

    // opcion añadir libro
    public static String añadirLibro(ArrayList<String> librosFuncion, ArrayList<Integer> cantidadesFuncion) {

        String nuevoLibro = "";
        int cantidadLibroNuevo = 0;

        System.out.print("Introduzca el nombre del nuevo libro: ");
        nuevoLibro = scanner.nextLine();

        do {
            try {
                System.out.print("¿Cuantos libros quieres añadir?: ");
                cantidadLibroNuevo = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Algo ha fallado");
                cantidadLibroNuevo = -1;
            }
        } while (cantidadLibroNuevo < 0);

        librosFuncion.add(nuevoLibro);
        cantidadesFuncion.add(cantidadLibroNuevo);
        return nuevoLibro;
    }

    // opcion actualizar cantidades de libro
    public static void actualizarCantidades(ArrayList<String> listaNombres, ArrayList<Integer> listaStock) {
        String actualizarLibro = "";
        Integer actualizarCantLibro = 0;
        boolean encontrado = false;

        System.out.println("Nombre del libro a actualizar: ");
        actualizarLibro = scanner.nextLine();
        do {
            try {
                System.out.println("Cantidad nueva a añadir: ");
                actualizarCantLibro = Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                System.out.println("Algo ha fallado");
                actualizarCantLibro = -1;
            }
            encontrado = false;
            for (int i = 0; i < listaNombres.size() && !encontrado; i++) {
                if (listaNombres.get(i).equals(actualizarLibro)) {
                    encontrado = true;
                    listaStock.set(i, actualizarCantLibro);
                }
            }
            if (!encontrado) {
                System.out.println("Libro no encontrado");
            }

        } while (actualizarCantLibro < 0);
    }

    // funcion de enseñar inventario
    public static void enseñoInventario(ArrayList<String> nombreArrayList, ArrayList<Integer> cantidArrayList) {
        System.out.println("Inventario: ");

        for (int i = 0; i < nombreArrayList.size(); i++) {
            System.out.println(nombreArrayList.get(i) + " - " + cantidArrayList.get(i));
        }
    }

    public static void main(String[] args) {
        final ArrayList<String> libros = new ArrayList<String>(
                Arrays.asList("El quijote", "La Biblia", "Manual de resistencia", "La criada"));
        final ArrayList<Integer> cantidades = new ArrayList<Integer>(Arrays.asList(5, 3, 1, 7));

        Integer opcion = 0;
        String añadoLibro = "";
        String libroNuevo = "";
        Integer cantidadNuevoLibro = 0;
        String libroActualizado = "";
        Integer cantidadLibroActualizado = 0;
        while (!opcion.equals(4)) {
            opcion = pedirOpcion();
            // OPCION 1
            if (opcion == 1) {
                añadoLibro = añadirLibro(libros, cantidades);
            } else if (opcion == 2) {
                actualizarCantidades(libros, cantidades);
            } else if (opcion == 3) {
                enseñoInventario(libros, cantidades);
            }
        };
        scanner.close();
    }

}
