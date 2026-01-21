package ApuntesProgramación.SEGUNDOTRIMESTRE;

import java.util.Scanner;

public class ejercicio9_R3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un numero de dos cifras: ");
        int numeroDosCifras = scanner.nextInt();

        int cifra1 = (numeroDosCifras / 10);
        int cifra2 = (numeroDosCifras - (cifra1 * 10));
        int sumaCifras = cifra1 + cifra2;
        scanner.nextLine();
        scanner.close();

        System.out.print("La suma de la dos cifras es; " + sumaCifras);
    }
}
