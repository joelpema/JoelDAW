import java.util.HashMap;
import java.util.Map;

public class Taller {

    Map<String, Coche > coches = new HashMap<String, Coche>();

    public Taller(){}

    public Taller(Map<String, Coche> coches) {
        this.coches = coches;
    }

    public void aniadirElemento(String color, String marca, String matricula){

        Coche coche = new Coche (color, marca);

        if (coches.containsKey(matricula)){
        System.out.println("La matricula ya esta ingresada");
        }else{
        System.out.println("Coche ingresado correctamente");
        coches.put(matricula, new Coche(color, marca));
        }
    }    

    public void eliminaElemento(String matricula){

        if (coches.containsKey(matricula)) {
            coches.remove(matricula);
            System.out.println("Coche eliminado correctamente.");
        } else {
            System.out.println("Error: No existe un coche con esa matrícula.");
        }
    }

    public void visualizaMatriculas() {
        System.out.println(coches.keySet());
    }

    public void visualizaCoches() {
        for (Coche coche : coches.values()) {
            System.out.println(coche);
        }
    }

    public void visualizaTaller() {
        for (var entry : coches.entrySet()) {
            System.out.println("Matrícula: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}




