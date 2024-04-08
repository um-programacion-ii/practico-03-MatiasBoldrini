package service;

import entity.Receta;

public class Chef {
    private String nombre;
    private int estrellasMichelin;
    private CocinaService cocinaService;

    @Override
    public String toString() {
        return "Chef{" +
                "nombre='" + nombre + '\'' +
                ", estrellasMichelin=" + estrellasMichelin +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellasMichelin() {
        return estrellasMichelin;
    }

    public void setEstrellasMichelin(int estrellasMichelin) {
        this.estrellasMichelin = estrellasMichelin;
    }
    public void prepararReceta(Receta receta){
        System.out.println("Preparando la receta ");
        System.out.println("Ingredientes necesarios:");
        System.out.println("\t" + receta.getIngredientesNames());
        System.out.print("Ingredientes en la despensa:");
        System.out.print(this.cocinaService.getDespensa());
        if(this.cocinaService.verificarIngredientes(receta.getIngredientes())){
            System.out.println("\tPreparación: " + receta.getPreparacion());
            System.out.println("\tDespensa luego de la prepación: " + this.cocinaService.getDespensa());
        }
    }
    public Chef() {
    }

    public Chef(String nombre, int estrellasMichelin, CocinaService cocinaService) {
        this.nombre = nombre;
        this.estrellasMichelin = estrellasMichelin;
        this.cocinaService = cocinaService;
    }

}
