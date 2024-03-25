import entity.*;

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
        System.out.println("============== EJERCICIO 3 ===============");

        Ingrediente huevo = new Ingrediente("huevo", 1);
        Ingrediente agua = new Ingrediente("agua", 200);
        Ingrediente[] listaIngredientes = new Ingrediente[2];
        listaIngredientes[0] = huevo;
        listaIngredientes[1] = agua;
        HuevoDuro huevoDuro = new HuevoDuro(10,listaIngredientes,"poner un huevo en agua hirviendo durante 10 minutos");
        System.out.println(huevoDuro.toString());

        Ingrediente[] listaIngredientes1 = new Ingrediente[2];
        Ingrediente milanesa = new Ingrediente("milanesa", 1);
        Ingrediente aceite = new Ingrediente("aceite", 1);
        listaIngredientes1[0] = milanesa;
        listaIngredientes1[1] = aceite;
        Milanesa milanesaReceta = new Milanesa(15,listaIngredientes1,"Freír milanesa");
        System.out.println(milanesaReceta.toString());

        Ingrediente[] listaIngredientes2 = new Ingrediente[1];
        Ingrediente costeleta = new Ingrediente("costeleta", 1);
        listaIngredientes2[0] = costeleta;
        Costeleta costeletaReceta= new Costeleta(10,listaIngredientes2,"Cocinar Costelet apor 10 minutos");
        System.out.println(costeletaReceta.toString());

    }
}

