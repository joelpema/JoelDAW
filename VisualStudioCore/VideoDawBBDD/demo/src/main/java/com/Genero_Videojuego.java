package com;

public class Genero_Videojuego {

    private int id;
    private String genero;

    
    public Genero_Videojuego(int id, String genero) {
        this.id = id;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    @Override
    public String toString() {
        return "Genero_Videojuego [id=" + id + ", genero=" + genero + "]";
    }

    


}
