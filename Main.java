import entity.Despensa;
import entity.Ingrediente;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("============== EJERCICIO 1 ===============");
        Ingrediente ingrediente1 = new Ingrediente("tomate", 10);
        Ingrediente ingrediente2 = new Ingrediente("banana", 20);
        System.out.println( ingrediente1.toString());
        System.out.println( ingrediente2.toString());
        System.out.println("============== EJERCICIO 2 ===============");
        Despensa despensa = new Despensa();
        despensa.addIngrediente(ingrediente1);
        despensa.addIngrediente(ingrediente2);
        System.out.println(despensa.toString());
        // Quitar ingredientes
        despensa.getIngrediente(ingrediente1,5);
        // Quitar ingredientes de mas
        despensa.getIngrediente(ingrediente2,50);
        // Quitar ingredientes justos
        despensa.getIngrediente(ingrediente2,20);
        System.out.println(despensa.toString());
    }
}

