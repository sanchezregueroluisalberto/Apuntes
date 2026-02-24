package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej4;

import java.util.Random;

public class Faker {
    private Random random = new Random();

    // Listas de datos para inventar canciones
    private String[] generos = {"Rock", "Pop", "Jazz", "Indie", "Trap", "Metal", "Techno", "Blues"};
    private String[] adjetivos = {"Eternal", "Dark", "Golden", "Lost", "Crazy", "Silent", "Wild"};
    private String[] nombresArtistas = {"Luna", "Shadow", "Echo", "The King", "Nova", "Ghost", "Alpha"};

    // Método para simular faker.music().instrument() o similares
    public String tituloAleatorio() {
        String gen = generos[random.nextInt(generos.length)];
        String adj = adjetivos[random.nextInt(adjetivos.length)];
        return gen + " " + adj;
    }

    // Método para simular faker.artist().name()
    public String artistaAleatorio() {
        return nombresArtistas[random.nextInt(nombresArtistas.length)] + " " + (random.nextInt(99) + 1);
    }

    // Método para simular faker.number().numberBetween()
    public int duracionAleatoria(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}