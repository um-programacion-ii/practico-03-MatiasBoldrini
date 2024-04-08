import entity.*;
import service.Chef;
import service.CocinaService;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        System.out.println("============== EJERCICIO 1 ===============");
        Ingrediente ingrediente1 = new Ingrediente("tomate", 10);
        Ingrediente ingrediente2 = new Ingrediente("banana", 20);
        System.out.println( ingrediente1);
        System.out.println( ingrediente2);

        System.out.println("============== EJERCICIO 2 ===============");
        Despensa despensa = new Despensa();
        despensa.addIngrediente(ingrediente1);
        despensa.addIngrediente(ingrediente2);
        System.out.println(despensa);
        // Quitar ingredientes
        despensa.getIngrediente(ingrediente1,5);
        // Quitar ingredientes de mas
        despensa.getIngrediente(ingrediente2,50);
        // Quitar ingredientes justos
        despensa.getIngrediente(ingrediente2,20);
        System.out.println(despensa);

        System.out.println("============== EJERCICIO 3 ===============");
        Ingrediente huevo = new Ingrediente("huevo", 1);
        Ingrediente agua = new Ingrediente("agua", 200);
        Ingrediente[] listaIngredientes = new Ingrediente[2];
        listaIngredientes[0] = huevo;
        listaIngredientes[1] = agua;
        HuevoDuro huevoDuro = new HuevoDuro(10,listaIngredientes,"poner un huevo en agua hirviendo durante 10 minutos");
        System.out.println(huevoDuro);

        Ingrediente[] listaIngredientes1 = new Ingrediente[2];
        Ingrediente milanesa = new Ingrediente("milanesa", 1);
        Ingrediente aceite = new Ingrediente("aceite", 1);
        listaIngredientes1[0] = milanesa;
        listaIngredientes1[1] = aceite;
        Milanesa milanesaReceta = new Milanesa(15,listaIngredientes1,"Freír milanesa");
        System.out.println(milanesaReceta);

        Ingrediente[] listaIngredientes2 = new Ingrediente[1];
        Ingrediente costeleta = new Ingrediente("costeleta", 1);
        listaIngredientes2[0] = costeleta;
        Costeleta costeletaReceta= new Costeleta(10,listaIngredientes2,"Cocinar Costelet apor 10 minutos");
        System.out.println(costeletaReceta);

        System.out.println("============== EJERCICIO 4 ===============\n");
        CocinaService cocinaService = new CocinaService(despensa);
        Chef chef = new Chef("Pepe",3,cocinaService);
        Ingrediente[] listaIngredientesReceta = new Ingrediente[3];

        Ingrediente ingredienteTomate = new Ingrediente("tomate",2);
        listaIngredientesReceta[0] = ingredienteTomate;
        Receta recetaTomate = new Receta(10,listaIngredientesReceta, "comer");
        chef.prepararReceta(recetaTomate);

        despensa.addIngrediente(new Ingrediente("lechuga",10));
        Ingrediente ingredienteLechuga = new Ingrediente("lechuga",3);
        listaIngredientesReceta[1] = ingredienteLechuga;
        Receta recetaEnsalada = new Receta(10,listaIngredientesReceta, "Hacer ensalada y comer");
        chef.prepararReceta(recetaEnsalada);

        despensa.addIngrediente(new Ingrediente("aceite",1));
        Ingrediente ingredienteAceite = new Ingrediente("aceite",1);
        listaIngredientesReceta[2] = ingredienteAceite;
        Receta recetaEnsaladaCompleta = new Receta(10,listaIngredientesReceta, "Hacer ensalada y comer");
        chef.prepararReceta(recetaEnsaladaCompleta);
        System.out.println("#### INTENTANDO DE NUEVO ####");
        chef.prepararReceta(recetaEnsaladaCompleta);



    }
}

