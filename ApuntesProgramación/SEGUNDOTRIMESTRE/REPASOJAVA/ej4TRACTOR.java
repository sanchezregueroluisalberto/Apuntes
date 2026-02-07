package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej4TRACTOR {
    // funcion de pedir opciones
    public static int pedirOpcion(Scanner escaner) {
        int opcionJuego = 0;
        do {
            try {
                System.out.print(
                        "\n--- MENÚ TALLER ---\n1. Añadir ruta\n2. Listar rutas\n3. Calcular consumo (por índice)\n4. Eliminar ruta\n0. Salir\nElige una opción: ");
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

    // funcion opcion 1
    public static void añadirRuta(ArrayList<String> listaTractores, ArrayList<Double> listaKM,
            ArrayList<Double> listaLitrosDisponibles, ArrayList<String> listaTiposTerreno, Scanner escaner) {
        String tractorNombre = "";
        double kmTractor = 0.00;
        double litrosTractor = 0.00;
        String tipo = "";
        try {
            System.out.println("Introduce el nombre del tractor: ");
            tractorNombre = escaner.nextLine();

            do {
                System.out.println("¿Cuantos km tiene la ruta con su tractor?: ");
                kmTractor = escaner.nextDouble();
                escaner.nextLine();

            } while (kmTractor <= 0.00);

            do {
                System.out.println("¿Cuantos litros disponibles tiene su tractor?: ");
                litrosTractor = escaner.nextDouble();
                escaner.nextLine();

            } while (litrosTractor <= 0.00);

            tipo = "";
            do {
                System.out.println("Elige tipo de terreno (llano, mixto o montania): ");
                tipo = escaner.nextLine().toLowerCase();
            } while (!tipo.equals("llano") && !tipo.equals("mixto") && !tipo.equals("montania"));

            listaTractores.add(tractorNombre);
            listaKM.add(kmTractor);
            listaLitrosDisponibles.add(litrosTractor);
            listaTiposTerreno.add(tipo);

        } catch (Exception e) {
            System.out.println("Ha habido un problema al introducir los datos");
            escaner.nextLine();

        }
    }

    // funcion opcion 2
    public static void listarRutas(ArrayList<String> listaTractores, ArrayList<Double> listaKM,
            ArrayList<Double> listaLitrosDisponibles, ArrayList<String> listaTiposTerreno) {
        if (listaTractores.isEmpty()) {
            System.out.println("Vacio");
        } else {
            for (int i = 0; i < listaTractores.size(); i++) {
                System.out.println(i + " --> " + listaTractores.get(i) + " | " + listaKM.get(i) + " | "
                        + listaLitrosDisponibles.get(i) + " | " + listaTiposTerreno.get(i));
            }
        }
    }

    // funcion opcion 3
    public static void calcularConsumo(ArrayList<String> listaTractores, ArrayList<Double> listaKM,
            ArrayList<Double> listaLitrosDisponibles, ArrayList<String> listaTiposTerreno, Scanner escaner) {
        int indice = 0;
        double consumo = 0.00;
        double litrosNecesarios = 0.00;
        boolean viable = false;
        double consumoFinalSiNoViable = 0.00;
        try {
            System.out.println("Introduce el indice de la ruta: ");
            indice = escaner.nextInt();
            escaner.nextLine();
            if (indice >= 0 && indice < listaTractores.size()) {
                if (listaTiposTerreno.equals("llano")) {
                    litrosNecesarios = 0.12;
                } else if (listaTiposTerreno.equals("mixto")) {
                    litrosNecesarios = 0.18;
                } else {
                    litrosNecesarios = 0.25;
                }
                consumo = listaKM.get(indice) * litrosNecesarios;

                if (consumo > listaLitrosDisponibles.get(indice)) {
                    viable = false;
                    consumoFinalSiNoViable = consumo - listaLitrosDisponibles.get(indice);
                    System.out.println("El tractor " + listaTractores.get(indice)
                            + " le faltan estos litros para ser viable: " + consumoFinalSiNoViable + " L");
                } else {
                    viable = true;
                    System.out.println("VIABLE");
                }
            } else {
                System.out.println("Indice invalido");
            }
        } catch (Exception e) {
            System.out.println("Error al introducir los datos");
            escaner.nextLine();
        }
    }

    // funcion opcion 4
    public static void eliminarRutas(ArrayList<String> listaTractores, ArrayList<Double> listaKM,
            ArrayList<Double> listaLitrosDisponibles, ArrayList<String> listaTiposTerreno, Scanner escaner) {
        int indice = 0;
        try {
            System.out.println("Introduce el indice de la ruta: ");
            indice = escaner.nextInt();
            escaner.nextLine();
            if (indice >= 0 && indice < listaTractores.size()) {
                listaTractores.remove(indice);
                listaKM.remove(indice);
                listaLitrosDisponibles.remove(indice);
                listaTiposTerreno.remove(indice);
                System.out.println("Has eliminado la ruta con indice " + indice + " de todas las listas");
            } else {
                System.out.println("Indice inválido");
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error al introducir los datos");
            escaner.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tractor = new ArrayList<>();
        ArrayList<Double> kilometros = new ArrayList<>();
        ArrayList<Double> litrosDisponibles = new ArrayList<>();
        ArrayList<String> tipoTerreno = new ArrayList<String>(Arrays.asList("llano", "mixto", "montania"));

        int opcion = -1;

        while (opcion != 0) {
            opcion = pedirOpcion(scanner);
            // opcion 1
            if (opcion == 1) {
                añadirRuta(tractor, kilometros, litrosDisponibles, tipoTerreno, scanner);
            }
            // opcion2
            else if (opcion == 2) {
                listarRutas(tractor, kilometros, litrosDisponibles, tipoTerreno);
            }
            // opcion 3
            else if (opcion == 3) {
                calcularConsumo(tractor, kilometros, litrosDisponibles, tipoTerreno, scanner);
            }
            // opcion 4
            else if (opcion == 4) {
                eliminarRutas(tractor, kilometros, litrosDisponibles, tipoTerreno, scanner);
            }
        }
    }
}
