package com.decroly.demo;

import java.io.Serializable;

public class Tipo implements Serializable {

    private static final long serialVersionUID = 4353320087058390091L;

    private String tipo;
    private int id;

    public Tipo(String tipo, int id) {
        this.tipo = tipo;
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tipo{" + tipo + '}';
    }
}
