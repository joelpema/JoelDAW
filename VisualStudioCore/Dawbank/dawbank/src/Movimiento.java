
import java.time.LocalDateTime;

public class Movimiento {

    private static int contador = 0;

    private int id;
    private String fecha;
    private boolean tipo;
    private double cantidad;
    private String mostrarInfoMovimiento;


public Movimiento(boolean tipo, double cantidad){

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
public boolean  getTipo(){
    return this.tipo;
}
public double  getCantidad(){
    return this.cantidad;
}

public String mostrarInfoMovimientos(){

String info = String.format("Movimientos - ID: %s, Fecha: %s , Tipo ingreso/Retirada: %s, Cantidad: %s"
            , this.id, this.fecha, this.tipo, this.cantidad);
        return info;
} 



}   
