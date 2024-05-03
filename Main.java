import entity.*;
import interfaces.Despensable;
import service.Chef;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {


        for (int i = 0; i < 3; i++) {
            Map<String, Despensable> despensables = new HashMap<>() {{
                put("huevo", new Ingrediente("huevo", 6));
                put("agua", new Ingrediente("agua", 20));
                put("carne", new Ingrediente("carne", 10));
                put("sal", new Ingrediente("sal", 10));
                put("aceite", new Ingrediente("aceite", 20));
                put("carne de ternera", new Ingrediente("carne de ternera", 4));
                put("pan rallado", new Ingrediente("pan rallado", 5));
                put("olla", new Utensilio("olla", 20));
                put("cuchara", new Utensilio("cuchara", 10));
                put("sarten", new Utensilio("sarten", 20));
            }};
            Map<String, Receta> recetas = new HashMap<>() {{
                put("huevoDuro", new HuevoDuro());
                // Agrega más recetas si es necesario
            }};
            Despensa despensa = new Despensa(despensables); // Crear una nueva despensa para cada chef
            Thread thread = new Thread(new Chef("Chef " + i, i, recetas, despensa)); // Pasar la despensa como parámetro
            thread.start();
        }
    }
}
