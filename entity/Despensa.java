package entity;

public class Despensa {
    private Ingrediente[] ingredientes = new Ingrediente[20];
    private int cantidadDeIngredientes = 0;
    public void addIngrediente(Ingrediente ingrediente){
        this.ingredientes[this.cantidadDeIngredientes] = ingrediente;
        this.cantidadDeIngredientes ++;
    }

    public Ingrediente[] getIngredientes() {
        return this.ingredientes;
    }

    public void getIngrediente(Ingrediente ingrediente, int cantidad){
            for (Ingrediente ingredienteList:this.ingredientes) {
                    if (ingredienteList != null && ingredienteList.getNombre().equals(ingrediente.getNombre())){
                        ingredienteList.sacar(cantidad);
                    }

            }
        }

    public Despensa() {
        this.cantidadDeIngredientes=0;
    }

    public Despensa(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }
    @Override
    public String toString(){
        String finalStr = "\n";
        boolean error = true;
        try {
            for (Ingrediente ingredienteList:this.ingredientes) {
                finalStr = finalStr + "\t\t"+ingredienteList.getNombre() + ": " + ingredienteList.getCantidad()+"\n";
                error = true;
            }

        }
        catch (NullPointerException e){
            if (!error){
                System.out.println("No hay ingredientes");
            }
        }

        return finalStr;
    }
}
