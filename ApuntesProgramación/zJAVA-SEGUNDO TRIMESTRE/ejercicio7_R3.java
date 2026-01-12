import java.util.Scanner;

public class ejercicio7_R3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca un numero: ");
        int numero1 = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Introduzca otro numero: ");
        int numero2 = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Introduzca la operacion que quieras hacer: ");
        char operacion = scanner.next().charAt(0);

        double resultado;

        if (operacion == '+') {
            resultado = numero1 + numero2;
            System.out.println("Resultado: " + resultado);
        } else if (operacion == '-') {
            resultado = numero1 - numero2;
            System.out.println("Resultado: " + resultado);
        } else if (operacion == '*') {
            resultado = numero1 * numero2;
            System.out.println("Resultado: " + resultado);
        } else if (operacion == '/') {
            resultado = numero1 / numero2;
            System.out.println("Resultado: " + resultado);
        } else {

            System.out.println("Operación no válida");
        }

        scanner.close();
    }
}
