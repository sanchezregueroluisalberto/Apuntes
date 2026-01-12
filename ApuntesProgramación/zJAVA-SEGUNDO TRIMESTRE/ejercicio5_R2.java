
import java.util.Scanner;

public class ejercicio5_R2 {
    public static void main(String[] args){
        //Crear objeto scanner
        Scanner scanner = new Scanner(System.in);
        //pido el peso
        System.out.print("Introduzca su peso: ");
        double pesoUsuario = scanner.nextDouble();
        scanner.close();
        //calculo peso en la luna
        double pesoLuna = (pesoUsuario * 0.165);
        System.out.println("Tu peso en la luna seria: " + pesoLuna + " kg");
    }
}
