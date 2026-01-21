package ApuntesProgramación.SEGUNDOTRIMESTRE;

import java.util.Scanner;

public class ejercicio8_R0 {
    public static double mayor(double a, double b) {
        double numeroMayor = a;
        if (b > a) {
            numeroMayor = b;
        }
        return numeroMayor;

    }

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        double primerNumero = 0;
        double segundoNumero = 0;
        boolean valido = false;
        
        
        while (!valido) {
            try {
                System.out.println("Introduzca un numero:");
                primerNumero = scanner1.nextDouble();
                scanner1.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.print("ERROR. Introduzca un numero: ");
                scanner1.nextLine();
            }
        }
        valido = false;
        while (!valido) {
            try {
                System.out.println("Introduzca otro numero:");
                segundoNumero = scanner1.nextDouble();
                scanner1.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.print("ERROR. Introduzca otro numero: ");
                scanner1.nextLine();
            }
            
        }
        scanner1.close();
        double mayorque = mayor(primerNumero, segundoNumero);
        System.out.println("Es mayor el " + mayorque);
    }
}
