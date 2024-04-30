package entity;

import interfaces.Cocinable;
import interfaces.Reutilizable;

import java.util.HashMap;
import java.util.Map;

public class HuevoDuro extends Receta {
    public HuevoDuro() {
        super(10, inicializarIngredientes(), inicializarUtensilios(), inicializarPreparacion());
    }

    private static Map<String, Cocinable> inicializarIngredientes() {
        Map<String, Cocinable> ingredientes = new HashMap<>();
        ingredientes.put("huevo", new Ingrediente("huevo", 4));
        ingredientes.put("sal", new Ingrediente("sal", 1));
        return ingredientes;
    }

    private static Map<String, Reutilizable> inicializarUtensilios() {
        Map<String, Reutilizable> utensilios = new HashMap<>();
        utensilios.put("olla", new Utensilio("olla", 1));
        utensilios.put("cuchara", new Utensilio("cuchara", 1));
        return utensilios;
    }

    private static String inicializarPreparacion() {
        return "1. Colocar los huevos en una olla con agua fría y añadir sal al gusto. 2. Llevar la olla a ebullición a fuego alto. 3. Una vez que el agua comience a hervir, reducir el fuego a medio-bajo y cocinar durante 10 minutos. 4. Pasado el tiempo de cocción, retirar los huevos del agua caliente y sumergirlos inmediatamente en agua fría con hielo para detener la cocción. 5. Pelar los huevos con cuidado y cortarlos según se desee. 6. Servir los huevos duros como aperitivo, en ensaladas o como parte de otras recetas.";
    }
}
