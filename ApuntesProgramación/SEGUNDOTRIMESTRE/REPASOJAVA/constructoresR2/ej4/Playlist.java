package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej4;

import java.util.ArrayList;

public class Playlist {
    private ArrayList<Canciones> cancionesPlaylist;

    Playlist() {
        this.cancionesPlaylist = new ArrayList<>();
    }

    public void agregarCanciones(Canciones cancion) {
        cancionesPlaylist.add(cancion);
    }

    public String mostrarTodasCanciones() {
        String lista = "";
        for (Canciones cancion : cancionesPlaylist) {
            lista += cancion.toString() + "\n";
        }
        return lista;
    }
    public int sumatorioTotalPlaylist(){
        int total = 0;
        for(Canciones cancion : cancionesPlaylist){
            total += cancion.getDuracion();
        }
        return total;
    }
}
