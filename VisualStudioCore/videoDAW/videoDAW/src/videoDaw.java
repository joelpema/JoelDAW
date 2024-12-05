import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        public int clientesAdd(Cliente nuevo){
            if (nuevo != null){
                this.clientes [NClientes] = nuevo;
                NClientes++;
            }
            return NClientes;
        }
        public int peliculasAdd(Pelicula nueva){
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

        public void mostrarPeliculasRegistradas(){
            String infoPeliculas = "";
            for (int i = 0; i < NPeliculas; i++){
                infoPeliculas += this.peliculas[i].mostrarInfoPelicula() + "\n";
            }
        }

        public void mostrarClientesRegistrados(){
            String infoClientes = "";
            for (int i = 0; i < NClientes; i++){
                infoClientes += this.clientes[i].mostrarInfoCliente() + "\n";
            }
            
        }

        public String MostrarPeliculasNoAlquiladas(videoDaw a){
            String PeliculasNoAlquiladas = "";
            if(a.NPeliculas > 0){
                for(int i = 0; i < NPeliculas; i++){
                    if(peliculas[i].isAlquilada() == false)
                     PeliculasNoAlquiladas += (peliculas[i].mostrarInfoPelicula());
                }
            }else {
                PeliculasNoAlquiladas = "no hay peliculas aun, vuelva mas tarde";
            }
            return PeliculasNoAlquiladas;
        }

    
        public Pelicula posicionPelicula(int i){
            return this.peliculas[i];
        }

        public Cliente posicionCliente(int i){
            return this.clientes[i];
        }

        public boolean alquilarPelicula(int c, int p){
            this.posicionCliente(c);
            this.posicionPelicula(p).Alquilado();
            boolean isEliminada = false;
            return isEliminada;
        }    

        public boolean  darBajaCliente(int c, int nS){
            boolean isEliminada = false;
                if(this.clientes != null){
            this.clientes [nS] = null;
            LocalDate fechaBajaCliente = posicionCliente(c)(nS).baja();
            for(int i = nS + 1; i < nclientes; i++){
                this.clientes [i-1] = this.clientes[i];
            }
            this.clientes [nclientes-1] = null;
            nclientes--;
            isEliminated = true;
            System.out.println("Cliente eliminado");
            posicionCliente(c)(nS).InfoCliente();
            System.out.println("Fecha de baja: " + fechaBajaCliente);
        }
        }



}