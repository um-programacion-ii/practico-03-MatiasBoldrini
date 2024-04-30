package interfaces;

import exceptions.SinVidaUtilException;

public interface Reutilizable extends Despensable {

    void usar(int tiempo) throws SinVidaUtilException;

    String getNombre();

    void setNombre(String nombre);

    void renovar();

    int getVidaUtil();

}