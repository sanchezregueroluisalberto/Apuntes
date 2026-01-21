package ApuntesProgramación.SEGUNDOTRIMESTRE;

import java.util.Scanner;
import java.util.ArrayList;

public class pt2 {
    public static void main(String[] args) {
        final String EMOJINODESCUBIERTO = "\u25A1"; // □ tubería cerrada
        final String EMOJITUBERIASEGURA = "\u25CB"; // ○ tubería segura
        final String EMOJITOPOBOMBA = "\u2716"; // ✖ topo-bomba

        final Integer TUBERIAVACIA = 0;
        final Integer TUBERIATOPOBOMBA = 1;
        final Integer TOTALARRAY = 10;

        Integer bombasPuestas = 0;
        Integer BOMBASALEATORIAS = (int) ((Math.random() * 5) + 1);
        Integer posicion = 0;
        Integer tuberiasSeguras = 0;
        Integer eleccion = 0;
        String nombreJugador = "";

        boolean juegoActivo = true;
        boolean turnoMario = true;

        ArrayList<Integer> tableroInterno = new ArrayList<>();
        ArrayList<String> tableroExterna = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < TOTALARRAY; i++) {
            tableroInterno.add(TUBERIAVACIA);
            tableroExterna.add(EMOJINODESCUBIERTO);
        }

        while (bombasPuestas < BOMBASALEATORIAS) {
            posicion = (int) (Math.random() * TOTALARRAY);

            if (tableroInterno.get(posicion).equals(TUBERIAVACIA)) {
                tableroInterno.set(posicion, TUBERIATOPOBOMBA);
                bombasPuestas++;
            }
        }
        tuberiasSeguras = TOTALARRAY - bombasPuestas;

        while (juegoActivo) {
            System.out.println("Tablero: " + tableroExterna);

            if (turnoMario) {
                nombreJugador = "Mario";
            } else {
                nombreJugador = "Luigi";
            }
            System.out.println(nombreJugador + "Elije una tuberia (0-9): ");
            try {
                eleccion = scanner.nextInt();

                // Validación de índice y estado
                if (eleccion >= 0 && eleccion < TOTALARRAY && tableroExterna.get(eleccion).equals(EMOJINODESCUBIERTO)) {

                    if (tableroInterno.get(eleccion).equals(TUBERIATOPOBOMBA)) {
                        tableroExterna.set(eleccion, EMOJITOPOBOMBA);
                        System.out.println(tableroExterna);
                        System.out.println("¡BOOM! " + nombreJugador + " ha perdido.");
                        juegoActivo = false;
                    } else {
                        tableroExterna.set(eleccion, EMOJITUBERIASEGURA);
                        tuberiasSeguras--;
                        System.out.println("Tubería segura.");

                        if (tuberiasSeguras == 0) {
                            System.out.println(tableroExterna);
                            System.out.println("¡Victoria! Han despejado el Reino Champiñón.");
                            juegoActivo = false;
                        } else {
                            // Cambio de turno
                            if (turnoMario) {
                                turnoMario = false;
                            } else {
                                turnoMario = true;
                            }
                        }
                    }
                } else {
                    System.out.println("Índice no válido o ya descubierto.");
                }

            } catch (Exception e) {
                // Captura el error si el usuario escribe letras
                System.out.println("Error, Debes introducir un número entero");
                scanner.next(); // IMPORTANTE: Limpia la entrada incorrecta del scanner
            }
        }
        scanner.close();
    }
}
