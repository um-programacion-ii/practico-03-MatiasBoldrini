package service;

import entity.Despensa;
import entity.Receta;
import exceptions.StockAgotadoException;
import interfaces.Cocinable;
import interfaces.Despensable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CocinaService implements Serializable, Cloneable {
    private static volatile CocinaService instance;

    private Despensa despensa;

    private CocinaService(Despensa despensa) {
        this.despensa = new Despensa(despensa.getDespensables());
    }

    public void setDespensa(Despensa despensa) {

        instance.despensa = new Despensa(despensa.getDespensables());
    }

    public static CocinaService getInstance(Despensa despensa) {
        CocinaService result = instance;
        if (result != null) {
            return result;
        }
        synchronized (CocinaService.class) {
            if (instance == null) {
                instance = new CocinaService(despensa);
                System.out.println(instance.getDespensa());
            }
            return instance;
        }
    }

    public CocinaService() {
    }

    public Despensa getDespensa() {
        return despensa;
    }

    public void cocinar(Receta receta) throws StockAgotadoException {
        for (Cocinable ingrediente : receta.getIngredientes().values()) {
//            System.out.println("cocina " + ingrediente.getCantidad() + " " + ingrediente.getNombre() + " "+System.identityHashCode(ingrediente));
//            System.out.println(System.identityHashCode(instance.despensa));
            instance.despensa.usarIngrediente(ingrediente.getNombre(), ingrediente.getCantidad());
        }
    }

    public boolean verificarIngredientes(Receta receta, String chef) throws StockAgotadoException {
        for (Cocinable ingReceta : receta.getIngredientes().values()) {

            Set<String> ingredientesDespensa = instance.despensa.getIngredientes().keySet();
            if (!ingredientesDespensa.contains(ingReceta.getNombre())) {
                throw new StockAgotadoException("No hay " + ingReceta.getNombre() + " en la despensa");
            }
            if (instance.despensa.getCantidadIngrediente(ingReceta.getNombre()) < ingReceta.getCantidad()) {
                throw new StockAgotadoException("Faltan " + (ingReceta.getCantidad() - instance.despensa.getCantidadIngrediente(ingReceta.getNombre())) + " " + ingReceta.getNombre() + " en la despensa");
            }
        }
        return true;
    }

    @Override
    public CocinaService clone() {
        try {
            CocinaService clone = (CocinaService) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
