package ApuntesProgramación.UD2REL1;

import java.util.ArrayList;

public class ej15 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        System.out.println("El array antes de eliminar nada es de: " + numeros);
        for (int i = numeros.size(); i > 0; i--) {
            numeros.remove(numeros.size() - 1);
            System.out.println(numeros);

        }

    }
}
