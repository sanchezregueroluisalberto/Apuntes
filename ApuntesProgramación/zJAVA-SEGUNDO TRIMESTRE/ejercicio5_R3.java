import java.util.Scanner;

public class ejercicio5_R3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca un numero: ");
        int numero = scanner.nextInt();

        int minimo = 10;
        int maximo = 20;

        if (numero >= minimo && numero <= maximo) {
            System.out.println("El numero está dentro del rango");
        }
        else {
            System.out.println("El numero no está dentro del rango");
        }
        scanner.close();
    }
}
