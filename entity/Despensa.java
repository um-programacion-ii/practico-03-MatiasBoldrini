package entity;

import exceptions.SinVidaUtilException;
import exceptions.StockAgotadoException;
import interfaces.Cocinable;
import interfaces.Despensable;
import interfaces.Reutilizable;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Despensa {
    private Map<String, Despensable> despensables = new HashMap<>();

    public Despensa() {
    }

    public Despensa(Map<String, Despensable> despensables) {
        this.despensables = despensables;
    }


    public Map<String, Despensable> getDespensables() {
        return despensables;
    }

    public void addDespensable(String nombre, Despensable despensable) {
        despensables.put(nombre, despensable);
    }

    public void usarIngrediente(String nombre, int cantidad) throws StockAgotadoException {
        Cocinable cocinable = (Cocinable) despensables.get(nombre);
        if (cocinable == null) {
            throw new StockAgotadoException("No hay " + nombre + " en la despensa");
        }
        cocinable.consumir(cantidad);
    }

    @Override
    public String toString() {
        return "Despensa{" + "despensables=" + despensables + '}';
    }

    public void usarUtensilio(String nombre, int cantidad) throws SinVidaUtilException {
        Reutilizable reutilizable = (Reutilizable) despensables.get(nombre);
        if (reutilizable == null) {
            throw new SinVidaUtilException("No hay " + nombre + " en la despensa");
        }
        ((Reutilizable) despensables.get(nombre)).usar(1);
    }

    public Map<String, Integer> getIngredientes() {
        // Filtrar solo ingredientes
        return despensables.values().stream().filter(d -> d instanceof Cocinable) // Filtrar solo los objetos que implementan Cocinable
                .collect(Collectors.toMap(Despensable::getNombre, Despensable::getCantidad)); // Recoger los resultados en un mapa donde el value es la cantidad
    }

    public int getCantidadIngrediente(String ingrediente) {
        return this.despensables.get(ingrediente).getCantidad();
    }

    public int getVidaUtilUtensilio(String utensilio) {
        Reutilizable reutilizable = (Reutilizable) despensables.get(utensilio);
        return reutilizable.getVidaUtil();
    }

    public Map<String, Integer> getUtensilios() {
        // Filtrar solo ingredientes
        return despensables.values().stream().filter(d -> d instanceof Reutilizable).collect(Collectors.toMap(Despensable::getNombre, d -> ((Reutilizable) d).getVidaUtil()));
    }
}












