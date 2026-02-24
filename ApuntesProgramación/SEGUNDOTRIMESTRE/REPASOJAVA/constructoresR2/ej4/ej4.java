package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej4;

import java.util.Scanner;

public class ej4 {
    // funcion de pedir opciones
    public static int pedirOpcion(Scanner escaner) {
        int opcionJuego = 0;
        do {
            try {
                System.out.print(
                        "\n--- MENÚ ---\n1. Añadir cancion\n2. Listar canciones\n3. Mostrar duracion total playlist\n0. Salir\nElige una opción: ");
                opcionJuego = escaner.nextInt();
                escaner.nextLine();
            } catch (Exception e) {
                System.out.println("Algo ha fallado");
                opcionJuego = -1;
                escaner.nextLine();
            }

        } while (opcionJuego < 1 || opcionJuego > 3);

        return opcionJuego;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist miPlaylist = new Playlist();
        Faker faker = new Faker();
        int opcion = -1;
        String titulo = "";
        String artista = "";
        int duracionEnSec = 0;
        for (int i = 0; i < 100; i++) {
            miPlaylist.agregarCanciones(new Canciones(
                    faker.tituloAleatorio(),
                    faker.artistaAleatorio(),
                    faker.duracionAleatoria(120, 500)));
        }
        while (opcion != 0) {
            opcion = pedirOpcion(scanner);
            if (opcion == 1) {
                System.out.println("Añade titulo");
                titulo = scanner.nextLine();
                System.out.println("Añadir artista: ");
                artista = scanner.nextLine();
                System.out.println("¿Cuanto dura?");
                duracionEnSec = scanner.nextInt();
                scanner.nextLine();

                miPlaylist.agregarCanciones(new Canciones(titulo, artista, duracionEnSec));
            } else if (opcion == 2) {
                System.out.println("-- PLAYLIST --");
                System.out.println(miPlaylist.mostrarTodasCanciones());
            } else if (opcion == 3) {
                System.out.println("Sumatorio total de la playlist: " + miPlaylist.sumatorioTotalPlaylist() + " seg");
            }
        }
        scanner.close();
    }
}
