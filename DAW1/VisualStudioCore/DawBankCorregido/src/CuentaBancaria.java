import java.util.ArrayList;
import java.util.LinkedList;

public class CuentaBancaria {

    private Cliente nuevoCliente;
    private String iban;
    private double saldo;
    private LinkedList<Movimiento> movimientos = new LinkedList<Movimiento>();

    private int contadorMovimiento = 0;
    
    public CuentaBancaria(Cliente nuevoCliente, String iban) {
        this.nuevoCliente = nuevoCliente;
        this.iban = iban;
        this.saldo = 0.0;
        this.movimientos = new LinkedList<Movimiento>();
    }

    public Cliente getTitular() {
        return this.nuevoCliente;
    }
    public String getIban() {
        return this.iban;
    }
    public double getSaldo() {
        return this.saldo;
    }

    public void ingreso(double cantidad) throws AvisarHaciendaException{
        saldo += cantidad;
        registrarMovimiento(Tipo.Ingreso, cantidad);
        if(cantidad <= 0){
            throw new AvisarHaciendaException("Error, debe ser mayor que 0");
        }else if(cantidad >= 3000){
            throw new AvisarHaciendaException("Error, no debe ser mayor que 3000, notificando a hacienda");
        }
    }

    public void retirada(double cantidad) throws AvisarHaciendaException{
        if(cantidad <= 0){
            throw new AvisarHaciendaException("Error, debe ser mayor que 0");
        }else if(cantidad >= 3000){
            throw new AvisarHaciendaException("Error, no debe ser mayor que 3000, notificando a hacienda");
        }else if((saldo-cantidad) < -50){
            throw new AvisarHaciendaException("Error, El saldo minimo disponible es 50");
        }
        saldo-=cantidad;
        registrarMovimiento(Tipo.Retirada, cantidad);
    }

    public void registrarMovimiento(Tipo tipo, double cantidad){
        Movimiento m = new Movimiento(tipo, cantidad);
        movimientos.add(m);
        contadorMovimiento++;
    }

    public String mostrarInfoMovimientos(){
        String info = "";
        if (contadorMovimiento != 0){
        for (Movimiento movimiento : movimientos) {
            info += movimiento.toString();
        }
        }else{
            info = "No hay movimientos en esta cuenta";
        }

        return info;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Iban=").append(iban);
        sb.append(", Saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
}