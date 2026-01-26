package ApuntesProgramación.SEGUNDOTRIMESTRE.UD2R2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tareas = new ArrayList<String>(Arrays.asList("tarea1", "tarea2", "tarea3"));
        ArrayList<Boolean> completadas = new ArrayList<Boolean>(Arrays.asList(false, true, false));
        ArrayList<String> pendientes = new ArrayList<>();
        ArrayList<String> hechas = new ArrayList<>();

        int opcion = 0;
        String nuevaTarea = "";
        String buscarTareaenArray = "";
        Boolean tareaEncontrada = false;

        while (opcion != 5) {
            System.out.println(
                    "Elije una opcion: \n1- Añadir tarea \n2- Marcar completada \n3- Ver pendientes \n4- Ver completadas \n5- Salir");
            opcion = scanner.nextInt();
            scanner.nextLine().trim();
            // opcion 1 añadir tarea
            if (opcion == 1) {
                System.out.println("Añade nueva tarea: ");
                nuevaTarea = scanner.nextLine();
                tareas.add(nuevaTarea);
                completadas.add(false);
            }
            // opcion 2 Marcar como completada
            else if (opcion == 2) {
                System.out.println("Tarea a marcar como completada: ");
                buscarTareaenArray = scanner.nextLine();

                for (int i = 0; i < tareas.size(); i++) {
                    if (tareas.get(i).equals(buscarTareaenArray)) {
                        tareaEncontrada = true;
                        completadas.set(i, true);
                    }
                }
            }
            // opcion 3 Ver pendientes
            else if (opcion == 3) {
                for (int i = 0; i < completadas.size(); i++) {
                    if (!completadas.get(i)) {
                        pendientes.add(tareas.get(i));
                    }
                }
                System.out.println("Tareas pendientes: " + pendientes);

            }
            // opcion 4 ver completadas
            else if (opcion == 4) {
                for (int i = 0; i < completadas.size(); i++) {
                    if (completadas.get(i)) {
                        hechas.add(tareas.get(i));
                    }
                }
                System.out.println("Tareas hechas: " + hechas);
            }
        }
        scanner.close();
    }

}
