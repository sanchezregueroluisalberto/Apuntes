package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR3.ej4;

class Streamer {
    static int numeroStreamers = 0;
    int id;
    String nombreCanal;
    int seguidores;
    String categoriaPrincipal;
    String pais;

    public Streamer(String nombreCanal, int seguidores, String categoriaPrincipal,
            String pais) {
        Streamer.numeroStreamers++;
        this.id = Streamer.numeroStreamers;
        this.nombreCanal = nombreCanal;
        this.seguidores = seguidores;
        this.categoriaPrincipal = categoriaPrincipal;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "El streamer" + nombreCanal + " procedente de " + pais + " con " + seguidores
                + " seguidores, y especialidado en " + categoriaPrincipal + ". Hay un total de " + numeroStreamers
                + " streamers.";
    }

    public static int getNumeroStreamers() {
        return numeroStreamers;
    }

    public int getId() {
        return id;
    }

    public String getNombreCanal() {
        return nombreCanal;
    }

    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public String getCategoriaPrincipal() {
        return categoriaPrincipal;
    }

    public void setCategoriaPrincipal(String categoriaPrincipal) {
        this.categoriaPrincipal = categoriaPrincipal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
