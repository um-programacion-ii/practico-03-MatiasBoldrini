import entity.*;
import interfaces.Despensable;
import service.Chef;
import service.CocinaService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Map<String, Receta> recetas = new HashMap<>() {{
            put("milanesa", new Milanesa());
            put("huevoDuro", new HuevoDuro());
        }};
        Map<String, Despensable> despensables = new HashMap<>() {{
            put("huevo", new Ingrediente("huevo", 100));
            put("agua", new Ingrediente("agua", 20));
            put("carne", new Ingrediente("carne", 10));
            put("sal", new Ingrediente("sal", 10));
            put("aceite", new Ingrediente("aceite", 20));
            put("olla", new Utensilio("olla", 2));
            put("cuchara", new Utensilio("cuchara", 1));
            put("sarten", new Utensilio("sarten", 2));
            put("carne de ternera", new Ingrediente("carne de ternera", 4));
            put("pan rallado", new Ingrediente("pan rallado", 5));
        }};
        Despensa despensa = new Despensa(despensables);
        CocinaService cocinaService = new CocinaService(despensa);
        Chef chef = new Chef("Matias", 3, cocinaService);
        for (Receta receta : recetas.values()) {
            chef.prepararReceta(receta);
        }


    }
}

