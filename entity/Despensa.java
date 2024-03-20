package entity;

public class Despensa {
    private Ingrediente[] ingredientes = new Ingrediente[2];
    private int cantidadDeIngredientes = 0;
    public void addIngrediente(Ingrediente ingrediente){
        ingredientes[cantidadDeIngredientes] = ingrediente;
        cantidadDeIngredientes ++;
    }
    public void getIngrediente(Ingrediente ingrediente, int cantidad){
            for (Ingrediente ingredienteList: this.ingredientes) {
                if (ingredienteList != null) {
                    if (ingredienteList.getNombre() == ingrediente.getNombre()){
                        ingredienteList.sacar(cantidad);
                    }
                }

            }
        }

    public Despensa() {
    }

    public Despensa(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }
    @Override
    public String toString(){
        String finalStr = "";
        try {
            for (Ingrediente ingredienteList:this.ingredientes) {
                finalStr = finalStr + ingredienteList.getNombre() + " " + ingredienteList.getCantidad()+"\n";
            }

        }
        catch (NullPointerException e){
            System.out.println("No hay ingredientes");
        }

        return finalStr;
    }
}
