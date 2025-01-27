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

        if (matricula.contains(matricula)){
        this.coches.put(matricula, coche);
        }else if (matricula == matricula){
            System.out.println("la matricula ya existe");
        }

    }

}
