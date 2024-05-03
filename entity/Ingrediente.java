package entity;


import exceptions.StockAgotadoException;
import interfaces.Cocinable;

public class Ingrediente implements Cocinable {
    private String nombre;
    private int cantidad;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "nombre='" + nombre + '\'' + ", cantidad=" + cantidad + '}';
    }


    public void addIngrediente() {
        this.cantidad += 1;
    }


    @Override
    public void consumir(int cantidad) throws StockAgotadoException {
        System.out.println(System.identityHashCode(this));
        if (this.cantidad < cantidad) {
            throw new StockAgotadoException("Quisiste sacar más " + this.nombre + " (" + cantidad + ") del que hay en stock (" + this.cantidad + ")");
        }
        this.cantidad -= cantidad;
    }
}

