import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class videoDaw {

        private String cif;
        private String direccion;
        private String fechaAlta;
        private int NPeliculas;
        private int NClientes;

        private Cliente [] clientes;
        private Pelicula [] peliculas;
        

        private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:SS");

        public videoDaw(String cif, String direccion){

            this.cif = cif;
            this.direccion= direccion; 
            this.fechaAlta = fechaAlta;
            this.peliculas = new Pelicula[100];
            this.clientes = new Cliente[100];
            this.NPeliculas = 0;
            this.NClientes = 0;
        }

        public String getCif(){
            return this.cif;
        }
        public String getDireccion(){
            return this.direccion;
        }
        public String getFechaAlta(){
            return this.fechaAlta;
        }
        public int getNPeliculas(){
            return this.NPeliculas;
        }
        public int getNClientes(){
            return this.NClientes;
        }

        public int clientesTotales(Cliente nuevo){
            if (nuevo != null){
                this.clientes [NClientes] = nuevo;
                NClientes++;
            }
            return NClientes;
        }
        public int peliculasTotales(Pelicula nueva){
            if (nueva != null){
                this.peliculas [NPeliculas] = nueva;
                NPeliculas++;
            }
            return NPeliculas;
        }

        public String InfoVideoDaw(){
            String InfoVD = String.format("VideoDaw- CIF: %s, Direccion: %s, Fecha de Alta: %s, Numero Peliculas %s, Numero de CLientes: %s",
            this.cif, this.direccion, this.fechaAlta, this.NPeliculas, this.NClientes);
            return InfoVD;
        }

        public String mostrarPeliculasRegistradas(){
            String infoPeliculas = "";
            for (int i = 0; i < NPeliculas; i++){
                infoPeliculas += this.peliculas[i].mostrarInfoPelicula() + "\n";
            }
            return infoPeliculas;
        }

        public String mostrarClientesRegistrados(){
            String infoClientes = "";
            for (int i = 0; i < NClientes; i++){
                infoClientes += this.clientes[i].mostrarInfoCliente() + "\n";
            }
            return infoClientes;
        }

        public String alquilarPelicula(Pelicula p, Cliente c){
            boolean isAll = false;
            if(p.isAlquilada() == false){
                p.PAlquilada();
            }else {
                System.out.println("no puedes escoger una pelicula que ya este cogida, elija de nuevo");
            }
        }
        
        public String darBajaCliente(Cliente c){

            Scanner sc = new Scanner(System.in);

        }

}