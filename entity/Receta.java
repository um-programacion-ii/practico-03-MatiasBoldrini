package entity;

public class Receta {
    private int tiempoCoccion;
    private Ingrediente[] ingredientes = new Ingrediente[2];
    private String preparacion;

    public Receta() {
    }

    public Receta(int tiempoCoccion, Ingrediente[] ingredientes, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
    public String getIngredientesNames(){
        String finalStr = "";
        for (Ingrediente ingredienteList: this.ingredientes) {
            if(ingredienteList != null){

            finalStr += ingredienteList.getCantidad() + " " + ingredienteList.getNombre()+", ";
            }
        }
        return finalStr;
    }
    @Override
    public String toString(){
        String finalStr = this.getClass().getSimpleName() + "\n";
        finalStr += "\tTiempo de cocción: " + this.tiempoCoccion+ " minutos \n";
        finalStr += "\tIngredientes: " + this.getIngredientesNames() + "\n";
        finalStr += "\tInstrucciones: " +this.preparacion;
        return finalStr;
    }

}
