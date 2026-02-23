package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej4;
import java.util.ArrayList;
import java.util.Scanner;
public class ej4 {
    // funcion de pedir opciones
    public static int pedirOpcion(Scanner escaner) {
        int opcionJuego = 0;
        do {
            try {
                System.out.print(
                        "\n--- MENÚ ---\n1. Añadir cancion\n2. Listar canciones\n3. Mostrar duracion total playlist\n4. Eliminar revisión\n0. Salir\nElige una opción: ");
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist miPlaylist = new Playlist();
        int opcion = -1;
        while (opcion != 0) {
            if (opcion == 1) {
                System.out.println("Añade titulo");
                
            }
        }
    }
}
