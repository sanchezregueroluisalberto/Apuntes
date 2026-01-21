package ApuntesProgramación.SEGUNDOTRIMESTRE;

import java.util.Scanner;

public class ejercicio19_R0 {

public static String capitalizarPrimeraLetra(String palabra) {
    // declaramos vacia la palabra capitalizada
    String palabraCapitalizada = "";
    //bucle para ver si es la primera letra o no 
    for (int i = 0; i < palabra.length(); i++) {
        char letra = palabra.charAt(i);
        // si es la primera letra la capitalizamos si no no
        if (i == 0) {
            palabraCapitalizada += Character.toUpperCase(letra);
        } else{
            palabraCapitalizada += letra;
        }
    }
    return palabraCapitalizada;
}
// MAIN--------------------------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // pedimos una palabra
        System.out.print("Introduzca una palabra: ");

        String palabra = scanner.nextLine();
        // enunciamos la función
        String palabraParaCapitalizar = capitalizarPrimeraLetra(palabra);
        // devolvemos la palabra capitalizada
        System.out.println("La palabra capitalizada es: " + palabraParaCapitalizar);
        scanner.close();
    }
}
