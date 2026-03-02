package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR3.ej4;

class Suscripcion {
    static int numeroSuscripciones = 0;
    int id;
    String usuario;
    Streamer streamer;
    int meses;
    int tier;
    String fechaInicio;

    public Suscripcion(String usuario, Streamer streamer, int meses, int tier, String fechaInicio) {
        Suscripcion.numeroSuscripciones++;
        this.id = Suscripcion.numeroSuscripciones;
        this.usuario = usuario;
        this.streamer = streamer;
        // validamos meses y tier
        this.meses = (meses >= 1) ? meses : 1;
        this.tier = (tier >= 1 && tier <= 3) ? tier : 1;
        this.fechaInicio = fechaInicio;
    }

    public static int getNumeroSuscripciones() {
        return numeroSuscripciones;
    }

    public static void setNumeroSuscripciones(int numeroSuscripciones) {
        Suscripcion.numeroSuscripciones = numeroSuscripciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Streamer getStreamer() {
        return streamer;
    }

    public void setStreamer(Streamer streamer) {
        this.streamer = streamer;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double precioMensual() {
        double coste = 0.00;
        if (this.tier == 1) {
            coste = 4.99;
        } else if (tier == 2) {
            coste = 9.99;
        } else {
            coste = 24.99;
        }
        return coste;
    }

    public double ingresoTotal() {
        double precioTotalPago;
        precioTotalPago = precioMensual() * meses;
        return precioTotalPago;
    }

    @Override
    public String toString() {
        return "Suscripción #" + id + " [" + usuario + "]" +
                "\nCanal: " + (streamer != null ? streamer.getNombreCanal() : "Desconocido") +
                "\nTier: " + tier + " | Cuota: " + precioMensual() + "€" +
                "\nTiempo: " + meses + " meses | Total: " + ingresoTotal() + "€" +
                "\nFecha: " + fechaInicio + "\n";
    }

}
