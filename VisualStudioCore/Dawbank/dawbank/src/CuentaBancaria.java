

public class CuentaBancaria {

    private String iban;
    private String titular;
    private double  saldo;
    private Movimiento [] movimientos;
    private int numeroMovimientos = 0;


    public CuentaBancaria (String iban, String titular, int nMovimientos) {
        
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0;
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

    public String infoCuentaBancaria(){
        String info = String.format("Cuenta Bancaria- IBAN: %s, Titular: %s, Saldo: %s"
            , this.iban, this.titular, this.saldo);
        return info;
    }

    public boolean insertarMovimiento(Movimiento m1){
        boolean isAdd = false;
        if(m1 != null){

            if(m1.getTipo().equalsIgnoreCase("ingreso")){
                if (m1.getCantidad() >= 3000.0){
                    System.out.println("Cantidad de dinero elevada, por favor procesar por hacienda");
                }else if (m1.getCantidad() <= 0 ) {
                    System.out.println("debe ser un numero positivo"); 
                }else{ 
                    this.saldo += m1.getCantidad(); 
                }
            }
            else if (m1.getTipo().equalsIgnoreCase("retirada")){
                if (this.saldo <= -50){
                    System.out.println("no puedes tener menos de -50 €");
                }else{
                this.saldo = this.saldo - m1.getCantidad();
                }
            }
            this.movimientos[numeroMovimientos] = m1;
            this.numeroMovimientos++;
            isAdd = true;
        }
        return isAdd;
    }
    public String mostrarMovimientos(){
        String result = "";
        if(this.numeroMovimientos > 0){
            for(Movimiento m1 : this.movimientos){
                if(m1 != null){
                    result += m1.mostrarInfoMovimientos() + "\n";
                }
            }
        }
        return result;
    }
}
    




