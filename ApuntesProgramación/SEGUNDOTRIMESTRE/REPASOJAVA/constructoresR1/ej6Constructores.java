package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR1;

public class ej6Constructores {
    public static void main(String[] args) {
        Reloj miReloj = new Reloj(6, 30, 0);
        System.out.println(miReloj);
        miReloj.sumarMinutos(30);
        System.out.println(miReloj);
        miReloj.sumarSegundos(100);
        System.out.println(miReloj);
        miReloj.restarMinutos(1);
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
        String horaReloj = (hora < 10) ? "0" + hora : "" + hora;
        String minutoReloj = (minuto < 10) ? "0" + minuto : "" + minuto;
        String segundoReloj = (segundo < 10) ? "0" + segundo : "" + segundo;

        return horaReloj + ":" + minutoReloj + ":" + segundoReloj;
    }

    // SUMAS
    void sumarMinutos(int cantidad) {
        int minutosFinal = minuto + cantidad;
        while (minutosFinal >= 60) {
            minutosFinal -= 60;

            if (hora + 1 == 24) {
                hora = 0;
            } else {
                hora++;
            }
        }
        minuto = minutosFinal;
    }

    void sumarSegundos(int cantidad) {
        int segundoFinal = segundo + cantidad;
        while (segundoFinal >= 60) {
            segundoFinal -= 60;
            sumarMinutos(1);
        }
        segundo = segundoFinal;
    }

    // RESTAS
    void restarMinutos(int cantidad) {
        int minutosFinal = minuto - cantidad;
        while (minutosFinal < 0) {
            this.hora--;
            minutosFinal += 60;

            if (hora < 0) {
                hora = 23;
            } else {
                hora--;
            }
        }
        minuto = minutosFinal;
    }

    void restarSegundos(int cantidad) {
        int segundosFinal = segundo - cantidad;
        while (segundosFinal < 0) {
            segundosFinal += 60;
            restarMinutos(1);
        }
        segundo = segundosFinal;
    }
}