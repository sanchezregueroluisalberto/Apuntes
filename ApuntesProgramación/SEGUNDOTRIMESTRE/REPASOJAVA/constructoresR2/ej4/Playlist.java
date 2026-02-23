package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR2.ej4;

import java.util.ArrayList;

public class Playlist {
    ArrayList<Canciones> cancionesPlaylist;

    Playlist() {
        this.cancionesPlaylist = new ArrayList<>();
    }

    public void agregarCanciones(Canciones cancion) {
        cancionesPlaylist.add(cancion);
    }

    public String mostrarTodasCanciones(Canciones cancion){
        String lista = "";
        for(Canciones cancionCualquiera : cancionesPlaylist){
            lista += 
        }
        return
    }
}
