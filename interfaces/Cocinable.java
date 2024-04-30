package interfaces;

import exceptions.StockAgotadoException;

public interface Cocinable extends Despensable{
    void consumir(int cantidad) throws StockAgotadoException;

}
