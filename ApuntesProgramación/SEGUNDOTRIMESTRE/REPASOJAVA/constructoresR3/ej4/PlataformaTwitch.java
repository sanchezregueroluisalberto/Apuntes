package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR3.ej4;

import java.util.ArrayList;

class PlataformaTwitch {
    ArrayList<Streamer> streamers = new ArrayList<>();
    ArrayList<Stream> streams = new ArrayList<>();
    ArrayList<Suscripcion> suscripciones = new ArrayList<>();

    String nombrePlataforma;
    String empresaPropietaria;
    String paisSede;
    int anioFundacion;

    public PlataformaTwitch(String nombrePlataforma, String empresaPropietaria, String paisSede, int anioFundacion) {
        this.nombrePlataforma = nombrePlataforma;
        this.empresaPropietaria = empresaPropietaria;
        this.paisSede = paisSede;
        this.anioFundacion = anioFundacion;
        this.streamers = new ArrayList<>();
        this.streams = new ArrayList<>();
        this.suscripciones = new ArrayList<>();
    }

    public void altaStreamer(Streamer s) {
        boolean existe = false;
        for (Streamer existente : streamers) {
            if (existente.getNombreCanal().equals(s.getNombreCanal())) {
                existe = true;
            }
        }
        if (!existe) {
            streamers.add(s);
            System.out.println("Streamer " + s.getNombreCanal() + " añadido");
        } else {
            System.out.println("Error al añadir el canal. " + s.getNombreCanal() + " ya existe");
        }

    }

    public void IniciarStream(Streamer s, String titulo, String categoria, String fecha) {
        boolean yaEnDirecto = false;
        for (Stream st : streams) {
            if (st.getStreamer().equals(s) && st.isActivo()) {
                yaEnDirecto = true;
            }
        }
        if (!yaEnDirecto) {
            Stream nuevoStream = new Stream(s, titulo, 0, categoria, 0, fecha);
            nuevoStream.activar();
            streams.add(nuevoStream);
        } else {
            System.out.println("Error, " + s.getNombreCanal() + " tiene un stream empezado ya");
        }
    }

    public void finalizarStream(Streamer s) {
        boolean encontrado = false;
        for (Stream st : streams) {
            if (st.getStreamer().equals(s) && st.isActivo()) {
                st.desactivar();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No existe ningun stream de " + s.getNombreCanal());
        }
    }

    public void crearSuscripcion(String usuario, Streamer s, int meses, int tier, String fechaInicio) {
        boolean pagando = false;
        for (Suscripcion suscrip : suscripciones) {
            if (suscrip.getUsuario().equals(usuario) && suscrip.getStreamer().equals(s)) {
                suscrip.setMeses(suscrip.getMeses() + meses);
                suscrip.setTier(tier);
                pagando = true;
            }
        }
        if (!pagando) {
            suscripciones.add(new Suscripcion(usuario, s, meses, tier, fechaInicio));
            System.out.println("Te has suscrito a " + s.getNombreCanal());
        }
    }

    public void listarStreamsDeStreamer(Streamer s) {
        System.out.println("Historial de " + s.getNombreCanal() + ":");
        for (Stream st : streams) {
            if (st.getStreamer().equals(s)) {
                System.out.println("- " + st.getTitulo() + " --> " + st.getFecha());
            }
        }
    }

    public double calcularIngresosEstimados() {
        double total = 0;
        for (Suscripcion suscrip : suscripciones) {
            total += suscrip.ingresoTotal();
        }
        return total;
    }

    public void top5StreamersPorIngresos() {
        ArrayList<Streamer> copia = new ArrayList<>(streamers);
        for (int i = 0; i < 5; i++) {
            if (!copia.isEmpty()) {
                Streamer topActual = null;
                double maxIngreso = -1.0;

                for (Streamer s : copia) {
                    double ingresosDeEsteStreamer = 0;
                    for (Suscripcion suscrip : suscripciones) {
                        if (suscrip.getStreamer().getId() == s.getId()) {
                            ingresosDeEsteStreamer += suscrip.ingresoTotal();
                        }
                    }
                    if (ingresosDeEsteStreamer > maxIngreso) {
                        maxIngreso = ingresosDeEsteStreamer;
                        topActual = s;
                    }
                }
                if (topActual != null) {
                    System.out.println((i + 1) + ". " + topActual.getNombreCanal() + " --> " + maxIngreso + "€");
                    copia.remove(topActual);
                }
            }
        }
    }

    public String contarStreamsPorCategoria() {
        String informe = "";
        String categ = "";
        boolean yaContada = false;
        int contador = 0;

        ArrayList<String> categoriaVistas = new ArrayList<>();

        for (Stream st : streams) {
            categ = st.getCategoria();
            yaContada = false;
            for (String vista : categoriaVistas) {
                if (vista.equals(categ)) {
                    yaContada = true;

                }
            }
            if (!yaContada) {
                contador = 0;
                for (Stream st2 : streams) {
                    if (st2.getCategoria().equals(categ)) {
                        contador++;
                    }
                }
                informe += "Categoria: " + categ + "- Total: " + contador + "\n";
                categoriaVistas.add(categ);
            }
        }
        return informe;
    }

    public double mediaGlobalViewers() {
        double suma = 0.0;
        double resultado = 0.0;
        for (Stream st : streams) {
            suma += st.getMediaViewers();
        }
        if (streams.size() > 0) {
            resultado = suma / streams.size();
        }
        return resultado;
    }
}
