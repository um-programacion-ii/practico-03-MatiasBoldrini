package entity;

import interfaces.Cocinable;
import interfaces.Reutilizable;

import java.util.HashMap;
import java.util.Map;

public class Milanesa extends Receta {
    public Milanesa() {
        super(30, inicializarIngredientes(), inicializarUtensilios(), inicializarPreparacion());
    }

    private static Map<String, Cocinable> inicializarIngredientes() {
        Map<String, Cocinable> ingredientes = new HashMap<>();
        ingredientes.put("carne de ternera", new Ingrediente("carne de ternera", 1));
        ingredientes.put("pan rallado", new Ingrediente("pan rallado", 1));
        ingredientes.put("huevo", new Ingrediente("huevo", 2));
        ingredientes.put("sal", new Ingrediente("sal", 1));
        ingredientes.put("aceite", new Ingrediente("aceite", 2));
        return ingredientes;
    }

    private static Map<String, Reutilizable> inicializarUtensilios() {
        Map<String, Reutilizable> ingredientes = new HashMap<>();
        ingredientes.put("olla", new Utensilio("olla", 1));
        ingredientes.put("sarten", new Utensilio("sarten", 1));
        return ingredientes;
    }
    private static String inicializarPreparacion() {
        return "1. Preparar la carne de ternera cortándola en filetes finos. 2. Salpimentar los filetes al gusto. 3. Preparar un plato con pan rallado. 4. Batir los huevos en otro plato. 5. Pasar los filetes por el pan rallado, luego por el huevo batido y nuevamente por el pan rallado. 6. Calentar el aceite en una sartén. 7. Freír los filetes hasta que estén dorados por ambos lados. 8. Retirar del fuego y colocar sobre papel absorbente para eliminar el exceso de aceite. 9. Servir caliente y disfrutar de una deliciosa milanesa.";

    }
}
