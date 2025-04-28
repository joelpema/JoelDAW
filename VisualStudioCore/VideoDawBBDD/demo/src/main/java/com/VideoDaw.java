package com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.LinkedList;

public class VideoDaw {

    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private LinkedList <Articulo> articulosRegistrados;
    private LinkedList <Cliente> clientesRegistrados;


    public VideoDaw(String cif, String direccion, LocalDate fechaAlta, LinkedList<Articulo> articulosRegistrados,
            LinkedList<Cliente> clientesRegistrados) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.articulosRegistrados = new LinkedList<>();
        this.clientesRegistrados = new LinkedList<>();
    }

    public String getCif() {
        return cif;
    }
    public String getDireccion() {
        return direccion;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public LinkedList<Articulo> getArticulosRegistrados() {
        return articulosRegistrados;
    }
    public LinkedList<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoDaw: ");
        sb.append("cif: ").append(cif);
        sb.append(", direccion: ").append(direccion);
        sb.append(", fechaAlta: ").append(fechaAlta);
        sb.append(", articulosRegistrados: ").append(articulosRegistrados);
        sb.append(", clientesRegistrados: ").append(clientesRegistrados);
        sb.append('.');
        return sb.toString();
    }


    public String alquilarArticulo(int cod, int codSocio) throws ArticuloYaAlquiladoException{
        Articulo articulo = null;
        Cliente cliente = null;
        for (Articulo a : articulosRegistrados) {
            if(a.getCod() == cod){
                articulo = a;
            }
        }
        for (Cliente c : clientesRegistrados) {
            if(c.getCodSocio()==codSocio){
                cliente = c;
            }
        }
        if(articulo == null){
            return "El articulo no existe";
        }
        if(cliente == null){
            return "El cliente no existe";
        }
        if(articulo instanceof Pelicula && ((Pelicula) articulo).isAlquilada()){
            throw new ArticuloYaAlquiladoException("El artículo ya está alquilado.");
        } else if(articulo instanceof Videojuego && ((Videojuego) articulo).isAlquilada()){
            throw new ArticuloYaAlquiladoException("El artículo ya está alquilado.");
        }
        LocalDateTime fechaAlquiler = LocalDateTime.now();
        if (articulo instanceof Pelicula) {
            ((Pelicula) articulo).setFechaAlquiler(fechaAlta);
            ((Pelicula) articulo).setAlquilada(true);
        } else if (articulo instanceof Videojuego) {
            ((Videojuego) articulo).setFechaAlquilada(fechaAlta);
            ((Videojuego) articulo).setAlquilada(true);
        }
        cliente.agregarArticuloAlquilado(articulo);
        return "Artículo alquilado exitosamente a " + cliente.getNombre();
        }


        public String devolverArticulo(int cod, int codSocio) throws TiempoExcedidoException{
                Articulo articulo = null;
                Cliente cliente = null;
                for (Articulo a : articulosRegistrados) {
                    if(a.getCod()==cod){
                        articulo = a;
                    }
                }
                for (Cliente c : clientesRegistrados) {
                    if(c.getCodSocio()==codSocio){
                        cliente = c;
                    }
                }
                if(articulo == null){
                    return "El articulo no existe";
                }
                if(cliente == null){
                    return "El cliente no existe";
                }

                LocalDateTime fechaDevolucion = LocalDateTime.now();
                if (articulo instanceof Pelicula) {
                    if (!((Pelicula) articulo).isAlquilada()) {
                        return "El artículo no está alquilado";
                    }
                    Period dias = Period.between(((Pelicula) articulo).getFechaAlquiler(), fechaDevolucion.toLocalDate());
                    if(dias.getDays() >= 2){
                        throw new TiempoExcedidoException("Tiempo de alquiler excedido");
                    }
                    ((Pelicula) articulo).setAlquilada(false);
                    ((Pelicula) articulo).setFechaAlquiler(null);
                } else if (articulo instanceof Videojuego) {
                    if (!((Videojuego) articulo).isAlquilada()) {
                        return "El artículo no está alquilado";
                    }
                    Period dias = Period.between(((Videojuego) articulo).getFechaAlquilada(), fechaDevolucion.toLocalDate());
                    if(dias.getDays() >= 2){
                        throw new TiempoExcedidoException("Tiempo de alquiler excedido");
                    }
                    ((Videojuego) articulo).setAlquilada(false);
                    ((Videojuego) articulo).setFechaAlquilada(null);
                }
                cliente.eliminarArticuloAlquilado(articulo);
                return "Artículo devuelto exitosamente por " + cliente.getNombre();
            }
}
