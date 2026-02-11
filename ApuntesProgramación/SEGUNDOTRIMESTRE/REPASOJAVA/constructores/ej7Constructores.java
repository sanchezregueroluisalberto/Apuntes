package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructores;

public class ej7Constructores {
    public static void main(String[] args) {
        Lampara miLampara = new Lampara(false);
        System.out.println(miLampara); // apagada
        miLampara.encender();
        System.out.println(miLampara); // encendida

        
    }
}

class Lampara {
    boolean encendido;

    Lampara(boolean encendido) {
        this.encendido = encendido;
    }
    public String toString(){
        return "La lampara está " + (encendido ? "encendida" : "apagada");
    }
    public void encender() {
        this.encendido = true;
    }

    public void apagar() {
        this.encendido = false;
    }
}
// faltan cosas