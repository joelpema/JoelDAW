package com.example.morosos_app.entidad;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class MorosoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String nombre;
    @Column(nullable = false)
    String dni;

    @Column(nullable = false)
    double cantidad_adeudada;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    LocalDateTime fecha;

    @Column(nullable = false)
    double importe_total;

    @Column(nullable = false)
    EstadoPago estado_pago;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (long) id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getCantidadAdeudada() {
        return cantidad_adeudada;
    }

    public void setCantidadAdeudada(double cantidad_adeudada) {
        this.cantidad_adeudada = cantidad_adeudada;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFechaAlta(Date fecha_alta, LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    public EstadoPago getEstadoPago() {
        return estado_pago;
    }

    public void setEstadoPago(EstadoPago estado_pago) {
        this.estado_pago = estado_pago;
    }

    public enum EstadoPago {
        PENDIENTE,
        PAGADO
    }
}
