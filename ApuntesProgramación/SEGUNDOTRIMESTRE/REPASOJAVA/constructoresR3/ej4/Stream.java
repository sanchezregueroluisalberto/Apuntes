package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR3.ej4;

class Stream {
    static int numeroStreams = 0;
    int id;
    Streamer streamer;
    String titulo;
    int duracionMin;
    String categoria;
    int mediaViewers;
    String fecha;
    boolean activo;

    public Stream(Streamer streamer, String titulo, int duracionMin, String categoria, int mediaViewers, String fecha) {
        Stream.numeroStreams++;
        this.id = Stream.numeroStreams;
        this.streamer = streamer;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.categoria = categoria;
        this.mediaViewers = mediaViewers;
        this.fecha = fecha;
        this.activo = false;
    }

    public static int getNumeroStreams() {
        return numeroStreams;
    }

    public int getId() {
        return id;
    }

    public Streamer getStreamer() {
        return streamer;
    }

    public void setStreamer(Streamer streamer) {
        this.streamer = streamer;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getMediaViewers() {
        return mediaViewers;
    }

    public void setMediaViewers(int mediaViewers) {
        this.mediaViewers = mediaViewers;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void activar() {
        activo = true;
        System.out.println("El Streamer " + streamer.getNombreCanal() + " esta en directo, El titulo es" + titulo);
    }

    public void desactivar() {
        activo = false;
        System.out.println("El Streamer " + streamer.getNombreCanal() + " ha finalizado");
    }

    @Override
    public String toString() {
        String estado = activo ? "EN VIVO" : "OFFLINE";
        return "=== DETALLES DEL STREAM (ID: " + id + ") ===\n" +
                "Título: " + titulo + "\n" +
                "Streamer: " + (streamer != null ? streamer.getNombreCanal() : "No asignado") + "\n" +
                "Categoría: " + categoria + "\n" +
                "Estado actual: " + estado + "\n" +
                "Datos: " + mediaViewers + " viewers de media | " + duracionMin + " min de duración\n" +
                "Fecha: " + fecha + "\n";
    }
}
