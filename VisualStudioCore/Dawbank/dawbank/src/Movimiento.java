
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private static int contador = 0;

    private int id;
    private String fecha;
    private String tipo;
    private double cantidad;

     private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");

public Movimiento(String tipo, double cantidad){

    this.id = contador;
    this.contador++;
    
    this.fecha = LocalDateTime.now().toString();
    this.tipo = tipo;
    this.cantidad = cantidad;
}
public int getId(){
    return this.id;
}
public String getTecha(){
    return this.fecha;
}
public String  getTipo(){
    return this.tipo;
}
public double  getCantidad(){
    return this.cantidad;
}

public String mostrarInfoMovimientos(){
    String infoMovi = String.format("Movimientos - ID: %s, Fecha: %s , Tipo (ingrso o retirada): %s, Cantidad: %s"
                , this.id, this.fecha, this.tipo, this.cantidad);
            return infoMovi;
    }

}