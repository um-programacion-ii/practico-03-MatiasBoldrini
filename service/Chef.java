package service;

import entity.Receta;
import exceptions.SinVidaUtilException;
import exceptions.StockAgotadoException;

public class Chef {
    private String nombre;
    private int estrellasMichelin;
    private CocinaService cocinaService;

    public Chef(String nombre, int estrellasMichelin, CocinaService cocinaService) {
        this.nombre = nombre;
        this.estrellasMichelin = estrellasMichelin;
        this.cocinaService = cocinaService;
    }

    public Chef() {
    }


    public CocinaService getCocinaService() {
        return cocinaService;
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
            System.out.println("Preparando receta: " + receta.getClass().getSimpleName());
            DespensaService despensaService = new DespensaService(this);
            cocinaService.verificarIngredientes(receta);
            despensaService.verificarUtensilios(receta);
            despensaService.usarUtensilios(receta);
            cocinaService.cocinar(receta);
            System.out.println("RECETA PREPARADA");
            System.out.println("Ingredientes: " + cocinaService.getDespensa().getIngredientes());
            System.out.println("Utensilios: " + cocinaService.getDespensa().getUtensilios());
        } catch (StockAgotadoException | SinVidaUtilException e) {
            throw new RuntimeException(e);
        }
    }

}
