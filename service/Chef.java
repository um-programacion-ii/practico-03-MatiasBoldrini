package service;

import entity.*;
import exceptions.SinVidaUtilException;
import exceptions.StockAgotadoException;
import interfaces.Despensable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static javax.swing.UIManager.put;

public class Chef implements Runnable {
    private String nombre;
    private int estrellasMichelin;
    private Map<String, Receta> recetas;
    private Despensa despensa;

    public Chef(String nombre, int estrellasMichelin, Map<String, Receta> recetas, Despensa despensa) {
        this.nombre = nombre;
        this.estrellasMichelin = estrellasMichelin;
        this.recetas = recetas;
        this.despensa = despensa;
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

    public void prepararReceta(Receta receta) {
        try {
            CocinaService cocinaService = CocinaService.getInstance(this.despensa).clone();
            DespensaService despensaService = new DespensaService(this.despensa);
            if (cocinaService.verificarIngredientes(receta, this.getNombre())) {
                despensaService.verificarUtensilios(receta);
                despensaService.usarUtensilios(receta);
                cocinaService.setDespensa(despensa);
                cocinaService.cocinar(receta);
            }
        } catch (StockAgotadoException | SinVidaUtilException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        for (Receta receta : recetas.values()) {
            prepararReceta(receta);
        }
    }
}
