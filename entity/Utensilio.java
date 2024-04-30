package entity;


import exceptions.SinVidaUtilException;
import interfaces.Reutilizable;

public class Utensilio implements Reutilizable {
    private String nombre;
    private int vidaUtil;
    private int vidaUtilInicial;
    public Utensilio() {
    }

    public Utensilio(String nombre, int vidaUtil) {
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
        this.vidaUtilInicial = vidaUtil;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void renovar() {
        this.vidaUtil = this.vidaUtilInicial;
    }

    @Override
    public int getVidaUtil() {
        return this.vidaUtil;
    }

    @Override
    public int getCantidad() {
        return 1;
    }

    @Override
    public String toString() {
        return nombre + "  Vida útil: "+vidaUtil;
    }

    @Override
    public void usar(int tiempo) throws SinVidaUtilException {
        if (tiempo > this.vidaUtil) {
            throw new SinVidaUtilException(String.format("El utensilio se quedó sin vida util %s", this.nombre));
        }
        this.vidaUtil -= tiempo;
    }

}
