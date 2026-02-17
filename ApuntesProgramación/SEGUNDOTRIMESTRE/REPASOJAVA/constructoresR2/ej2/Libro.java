package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej2;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String sinopsis;
    private boolean disponible;

    Libro(int id, String titulo, String autor, String sinopsis, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.disponible = disponible;
    }

    public String toString() {
        String estado = disponible ? "Disponible" : "No Disponible";
        return "Informacion del libro: ID: " + id + " | titulo: " + titulo + " | autor: " + autor + " | sinopsis: "
                + sinopsis + " | estado: " + estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

}
