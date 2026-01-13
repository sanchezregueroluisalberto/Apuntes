import java.util.Scanner;

public class pt1 {
    public static void main(String[] args) {
        // creo escaner y declaro variables
        Scanner scanner = new Scanner(System.in);

        int numeroEncargos;
        int stockMadera = 0;
        double stockAcero = 0;
        int encargosTotales = 0;
        String articulo;
        int unidadesAComprar;
        int stockMaderaGastado = 0;
        double stockAceroGastado = 0;
        int stockMaderaAcumulado = 0;
        double stockAceroAcumulado = 0;
        int monedasGastadas;
        int flechasAComprar = 0;
        int espadasAComprar = 0;
        int escudosAComprar = 0;
        int monedasTotal = 0;

        final int PRECIOFLECHA = 2;
        final int PRECIOESCUDO = 30;
        final int PRECIOESPADA = 25;

        System.out.println("¿Cuantos encargos se van a registrar?: ");
        numeroEncargos = scanner.nextInt();
        System.out.print("Stock de madera (en varas): ");
        stockMadera = scanner.nextInt();
        System.out.print("Stock de acero (en kg): ");
        stockAcero = scanner.nextDouble();

        scanner.nextLine();

        while (numeroEncargos - encargosTotales != 0) {
            encargosTotales++;
            System.out.println("--- Encargo " + encargosTotales + " ---");
            System.out.println("Indique el articulo que quiere comprar (flecha, espada, escudo)");
            articulo = scanner.next();
            System.out.println("¿Cuantas unidades de " + articulo + "?");
            unidadesAComprar = scanner.nextInt();
            scanner.nextLine();

            if (articulo.equals("flecha")) {
                stockMaderaGastado = 1 * unidadesAComprar;
                stockAceroGastado = 0.05 * unidadesAComprar;
                monedasGastadas = PRECIOFLECHA * unidadesAComprar;
                flechasAComprar += unidadesAComprar;

            } else if (articulo.equals("espada")) {
                stockMaderaGastado = 1 * unidadesAComprar;
                stockAceroGastado = 1.2 * unidadesAComprar;
                monedasGastadas = PRECIOESPADA * unidadesAComprar;
                espadasAComprar += unidadesAComprar;
            } else {
                stockMaderaGastado = 3 * unidadesAComprar;
                stockAceroGastado = 1.5 * unidadesAComprar;
                monedasGastadas = PRECIOESCUDO * unidadesAComprar;
                escudosAComprar += unidadesAComprar;
            }
            stockMaderaAcumulado += stockMaderaGastado;
            stockAceroAcumulado += stockAceroGastado;
            stockMadera -= stockMaderaGastado;
            stockAcero -= stockAceroGastado;
            monedasTotal += monedasGastadas;
            System.out.println("Artículo: " + articulo + " | Unidades: " + unidadesAComprar +
                    " | Importe cobrado: " + monedasTotal + " monedas");

            System.out.println("Madera gastada: " + stockMaderaGastado + " varas | Acumulada: " + stockMaderaAcumulado);
            System.out.println(
                    "Acero gastado: " + stockAceroGastado + " kg | Acumulada: " + stockAceroAcumulado + " kg");

        }
            System.out.println("=== RESUMEN FINAL===");
            System.out.println("Encargas registrados: " + encargosTotales + " de " + numeroEncargos);
            System.out.println("Unidades ==> Flecha: " + flechasAComprar + " | " + "Escudo: " + escudosAComprar + " | " + "Espada: " + espadasAComprar);
            System.out.println("Consumo total: Madera: " + stockMaderaAcumulado + " varas | Acero: " + stockAceroAcumulado + " kg");
            System.out.println("Stock restante: Madera " + stockMadera + " varas | Acero: " + stockAcero + " kg");
            System.out.println("Importe total: " + monedasTotal + " monedas");
            System.out.println("Registro completado con exito");
    }
}
