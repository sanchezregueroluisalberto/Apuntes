package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructores;

public class ej6Constructores {
    public static void main(String[] args) {
        Reloj miReloj = new Reloj(16, 30, 0);
        System.out.println(miReloj);
        miReloj.sumarMinutos(30);
        System.out.println(miReloj);
        miReloj.sumarSegundos(100);
        System.out.println(miReloj);
        miReloj.restarMinutos(120);
        System.out.println(miReloj);

    }

}

class Reloj {
    int hora;
    int minuto;
    int segundo;

    Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public String toString() {
        // hace que haya un 0 delante si por ejemplo hay 1 seg, que sea 01
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    // SUMAS
    void sumarMinutos(int minutos) {
        this.minuto += minutos;
        while (this.minuto >= 60) {
            this.minuto -= 60;
            this.hora++;
        }
    }

    void sumarSegundos(int segundos) {
        this.segundo = segundos;
        while (this.segundo >= 60) {
            this.segundo -= 60;
            this.minuto++;
        }
    }

    // RESTAS
    void restarMinutos(int minutos) {
        this.minuto -= minutos;
        while (this.minuto < 0) {
            this.minuto += 60;
            this.hora--;
        }
    }

    void restarSegundos(int segundos) {
        this.segundo -= segundos;
        while (this.segundo < 0) {
            this.segundo += 60;
            this.minuto--;
        }
    }
}