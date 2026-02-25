package ApuntesProgramación.SEGUNDOTRIMESTRE.REPASOJAVA.constructoresR3.ej1;

public class Ejercicio1 {
        public static void main(String[] args) {

        Embarcacion barcoPirata = new Embarcacion(Faker.nombre(),-5.0, "VELERO");
        Embarcacion barcoPiratilla = new Embarcacion( "La Perla Negrilla" ,35.0, "VLERO", "Jacky", 1900,5000.0);

        System.out.println(barcoPirata);
        System.out.println(barcoPiratilla);




    }
}
