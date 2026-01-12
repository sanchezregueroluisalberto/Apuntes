import java.util.Scanner;

public class ejercicio7_R3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca un numero: ");
        int numero1 = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Introduzca otro numero: ");
        int numero2 = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Introduzca la operacion que quieras hacer: ");
        String operacion = scanner.nextLine();

        double resultado = 0.0;

        if (operacion.equals("+")) {
            resultado = numero1 + numero2;
            System.out.println("Resultado: " + resultado);
        } else if (operacion.equals("-")) {
            resultado = numero1 - numero2;
            System.out.println("Resultado: " + resultado);
        } else if (operacion.equals("*")) {
            resultado = numero1 * numero2;
            System.out.println("Resultado: " + resultado);
        } else if (operacion.equals("/")) {
            resultado = numero1 / numero2;
            System.out.println("Resultado: " + resultado);
        } else {

            System.out.println("Operación no válida");
        }

        scanner.close();
    }
}
