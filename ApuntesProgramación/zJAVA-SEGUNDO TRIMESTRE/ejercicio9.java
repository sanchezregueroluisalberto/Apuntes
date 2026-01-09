import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuantos caramelos tienes?:");
        int caramelos = scanner.nextInt();

        System.out.print("¿Cuantos niños hay?:");
        int niños = scanner.nextInt();

        scanner.nextLine();

        int restoDeCaramelos = caramelos / niños;

        System.out.println("Hay " + caramelos + " caramelos para " + niños + " niños, y han sobrado " + restoDeCaramelos + " caramelos");
        scanner.close();
    }
}
