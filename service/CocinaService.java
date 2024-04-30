package service;

import entity.Despensa;
import entity.Receta;
import exceptions.StockAgotadoException;
import interfaces.Cocinable;

import java.util.Set;

public class CocinaService {
    public Despensa despensa;

    public CocinaService(Despensa despensa) {
        this.despensa = despensa;
    }

    public CocinaService() {
    }

    public Despensa getDespensa() {
        return despensa;
    }

    public void cocinar(Receta receta) throws StockAgotadoException {
        for (Cocinable ingrediente : receta.getIngredientes().values()) {
            this.despensa.usarIngrediente(ingrediente.getNombre(), ingrediente.getCantidad());
        }
    }

    public void verificarIngredientes(Receta receta) throws StockAgotadoException {
        for (Cocinable ingReceta : receta.getIngredientes().values()) {
            Set<String> ingredientesDespensa = this.despensa.getIngredientes().keySet();
            if (!ingredientesDespensa.contains(ingReceta.getNombre())) {
                throw new StockAgotadoException("No hay " + ingReceta.getNombre() + " en la despensa");
            }
            if (this.despensa.getCantidadIngrediente(ingReceta.getNombre()) < ingReceta.getCantidad()) {
                throw new StockAgotadoException("Faltan " + (ingReceta.getCantidad() - this.despensa.getCantidadIngrediente(ingReceta.getNombre())) + " " + ingReceta.getNombre() + " en la despensa");
            }
        }
    }
}
