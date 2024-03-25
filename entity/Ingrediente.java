package entity;


public class Ingrediente {
    private String nombre;
    private int cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Ingrediente() {
    }

    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    public void sacar(int cantidad){
        if ( this.cantidad-cantidad >= 0){
            this.cantidad-=cantidad;
        }
        else {
            System.out.println("Intentaste sacar " + cantidad + " " + this.nombre + "/s pero solo quedan " + this.cantidad);
        }
    }
    public void addIngrediente(){
        this.cantidad+=1;
    }

}

