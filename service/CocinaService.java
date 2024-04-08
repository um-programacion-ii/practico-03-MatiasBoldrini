package service;

import entity.Despensa;
import entity.Ingrediente;

public class CocinaService {
    private Despensa despensa;

    public CocinaService(Despensa despensa) {
        this.despensa = despensa;
    }

    public Despensa getDespensa() {
        return despensa;
    }

    public CocinaService() {
    }

    public boolean verificarIngredientes(Ingrediente[] ingredientesNecesarios){
        Ingrediente[] ingredientesDespensa = this.getDespensa().getIngredientes();
        boolean faltanIngredientes = false;
        for(Ingrediente ingNecesario : ingredientesNecesarios) {
            // Loop en lista de ingredientes necesarios
            for(Ingrediente ingDespensa: ingredientesDespensa){
                try {
                    if (ingDespensa.getNombre().equals(ingNecesario.getNombre())){
                        int diferenciaIngredientes = ingDespensa.getCantidad() - ingNecesario.getCantidad();
                        if (diferenciaIngredientes < 0){
                            System.out.println("Falta "+ diferenciaIngredientes*-1 + " "+ ingDespensa.getNombre());
                            faltanIngredientes = true;
                        }
                        else {
                            this.despensa.getIngrediente(ingDespensa,ingNecesario.getCantidad());
                        }
                    }
                } catch (NullPointerException e) {
                    break;
                }

            }
        }
        System.out.println();
        return !faltanIngredientes;
    }

}
