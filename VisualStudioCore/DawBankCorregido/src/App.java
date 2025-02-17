import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a DawBank tu banco de confianza je je je");
        

        final String patronIban = "[A-Z]{2}[0-9]{22}";
        String iban = "";
        String nombre = "";
        String telefono = "";
        String dni = "";
        LocalDate fechaNacimiento = null;
        String email = "";
        String direccion = "";

        try{
        iban = MiUtils.comprobarPatronRepetidamente(patronIban, "Introduzca el IBAN");
        nombre = MiUtils.leerTextoPantalla("introduce el nombre del cliente");
        telefono = MiUtils.leerTextoPantalla("introduce el numero de telefono");
        dni = MiUtils.leerTextoPantalla("introduce el DNI");
        fechaNacimiento = MiUtils.leerFecha("introduce la fecha del cliente");
        email = MiUtils.leerTextoPantalla("introduce el gmail del cliente");
        direccion = MiUtils.leerTextoPantalla("Escribe la direccion del cliente");
        }catch (CuentaExcepcion e) {
            System.out.println(e.getMessage());
        }

        Cliente nuevoCliente = new Cliente(nombre, dni, fechaNacimiento, telefono, email, direccion);
        CuentaBancaria miCuenta = new CuentaBancaria(nuevoCliente, iban);

        String opcion = "";
        Scanner reader;
        do {
            reader = new Scanner(System.in);
            
            imprimirMenuOpciones();

            opcion = reader.nextLine();
            menuBanca(miCuenta, opcion, nuevoCliente);


        } while (!opcion.equalsIgnoreCase("8"));
    }

    private static void imprimirMenuOpciones() {
        System.out.println("Escoga la opcion que desee");
        System.out.println("1. Datos de la cuenta");
        System.out.println("2. IBAN");
        System.out.println("3. Titular");
        System.out.println("4. Saldo");
        System.out.println("5. Ingreso");
        System.out.println("6. Retirada");
        System.out.println("7. Movimientos");
        System.out.println("8. Salir");
    }

    private static void menuBanca(CuentaBancaria miCuenta, String opcion, Cliente nuevoCliente) {
        switch (opcion) {
            case "1":
                System.out.println(nuevoCliente.toString() + miCuenta.toString());
                break;

            case "2":
                System.out.println(miCuenta.getIban());
                break;

            case "3":
                System.out.println(miCuenta.getTitular());
                break;
            case "4":
                System.out.println(miCuenta.getSaldo());
                break;

            case "5":
                try {
                    double cantidad = MiUtils.leerDoublePantalla("Introduzca la cantidad a ingresar");
                    miCuenta.ingreso(cantidad);
                }catch (AvisarHaciendaException e) {
                    System.out.println(e.getMessage());
                }

                break;

            case "6":
                try{
                    double cantidadR = MiUtils.leerDoublePantalla("Introduzca la cantidad a retirar");
                    miCuenta.retirada(cantidadR);
                }catch (AvisarHaciendaException e) {
                    System.out.println(e.getMessage());
                }

                break;

            case "7":
                System.out.println(miCuenta.mostrarInfoMovimientos());
                break;
            case "8":
                System.out.println("Se cerrara el programa. Sayonra baby!!!");
                break;

            default:
                System.out.println("Opcion incorrecta, vuelva a escoger");
        }
    }
}


