package ApuntesProgramación.SEGUNDOTRIMESTRE.PARAEXAMENJAVA;

import java.util.Random;

public class Faker {
    private Random random = new Random();
    
    private String[] especies = {
        "León", "Tigre de Bengala", "Elefante Africano", "Jirafa Reticulada", "Cebra de Grant", 
        "Panda Gigante", "Gorila de Montaña", "Rinoceronte Blanco", "Hipopótamo", "Leopardo", 
        "Lobo Gris", "Oso Polar", "Oso Pardo", "Pingüino Emperador", "Flamenco", 
        "Águila Real", "Halcón Peregrino", "Búho Real", "Canguro Rojo", "Koala", 
        "Orangután", "Chimpancé", "Suricata", "Hiena Manchada", "Guepardo", 
        "Caimán", "Cocodrilo del Nilo", "Anaconda", "Pitón", "Cobra Real", 
        "Tortuga Gigante", "Iguana Verde", "Camaleón", "Lémur de Cola Anillada", "Tapir", 
        "Carpincho", "Armadillo", "Oso Hormiguero", "Puercoespín", "Lince Ibérico",
        "Lobo Ártico", "Zorro Rojo", "Nutria", "Foca Monje", "Morsa", 
        "Delfín Mular", "Orca", "Ballena Jorobada", "Tiburón Blanco", "Raya Manta"
    };

    // Genera un nombre aleatorio de la lista
    public String animalNombre() {
        return especies[random.nextInt(especies.length)];
    }

    // Genera un número entero aleatorio entre min y max
    public int numero(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    // Genera un precio con decimales
    public double precio(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
    
    // Genera un código aleatorio tipo A1B2C3
    public String generarCodigo() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String cod = "";
        for(int i = 0; i < 6; i++) {
            cod += caracteres.charAt(random.nextInt(caracteres.length()));
        }
        return cod;
    }
}