package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructores;

public class ej4Constructores {
    public static void main(String[] args) {
        Auto micoche = new Auto("Peugeot", "Nuevo", 150.00);
        System.out.println(micoche.velocidadActual);
        micoche.acelerar(25.00);
        System.out.println(micoche.velocidadActual);
        micoche.frenar(50);
        System.out.println(micoche.velocidadActual);
    }

}

class Auto {
    String marca;
    String modelo;
    double velocidadActual;

    Auto(String marca, String modelo, double velocidadActual) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = velocidadActual;
    }

    void acelerar(double cantidad) {
        velocidadActual+= cantidad; 
    }

    void frenar(double cantidad) {
        velocidadActual -= cantidad;
    }
}
