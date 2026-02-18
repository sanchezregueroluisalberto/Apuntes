package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej3;

import java.util.Scanner;

/**
 * Esta es la clase principal que controla el supermercado.
 * 
 * <p>
 * Se encarga de mostrar el menu y de usar
 * las funciones de la clase Supermercado
 * </p>
 * 
 * @author Guillermo Jimenez
 * @see Supermercado
 * @see Producto
 */
public class Ejercicio3 {

    /**
     * Sirve para mostrar un texto por la pantalla.
     * 
     * @param mensajeOpcion El texto que queremos que el usuario lea.
     */
    public static void mostrarMensaje(String mensajeOpcion) {
        System.out.println(mensajeOpcion);
    }

    /**
     * Pide un numero y comprueba que este entre un minimo y un maximo.
     * 
     * <p>
     * Usa la herramienta Scanner para leer lo que escribes. Si te pasas
     * de los limites o no pones un numero, te avisa del error.
     * </p>
     *
     * @param mensaje   El texto que pide el numero.
     * @param min       El numero mas pequeño que puedes poner.
     * @param max       El numero mas grande que puedes poner.
     * @param scanner_1 La herramienta para leer el teclado.
     * @return El numero que el usuario ha escrito.
     * @throws NumberFormatException Salta si lo que escribes no es un numero.
     */
    public static int pedirNumero(String mensaje, int min, int max, Scanner scanner_1) {
        int numero = -1;
        boolean valido = false;

        do {
            System.out.println(mensaje);
            String entrada = scanner_1.nextLine();

            if (entrada.trim().isEmpty()) {
                System.out.println("Error: No puede estar vacio.");
            } else {
                try {
                    numero = Integer.parseInt(entrada);

                    if (numero < min || numero > max) {
                        System.out.println("Error: Introduce un numero entre " + min + " y " + max);
                    } else {
                        valido = true;
                    }
                } catch (Exception e) {
                    System.out.println("Error: Introduce solo numeros.");
                }
            }
        } while (!valido);

        return numero;
    }

    /**
     * Pide un numero entero cualquiera y mira que sea correcto.
     * 
     * <p>
     * No mira si el numero es muy grande o muy pequeño.
     * </p>
     * 
     * @param mensaje   El texto para pedir el numero.
     * @param scanner_1 La herramienta para leer el teclado.
     * @return El numero que has escrito.
     * @throws Exception Salta si hay un fallo inesperado al leer.
     */
    public static int pedirNumeroEntero(String mensaje, Scanner scanner_1) {
        int numero = -1;
        boolean valido = false;

        do {
            System.out.println(mensaje);
            String entrada = scanner_1.nextLine();

            if (entrada.trim().isEmpty()) {
                System.out.println("Error: No puede estar vacio.");
            } else {
                try {
                    numero = Integer.parseInt(entrada);
                    valido = true;
                } catch (Exception e) {
                    System.out.println("Error: Introduce solo numeros.");
                }
            }
        } while (!valido);

        return numero;
    }

    /**
     * Pide un texto y revisa que solo tenga letras.
     *
     * <p>
     * No deja poner numeros ni simbolos
     * </p>
     *
     * @param mensaje   El texto para pedir el nombre o palabra.
     * @param scanner_1 La herramienta para leer el teclado.
     * @return El texto que has escrito.
     */
    public static String pedir_id(String mensaje, Scanner scanner_1) {
        String resultado = "";
        boolean valido = false;

        do {
            System.out.println(mensaje);
            String entrada = scanner_1.nextLine();

            if (entrada.trim().isEmpty()) {
                System.out.println("Error: No puede estar vacio.");
            } else {
                // Comprobamos que solo contenga letras, espacios y tildes
                if (!entrada.matches("PID-[0-9]+")) {
                    System.out.println("Error: Introduce un PID valido.");
                } else {
                    resultado = entrada;
                    valido = true;
                }
            }
        } while (!valido);

        return resultado;
    }

    /**
     * Es el motor del programa. Aqui se elige que hacer en el menu.
     * 
     * <p>
     * Controla las opciones de añadir productos o venderlos usando
     * </p>
     * 
     * @param args No se usan en este programa.
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Supermercado MercaGuille = new Supermercado();

        final int OPC_ANIADIR = 1, OPC_VENDER = 2, OPC_MOSTRAR = 3, OPC_SALIR = 4, MAXOPCION = 4, MINOPCION = 1;// Opciones
                                                                                                                // del
        // menu

        // Mensajes de las opciones y menu
        final String MENSAJEOPC_ANIADIR = "¿Cuantos productos quieres añadir?",
                MENSAJEOPC_VENDER = "¿Que producto quieres vender? INtroduce el ID",
                MENSAJEOPC_VENDER2 = "¿Cuanto vas a vender?",
                MENSAJEOPC_MOSTRAR = "Mostrando inventario...",
                MENSAJEOPC_SALIR = "Saliendo...",
                MENU = "1. Añadir productos\n2. Vender producto\n3. Mostrar inventario\n4. Salir del programa";

        // ==================MENU=====================
        int opcion = 0;
        while (opcion != OPC_SALIR) {
            opcion = pedirNumero(MENU, MINOPCION, MAXOPCION, input);

            // Opcion 1
            if (opcion == OPC_ANIADIR) {
                int generar = pedirNumeroEntero(MENSAJEOPC_ANIADIR, input);
                MercaGuille.productoAleatorio(generar);

                // Opcion 2
            } else if (opcion == OPC_VENDER) {
                String nuevoProducto = pedir_id(MENSAJEOPC_VENDER, input);
                Producto productoVenta = MercaGuille.buscarProductoId(nuevoProducto);
                if (productoVenta != null) {
                    int numeroAvender = pedirNumeroEntero(MENSAJEOPC_VENDER2, input);
                    MercaGuille.venderProducto(productoVenta, numeroAvender);
                } else {
                    System.out.println("\nAbortando proceso de venta");
                }

                // Opcion 3
            } else if (opcion == OPC_MOSTRAR) {
                mostrarMensaje(MENSAJEOPC_MOSTRAR);
                System.out.println(MercaGuille.toString());

                // Opcion 4
            } else if (opcion == OPC_SALIR) {
                mostrarMensaje(MENSAJEOPC_SALIR);

            }

        }

    }

}
