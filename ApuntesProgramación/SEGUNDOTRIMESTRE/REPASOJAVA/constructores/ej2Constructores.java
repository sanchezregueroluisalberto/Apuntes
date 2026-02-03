package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructores;

public class ej2Constructores {
    public static void main(String[] args) {
        cuentaBancaria miCuenta = new cuentaBancaria("Alex", 40.00);
        miCuenta.depositarCantidad(45.00);
        miCuenta.retirarCantidad(100.00); // este no funcionaria

    }
}

class cuentaBancaria {
    String titular = "";
    double saldo = 0.00;

    cuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;

    }

    void depositarCantidad(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            System.out.println("Has añadido: " + cantidad + ", tu saldo ahora es de " + saldo);
        } else {
            System.out.println("Error, la cantidad no puede ser negativa");
        }
    }

    void retirarCantidad(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("Error, no puedes retirar mas dinero del que tienes");
        } else {
            this.saldo -= cantidad;
            System.out.println("Has eliminado: " + cantidad + ", tu saldo ahora es de " + saldo);
        }
    }

}
