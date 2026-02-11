package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructores;

public class ej7Constructores {
    public static void main(String[] args) {
        Lampara miLampara = new Lampara(false);
        System.out.println(miLampara);
    }
}
class Lampara{
    boolean encendido;

    Lampara(boolean estado){
        this.encendido = encendido;
    }
    public boolean encender(boolean encendido){
        encendido = true;
        return encender(encendido);
    }
    public boolean apagar (boolean encendido){
        encendido = false;
        return apagar(encendido);
    }
}
// faltan cosas