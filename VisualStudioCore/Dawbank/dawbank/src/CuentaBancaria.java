

public class CuentaBancaria {

    private String iban;
    private String titular;
    private double  saldo;
    private Movimiento [] movimientos;
    private int numeroMovimientos = 0;


    public CuentaBancaria (String iban, String titular, int nMovimientos) {
        
        if (!iban.matches("[A-Z]{2}\\d{22}")) {
            
        }
        if (titular.isBlank()) {
            System.out.println("El titular no puede estar vacío");
        }
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
                ingresar(m1);
            }
            else if (m1.getTipo().equalsIgnoreCase("retirada")){
                retirar(m1);
            }
            this.movimientos[numeroMovimientos] = m1;
            this.numeroMovimientos++;
            isAdd = true;
        }
        return isAdd;
    }

    public void ingresar(Movimiento m1){
        
        if (m1.getCantidad() >= 3000.0){
            System.out.println("Cantidad de dinero elevada, por fabvor procesar por hacienda");
        }else if (m1.getCantidad() <= 0 ) {
            System.out.println("debe ser un numero positivo"); 
        }else{ 
            this.saldo = m1.getCantidad(); 
        }
    }

    public void retirar(Movimiento m1){
        if (this.saldo <= -50){
            System.out.println("no puedes tener menos de -50 €");
        }this.saldo = this.saldo - m1.getCantidad();
    }

    public void registrarMovimiento(String tipo, double cantidad){
        if(numeroMovimientos >= 100){
            System.out.println("No se pueden realizar mas movimientos.");
        }
        movimientos[numeroMovimientos] = new Movimiento(tipo,cantidad);
        numeroMovimientos++;
    }

    public void mostrarMovimiento(){
        for (int i = 0; i < numeroMovimientos; i++) {
            movimientos[i].mostrarInfoMovimientos();
        }
    }
}




