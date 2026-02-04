package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA;

import java.util.ArrayList;
import java.util.Scanner;

public class ej2 {
    // funcion de pedir opciones
    public static int pedirOpcion(Scanner escaner) {
        int opcionJuego = 0;
        do {
            try {
                System.out.print(
                        "\n--- MENÚ TALLER ---\n1. Añadir revisión\n2. Listar revisiones\n3. Mostrar coste (por índice)\n4. Eliminar revisión\n0. Salir\nElige una opción: ");
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

    // añado revision, opcion 1
    public static void añadirRevision(ArrayList<String> listaMatricula, ArrayList<String> listaTipos,
            ArrayList<Integer> listaExtras, ArrayList<Double> listaCostes, Scanner escaner) {
        String matricula = "";
        String tipo = "";
        int extrasNumero = 0;
        double precioBase = 60.00;
        double costeFinal = 0.00;
        int ultimoNumero = 0;
        char ultimoChar = ' ';
        try {
            System.out.println("Introduzca una matricula: ");
            matricula = escaner.nextLine();

            tipo = "";
            while (!tipo.equals("basica") && !tipo.equals("completa")) {
                System.out.println("Elige tipo de revision (basica o completa): ");
                tipo = escaner.nextLine().toLowerCase();
            }

            do {
                System.out.println("Dime el numero de extras: ");
                extrasNumero = escaner.nextInt();
                escaner.nextLine();
            } while (extrasNumero < 0);

            // Cálculo de precio base con if tradicional
            if (tipo.equals("basica")) {
                precioBase = 60.00;
            } else {
                precioBase = 120.00;
            }

            costeFinal = precioBase + (extrasNumero * 15);

            // Lógica de descuento por matrícula par
            if (matricula.length() > 0) {
                ultimoChar = matricula.charAt(matricula.length() - 1);
                if (ultimoChar >= '0' && ultimoChar <= '9') {
                    ultimoNumero = ultimoChar - '0';
                    if (ultimoNumero % 2 == 0) {
                        costeFinal = costeFinal * 0.90;
                    }
                }
            }

            listaMatricula.add(matricula);
            listaTipos.add(tipo);
            listaExtras.add(extrasNumero);
            listaCostes.add(costeFinal);
            System.out.println("Revisión guardada con éxito.");

        } catch (Exception e) {
            System.out.println("Error al introducir los datos.");
            escaner.nextLine();
        }
    }

    // opcion2, listo revisiones
    public static void listarRevisiones(ArrayList<String> listaMatricula, ArrayList<String> listaTipos,
            ArrayList<Double> listaCostes) {
        if (listaMatricula.isEmpty()) {
            System.out.println("Vacio");
        } else {
            for (int i = 0; i < listaMatricula.size(); i++) {
                System.out.println(i + " -> " + listaMatricula.get(i) + " | " + listaTipos.get(i) + " | Coste: "
                        + listaCostes.get(i) + " euros");
            }
        }

    }

    // opcion3 muestro coste y si hay descuento o no
    public static void mostrarCosteConDetalles(ArrayList<String> listaMatricula,
            ArrayList<Double> listaCostes, Scanner escaner) {

        String matricula = "";
        int indice = 0;
        int ultimoNumero = 0;
        char ultimoChar = ' ';

        System.out.println("Introduce indice: ");
        indice = escaner.nextInt();
        escaner.nextLine();
        if (indice >= 0 && indice < listaCostes.get(indice)) {
            System.out.println("Coste del tractor con indice " + indice + ": " + listaCostes.get(indice));
            matricula = listaMatricula.get(indice);
            ultimoChar = matricula.charAt(matricula.length() - 1);
            if (ultimoChar >= '0' && ultimoChar <= '9') {
                ultimoNumero = ultimoChar - '0';
                if (ultimoNumero % 2 == 0) {
                    System.out.println("Se aplico el descuento del 10% porque la matricula termina en par: "
                            + ultimoNumero);
                } else {
                    System.out.println("Matricula sin descuento porque es impar");
                }
            } else {
                System.out.println("Sin descuento porque no termina en numero");
            }
        } else {
            System.out.println("Error, indice fuera del rango");
        }
    }
    //opcion4 elimino matricula y toda la info por indice
    public static void eliminarMatricula(ArrayList<String> listaMatricula, ArrayList<String> listaTipos,
            ArrayList<Integer> listaExtras, ArrayList<Double> listaCostes, Scanner escaner) {
        int indice = 0;
        System.out.println("Introduce indice: ");
        indice = escaner.nextInt();
        escaner.nextLine();
        if (indice >= 0 && indice < listaMatricula.size()) {
            listaMatricula.remove(indice);
            listaTipos.remove(indice);
            listaExtras.remove(indice);
            listaCostes.remove(indice);
            System.out.println("Eliminado de todos lados la matricula con indice " + indice);
        } else {
            System.out.println("Indice no valido");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> matriculas = new ArrayList<>();
        ArrayList<String> tipos = new ArrayList<>();
        ArrayList<Integer> extras = new ArrayList<>();
        ArrayList<Double> costes = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) {
            // opciones
            opcion = pedirOpcion(scanner);
            if (opcion == 1) {
                añadirRevision(matriculas, tipos, extras, costes, scanner);
            } else if (opcion == 2) {
                listarRevisiones(matriculas, tipos, costes);
            } else if (opcion == 3) {
                mostrarCosteConDetalles(matriculas, costes, scanner);
            } else if (opcion == 4) {
                eliminarMatricula(matriculas, tipos, extras, costes, scanner);
            }
        }
        scanner.close();
    }
}
// asi esta muy bien, solo falta añadir mas try catch pero perfect, ya le he pillado el truco a las funciones