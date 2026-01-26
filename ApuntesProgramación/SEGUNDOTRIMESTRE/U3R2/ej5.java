package ApuntesProgramación.SEGUNDOTRIMESTRE.U3R2;

import java.util.ArrayList;
import java.util.Arrays;

public class ej5 {
    public static int detectarPalabrasClave(String textoAnalizado, ArrayList<String> listaPalabrasClave) {
        final String[] palabrasTexto = textoAnalizado.toLowerCase().split(" ");
        int numeroDePalabrasClave = 0;
        for (int i = 0; i < palabrasTexto.length; i++) {
            if (listaPalabrasClave.contains(palabrasTexto[i])) {
                numeroDePalabrasClave++; 
            }
        }

        return numeroDePalabrasClave;
    }

    public static void main(String[] args) {
        ArrayList<String> palabrasClave = new ArrayList<>(Arrays.asList("python", "java", "c++"));
        final String texto = "Me gusta programar en Python y Java";
        int recuentoPalabrasClave = detectarPalabrasClave(texto, palabrasClave);
        System.out.println(recuentoPalabrasClave);

    }
}
