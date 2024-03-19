package entity;


public class Ingrediente {
    private String nombre;
    private int cantidad;


    public Ingrediente() {
    }

    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    @Override
    public String toString(){
        return ("Ingredientente: "  +this.nombre + " Cantidad: " + this.cantidad);
    }

}
