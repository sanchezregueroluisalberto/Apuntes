package ApuntesProgramación.SEGUNDOTRIMESTRE.PARAEXAMENJAVA;

import java.util.ArrayList;

public class Zoologico {
    private ArrayList<Animal> listaAnimales;

    public Zoologico() {
        this.listaAnimales = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        listaAnimales.add(animal);
    }

    public ArrayList<Animal> obtenerTodosLosAnimales() {
        return listaAnimales;
    }

    public Animal buscarPorCodigo(String codigo) {
        Animal animalEncontrado = null;
        for (Animal a : listaAnimales) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                animalEncontrado = a;
            }
        }
        return animalEncontrado;
    }

    public double calcularValorInventario(){
        double acumulado = 0.00;
        for(Animal a : listaAnimales){
            acumulado = acumulado + (a.getPrecio() * a.getCantidad());
        }
        return acumulado;
    }
}
