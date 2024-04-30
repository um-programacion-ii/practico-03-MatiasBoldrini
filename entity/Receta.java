package entity;

import interfaces.Cocinable;
import interfaces.Reutilizable;

import java.util.Map;

public class Receta {
    private Integer tiempoCoccion;
    private Map<String, Cocinable> ingredientes;
    private Map<String, Reutilizable> utensilios;
    private String preparacion;

    public Receta() {
    }


    public Receta(Integer tiempoCoccion, Map<String, Cocinable> ingredientes, Map<String, Reutilizable> utensilios, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
        this.preparacion = preparacion;
    }


    public Map<String, Cocinable> getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "Receta{" + "tiempoCoccion=" + tiempoCoccion + ", ingredientes=" + ingredientes + ", utensilios=" + utensilios + ", preparacion='" + preparacion + '\'' + '}';
    }

    public int getCantidadIngrediente(String ingrediente) {
        return this.ingredientes.get(ingrediente).getCantidad();
    }


    public Map<String, Reutilizable> getUtensilios() {
        return utensilios;
    }

}
