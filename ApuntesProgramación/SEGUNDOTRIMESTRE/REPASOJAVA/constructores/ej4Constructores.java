package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructores;

public class ej4Constructores {
    public static void main(String[] args) {
     auto micoche = new auto("Peugeot", "Nuevo", 150.00); 
     System.out.println(micoche.velocidadActual);
     micoche.acelerar(25.00);
     System.out.println(micoche.velocidadActual);
     micoche.frenar(50);
    }

}

class auto {
    String marca = "";
    String modelo = "";
    double velocidadActual = 0.00;

    auto(String marca,String modelo,double velocidadActual){
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = velocidadActual;
    }
    void acelerar(double cantidad){
        cantidad += velocidadActual;
        System.out.println("Tranquiiilo que estas acelerando " + cantidad + ", estas a " + velocidadActual + "km/h");
    }

    void frenar(double cantidad){
        cantidad -= velocidadActual;
        System.out.println("Menos mal que estas frenando " + cantidad + ", estas a " + velocidadActual + "km/h");
    }
}
