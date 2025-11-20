package com.example.morosos_app.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.math.BigDecimal;

public class Moroso {

    private int id;
    private String nombre;
    private String dni;
    private double cantidad_adeudada;
    private Date fecha_alta;
    private EstadoPago estado_pago;

    public Moroso() {

    }

    public Moroso(int id, String nombre, String dni, double cantidad_adeudada, Date fecha_alta, EstadoPago estado_pago) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.cantidad_adeudada = cantidad_adeudada;
        this.fecha_alta = fecha_alta;
        this.estado_pago = estado_pago;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public double getCantidadAdeudada() { return cantidad_adeudada; }
    public void setCantidadAdeudada(double cantidad_adeudada) { this.cantidad_adeudada = cantidad_adeudada; }

    public Date getFechaAlta() { return fecha_alta; }
    public void setFechaAlta(Date fecha_alta) { this.fecha_alta = fecha_alta; }

    public EstadoPago getEstadoPago() { return estado_pago; }
    public void setEstadoPago(EstadoPago estado_pago) { this.estado_pago = estado_pago; }



    

    public void setEstado(String nuevoEstado) {
        this.estado_pago = EstadoPago.valueOf(nuevoEstado);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Moroso{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", dni=").append(dni);
        sb.append(", cantidad_adeudada=").append(cantidad_adeudada);
        sb.append(", fecha_alta=").append(fecha_alta);
        sb.append(", estado_pago=").append(estado_pago);
        sb.append('}');
        return sb.toString();
    }
}
