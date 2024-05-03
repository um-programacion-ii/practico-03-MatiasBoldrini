package service;

import entity.Despensa;
import entity.Receta;
import exceptions.SinVidaUtilException;
import interfaces.Reutilizable;

import java.util.Set;

public class DespensaService {
    Despensa despensa;

    public DespensaService(Despensa despensa) {
        this.despensa = despensa;
    }

    public void renovarUtensilios(String utensilio) {

    }

    public void verificarUtensilios(Receta receta) throws SinVidaUtilException {
        for (Reutilizable utensilio : receta.getUtensilios().values()) {

            Set<String> utensiliosDespensa = this.despensa.getUtensilios().keySet();
            if (!utensiliosDespensa.contains(utensilio.getNombre())) {
                throw new SinVidaUtilException("No hay " + utensilio.getNombre() + " en la despensa");
            }
            if (despensa.getVidaUtilUtensilio(utensilio.getNombre()) < utensilio.getVidaUtil()) {
                throw new SinVidaUtilException("El " + (utensilio.getNombre() + " No tiene vida util suficiente"));
            }
        }
    }

    public void usarUtensilios(Receta receta) throws SinVidaUtilException {
        for (Reutilizable utensilio : receta.getUtensilios().values()) {
            this.despensa.usarUtensilio(utensilio.getNombre(), utensilio.getVidaUtil());
        }
    }

}
