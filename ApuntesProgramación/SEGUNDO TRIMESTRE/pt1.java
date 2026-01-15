import java.util.Scanner;

public class pt1 {
    public static void main(String[] args) {
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
        boolean stockDisponible = true;

        final int PRECIOFLECHA = 2;
        final int PRECIOESCUDO = 30;
        final int PRECIOESPADA = 25;

        System.out.print("Número de encargos: ");
        numeroEncargos = scanner.nextInt();
        System.out.print("Stock de madera (varas): ");
        stockMadera = scanner.nextInt();
        System.out.print("Stock de acero (kg): ");
        stockAcero = scanner.nextDouble();

        scanner.nextLine();

        // Usamos una variable auxiliar para el título del encargo
        int intentoEncargo = 1;

        while (encargosTotales < numeroEncargos && stockDisponible) {
            System.out.println("--- Encargo " + intentoEncargo + " ---");
            System.out.println("Artículo: ");
            articulo = scanner.next();
            System.out.println("Unidades: ");
            unidadesAComprar = scanner.nextInt();
            scanner.nextLine();

            // Calculamos el gasto, pero NO sumamos a los totales todavía
            if (articulo.equals("flecha")) {
                stockMaderaGastado = 1 * unidadesAComprar;
                stockAceroGastado = 0.05 * unidadesAComprar;
                monedasGastadas = PRECIOFLECHA * unidadesAComprar;
            } else if (articulo.equals("espada")) {
                stockMaderaGastado = 1 * unidadesAComprar;
                stockAceroGastado = 1.2 * unidadesAComprar;
                monedasGastadas = PRECIOESPADA * unidadesAComprar;
            } else {
                stockMaderaGastado = 3 * unidadesAComprar;
                stockAceroGastado = 1.5 * unidadesAComprar;
                monedasGastadas = PRECIOESCUDO * unidadesAComprar;
            }

            // Comprobamos stock comparando con el stock inicial fijo
            if (stockMaderaAcumulado + stockMaderaGastado > stockMadera
                    || stockAceroAcumulado + stockAceroGastado > stockAcero) {
                System.out.println("[Se calcula el consumo y se detecta que el stock superaría el disponible]");
                System.out.println("(ALERTA)");
                System.out.println("¡Alerta! Has superado el stock.");
                stockDisponible = false;
            } else {
                // actualizamos las variables reales
                encargosTotales++;
                stockMaderaAcumulado += stockMaderaGastado;
                stockAceroAcumulado += stockAceroGastado;
                monedasTotal += monedasGastadas;

                // Ahora sí sumamos al tipo de artículo
                if (articulo.equals("flecha"))
                    flechasAComprar += unidadesAComprar;
                else if (articulo.equals("espada"))
                    espadasAComprar += unidadesAComprar;
                else
                    escudosAComprar += unidadesAComprar;

                System.out.println("Artículo: " + articulo + " | Unidades: " + unidadesAComprar +
                        " | Importe cobrado: " + monedasGastadas);
                System.out.println(
                        "Madera gastada: " + stockMaderaGastado + " varas | Acumulada: " + stockMaderaAcumulado);
                System.out.println(
                        "Acero gastado: " + stockAceroGastado + " kg | Acumulada: " + stockAceroAcumulado + " kg");

                intentoEncargo++; // Solo pasamos al siguiente número de encargo si este salio bien
            }
        }

        System.out.println("=== RESUMEN FINAL ===");
        System.out.println("Encargos registrados: " + encargosTotales + " de " + numeroEncargos);
        System.out.println("Unidades → Flecha: " + flechasAComprar + " | Escudo: " + escudosAComprar + " | Espada: "
                + espadasAComprar);
        System.out.println(
                "Consumo total → Madera: " + stockMaderaAcumulado + " varas | Acero: " + stockAceroAcumulado + " kg");
        System.out.println("Stock restante → Madera: " + (stockMadera - stockMaderaAcumulado) + " varas | Acero: "
                + (stockAcero - stockAceroAcumulado) + " kg");
        System.out.println("Importe total: " + monedasTotal);

        if (!stockDisponible) {
            System.out.println("Registro interrumpido por superación de stock.");
        }
        scanner.close();
    }
}