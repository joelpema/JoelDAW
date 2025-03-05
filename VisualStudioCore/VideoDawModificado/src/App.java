import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VideoDaw videoclub = null;

        while (true) {
            System.out.println("\nMenú Principal");
            System.out.println("1. Crear y registrar VideoClub en la franquicia.");
            System.out.println("2. Registrar película en videoclub.");
            System.out.println("3. Crear y registrar cliente en videoclub.");
            System.out.println("4. Alquilar.");
            System.out.println("5. Devolver.");
            System.out.println("6. Dar de baja cliente.");
            System.out.println("7. Dar de baja artículo.");
            System.out.println("8. Salir.");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el CIF del videoclub: ");
                    String cif = sc.nextLine();
                    System.out.print("Ingrese la dirección del videoclub: ");
                    String direccion = sc.nextLine();
                    videoclub = new VideoDaw(cif, direccion);
                    System.out.println("Videoclub registrado exitosamente.");
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no implementada aún.");
            }
        }
    }
}
