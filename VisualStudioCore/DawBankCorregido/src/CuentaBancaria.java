import java.util.ArrayList;
import java.util.LinkedList;

public class CuentaBancaria {

    private String titular;
    private String iban;
    private double saldo;
    private LinkedList<Movimiento> movimientos = new LinkedList<Movimiento>();

    private int contadorMovimiento = 0;
    
    
    public CuentaBancaria(String titular, String iban) {
        this.titular = titular;
        this.iban = iban;
        this.saldo = 0.0;
        this.movimientos = new LinkedList<Movimiento>();
    }

    public String getTitular() {
        return this.titular;
    }
    public String getIban() {
        return this.iban;
    }
    public double getSaldo() {
        return this.saldo;
    }

    public boolean ingresar(double cantidad){
        boolean isOk = false;
        Movimiento m = new Movimiento(Tipo.Ingreso, cantidad);
        this.saldo = this.saldo + m.getCantidad();
        this.registrarMovimiento();
        isOk = true;
        return isOk;
    }

    public boolean retirar(double cantidad){
        boolean isOk = false;
        if(this.saldo - cantidad > -50){
            Movimiento m = new Movimiento(Tipo.Retirada, cantidad);
            this.saldo = this.saldo - m.getCantidad();
            this.registrarMovimiento();
            isOk = true;
        }
        return isOk;
    }

    public void registrarMovimiento(){
        contadorMovimiento++;
    }

    
    public String mostrarInfoCuentaBancaria(){
        String info = String.format("CuentaBancaria - Titular: %s IBAN: %s Saldo: %s ",this.titular, this.iban, this.saldo) ;
        return info;
    }

    public String mostrarInfoMovimientos(){
        String info = "";
        if(contadorMovimiento > 0){
            for(int i = 0; i < this.contadorMovimiento; i++){
                if(this.movimientos != null) {
                    info += this.movimientos.toString() + "\n";
                }
            }
        }else{
            info = "No hay movimientos en esta cuenta";
        }

        return info;
    }

}