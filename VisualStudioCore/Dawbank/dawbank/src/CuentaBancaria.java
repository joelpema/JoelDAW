

public class CuentaBancaria {

    private String iban;
    private String titular;
    private double  saldo;
    private double  ingreso;
    private double  retirada;
    private Movimiento [] movimientos;
    private int numeroMovimientos;


    public CuentaBancaria (String iban, String titular, double  saldo, double  ingreso, double  retirada, int nMovimientos) {
        
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
        this.ingreso = ingreso;
        this.retirada = retirada;
        this.movimientos = new Movimiento[nMovimientos];
        this.numeroMovimientos = 0;
                
    }

    public String getIban(){
        return this.iban;
    }
    public String getTitular(){
        return this.titular;
    }
    public double   getSaldo(){
        return this.saldo;
    }
    public double  getRetirada(){
        return this.retirada;
    }
    public double  getIngreso(){
        return this.ingreso;
    }

    
    public boolean insertarMovimiento(Movimiento m1){
        boolean isAdd = false;
        if(m1 != null){
            this.movimientos[numeroMovimientos] = m1;
            this.numeroMovimientos++;
            isAdd = true;
        }
        return isAdd;
        
    }

    public String infoCuentaBancaria(){
        //Metodo para realizar interpolacion en los strings en java
        String info = String.format("Bibilioteca - Nombre: %s, Direccion: %s , Email: %s, Numero telefono: %s"
            , this.iban, this.titular, this.saldo, this.ingreso, this.retirada);
        return info;
    }


    
}

