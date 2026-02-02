package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA;

import java.util.ArrayList;
import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> matriculas = new ArrayList<>();
        ArrayList<String> tipos = new ArrayList<>();
        ArrayList<Integer> extras = new ArrayList<>();
        ArrayList<Double> costes = new ArrayList<>();

        int opcion = -1;
        String matricula = "";
        String tipo = "";
        int extrasNumero = 0;
        double precioBase = 60.00;
        double costeFinal = 0.00;
        int ultimoNumero = 0;
        char ultimoChar = ' ';
        int indice = 0;

        while (opcion != 0) {
            System.out.print(
                    "\n--- MENÚ TALLER ---\n1. Añadir revisión\n2. Listar revisiones\n3. Mostrar coste (por índice)\n4. Eliminar revisión\n0. Salir\nElige una opción: ");
    
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("Introduzca una matricula: ");
                matricula = scanner.nextLine();

                tipo = "";
                while (!tipo.equals("basica") && !tipo.equals("completa")) {
                    System.out.println("Elige tipo de revision(basica o completa): ");
                    tipo = scanner.nextLine().toLowerCase();
                }
                do {
                    System.out.println("Dime el numero de extras: ");
                    extrasNumero = scanner.nextInt();
                    scanner.nextLine();
                } while (extrasNumero < 0);
                if (tipo.equals("basica")) {
                    precioBase = 60.00;
                } else {
                    precioBase = 120.00;
                }
                costeFinal = precioBase + (extrasNumero * 15);
                // --- DESCUENTO ---
                if (matricula.length() > 0) {

                    ultimoChar = matricula.charAt(matricula.length() - 1);

                    // Comprobamos si el carácter está entre '0' y '9'
                    if (ultimoChar >= '0' && ultimoChar <= '9') {
                        // Convertimos el char a int restando el valor de '0'
                        ultimoNumero = ultimoChar - '0';
                        if (ultimoNumero % 2 == 0) {
                            costeFinal = costeFinal * 0.90; // Descuento 10%
                        }
                    }
                }
                matriculas.add(matricula);
                tipos.add(tipo);
                extras.add(extrasNumero);
                costes.add(costeFinal);

            } else if (opcion == 2) {
                if (matriculas.isEmpty()) {
                    System.out.println("Vacio");

                } else {
                    for (int i = 0; i < matriculas.size(); i++) {
                        System.out.println(
                                (i + 1) + " -> " + matriculas.get(i) + " | " + tipos.get(i) + " | Coste: " + costes.get(i)
                                        + "euros");
                    }
                }
            }
            else if(opcion == 3){
                System.out.println("Introduce indice: ");
                indice = scanner.nextInt();
                scanner.nextLine();
                
            }

        }
    }
}
