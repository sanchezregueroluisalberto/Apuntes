package ApuntesProgramación.SEGUNDOTRIMESTRE;

import java.util.Scanner;
import java.util.ArrayList;

public class pt2 {

    public static ArrayList<Integer> generarTablero(int tamanioTablero, int minimoBombas, int maximoBombas){
        ArrayList<Integer> tablero = new ArrayList<>();
        int cantidadDeBombasAleatorias = (int) ((Math.random() * maximoBombas) + minimoBombas);
        int bombasColocadas = 0;

        for (int i = 0; i < tamanioTablero; i++) {
            tablero.add(0);
        }

        while (bombasColocadas < cantidadDeBombasAleatorias) {
            int indice = (int) (Math.random() * tamanioTablero);
            if (tablero.get(indice) == 0) {
                tablero.set(indice, 1);
                bombasColocadas++;
            }
        }
        return tablero;
    }
    public static void main(String[] args) {
        final String EMOJINODESCUBIERTO = "\uD83D\uDFE9"; // □ tubería cerrada
        final String EMOJITUBERIASEGURA = "\u26AA"; // ○ tubería segura
        final String EMOJITOPOBOMBA = "\uD83D\uDCA3"; // ✖ topo-bomba

        final Integer TUBERIAVACIA = 0;
        final Integer TUBERIATOPOBOMBA = 1;
        final Integer TOTALARRAY = 10;
        final Integer MINIMBOMBAS = 1;
        final Integer MAXIMBOMBAS = 5;

        Integer bombasPuestas = 0;
        Integer posicion = 0;
        Integer tuberiasSeguras = 0;
        Integer eleccion = 0;
        String nombreJugador = "";

        boolean juegoActivo = true;
        boolean turnoMario = true;

        ArrayList<Integer> tableroInterno = generarTablero(TOTALARRAY, MINIMBOMBAS, MAXIMBOMBAS);
        ArrayList<String> tableroExterna = new ArrayList<>();
        for (int i = 0; i < TOTALARRAY; i++) {
            tableroExterna.add(EMOJINODESCUBIERTO);
        }
        for (int i = 0; i < TOTALARRAY; i++) {
            if (tableroInterno.get(i) == TUBERIAVACIA) {
                tuberiasSeguras++;
            }
        }
        
        Scanner Scanner = new Scanner(System.in);
        while (juegoActivo) {
            System.out.println("Tablero: " );
            for (int i = 0; i < TOTALARRAY; i++) {
                System.out.println(tableroExterna.get(i));
            }
            System.out.println();

            if (turnoMario) {
                nombreJugador = "Mario";
            } else {
                nombreJugador = "Luigi";
            }
            System.out.println(nombreJugador + "Elije una tuberia (0-9): ");
            try {
                eleccion = Scanner.nextInt();

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
                Scanner.next(); // IMPORTANTE: Limpia la entrada incorrecta del scanner
            }
        }
        Scanner.close();
    }
}


//no se hacerla joder ni con chat gpt ni nada y los emojis no van vete y te pelas