package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR1;

public class ej8Constructores {
    public static void main(String[] args) {
        Televisor miTele = new Televisor("Netflix", 10);
        System.out.println(miTele);
        miTele.cambiarCanal("Prime Video");
        miTele.subirVolumen(10);
        System.out.println(miTele);
    }

}

class Televisor {
    String canalActual;
    int volumen;

    Televisor(String canalActual, int volumen) {
        this.canalActual = canalActual;
        this.volumen = volumen;
    }

    public String toString() {
        return "Estas viendo " + canalActual + " a " + volumen + " de volumen";
    }

    void subirVolumen(int volumen) {
        this.volumen += volumen;

    }

    void restarVolumen(int volumen) {
        if (this.volumen > 0) {

            this.volumen -= volumen;
        }

    }

    void cambiarCanal(String nuevoCanal) {
        this.canalActual = nuevoCanal;
    }
}
