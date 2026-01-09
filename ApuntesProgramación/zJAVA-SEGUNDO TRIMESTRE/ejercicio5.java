import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca su peso: ");
        double pesoUsuario = scanner.nextDouble();

        double pesoLuna = (pesoUsuario * 0.165);
        System.out.println("Tu peso en la luna seria: " + pesoLuna + " kg");
        scanner.close();
    }
}
