import entity.Ingrediente;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Ingrediente ingrediente1 = new Ingrediente("tomate", 1);
        Ingrediente ingrediente2 = new Ingrediente("banana", 2);
        System.out.println( ingrediente1.toString());
        System.out.println( ingrediente2.toString());
    }
}

