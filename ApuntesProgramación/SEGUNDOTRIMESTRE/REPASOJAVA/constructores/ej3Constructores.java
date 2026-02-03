package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructores;

public class ej3Constructores {
    public static void main(String[] args) {
        alumno Alumno1 = new alumno("Luis", "Programacion", 6);
        Alumno1.aprobar(6); // aprobado
        Alumno1.aprobar(5); // suspenso

    }
}

class alumno {
    String nombre = "";
    String materia = "";
    double calificacion = 0.00;
    boolean aprobado = false;

    final double NOTAAPROBADAMINIMA = 6.00;

    alumno(String nombre, String materia, double calificacion) {
        this.nombre = nombre;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    void aprobar(double calificacion){
        if(calificacion >= NOTAAPROBADAMINIMA){
            aprobado = true;
            System.out.println("Has sacado un " + calificacion + ", has aprobado!!!");
        } else{
            aprobado = false;
            System.out.println("Lavin que cipollo aplicate mas, has suspendido con un: " + calificacion);
        }
    }
}