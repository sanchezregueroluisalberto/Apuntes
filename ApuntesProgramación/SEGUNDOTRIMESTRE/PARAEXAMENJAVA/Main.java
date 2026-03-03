package ApuntesProgramación.SEGUNDOTRIMESTRE.PARAEXAMENJAVA;

import java.util.Scanner;

public class Main {
    public static int pedirOpcion(Scanner escaner) {
        int opcionJuego = 0;
        do {
            try {
                System.out.print(
                        "\n--- MENÚ ---\n1. Mostrar todos los animales\n2. Buscar un animal por código\n3. Agregar ejemplares a un animal\n4.Retirar ejemplares de un animal\n5. Eliminar un animal\n0. Salir\nElige una opción: ");
                opcionJuego = escaner.nextInt();
                escaner.nextLine();
            } catch (Exception e) {
                System.out.println("Algo ha fallado");
                opcionJuego = -1;
                escaner.nextLine();
            }

        } while (opcionJuego < 0 || opcionJuego > 5);

        return opcionJuego;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoologico miZoo = new Zoologico();
        Faker faker = new Faker();

        int opcion = -1;
        String code;
        int cantidadEjemplares;

        for (int i = 0; i < 1000; i++) {
            String nombre = Faker.nombreAnimal();
            String codigo = Faker.codigoAnimal() + "-" + i;
            int cantidad = Faker.entero(0, 20);
            double precio = Faker.precio(i, cantidad);

            miZoo.agregarAnimal(new Animal(nombre, codigo, cantidad, precio));
        }

        while (opcion != 0) {
            opcion = pedirOpcion(scanner);

            if (opcion == 1) {
                for (Animal a : miZoo.obtenerTodosLosAnimales()) {
                    System.out.println(a.toString());
                }
            } else if (opcion == 2) {
                System.out.println("Introduce el codigo: ");
                code = scanner.nextLine();
                Animal a = miZoo.buscarPorCodigo(code);
                if (a != null) {
                    System.out.println(a.toString());
                } else {
                    System.out.println("Animal no encontrado");
                }
            } else if (opcion == 3) {
                System.out.println("Introduce el codigo: ");
                code = scanner.nextLine();
                Animal a = miZoo.buscarPorCodigo(code);
                if (a != null) {
                    System.out.println("¿Cuantos ejemplares quieres añadir?");
                    cantidadEjemplares = scanner.nextInt();
                    scanner.nextLine();
                    a.setCantidad(a.getCantidad() + cantidadEjemplares);
                } else {
                    System.out.println("Animal no encontrado");
                }
            } else if (opcion == 4) {
                System.out.println("Introduce el codigo: ");
                code = scanner.nextLine();
                Animal a = miZoo.buscarPorCodigo(code);
                if (a != null) {
                    System.out.println("¿Ejemplares a eliminar?: ");
                    cantidadEjemplares = scanner.nextInt();
                    scanner.nextLine();
                    if (cantidadEjemplares > a.getCantidad()) {
                        System.out.println("No puedes eliminar mas ejemplares");
                    } else {
                        a.setCantidad(a.getCantidad() - cantidadEjemplares);
                        System.out.println("Cantidad de ejemplares actualizada");
                    }
                } else {
                    System.out.println("Animal no encontrado");
                }
            } else if (opcion == 5) {
                System.out.println("Introduce el codigo del animal a eliminar: ");
                code = scanner.nextLine();
                Animal a = miZoo.buscarPorCodigo(code);
                if (a != null) {
                    if (a.getCantidad() == 0) {
                        miZoo.obtenerTodosLosAnimales().remove(a);
                        System.out.println("Animal eliminado correctamente");
                    } else {
                        System.out.println("No se puede eliminar un animal con ejemplares disponibles");
                    }
                } else {
                    System.out.println("Animal no encontrado");
                }
            }
        }
        scanner.close();
    }
}
