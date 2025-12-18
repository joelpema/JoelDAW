package com.examen.simulacro.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "empleados") 
public class empleados {
    
    @Id
  // @GeneratedValue(generator = "uuid") // Le dice a Hibernate que lo genere. x si me da error en el examen
   // @GenericGenerator(name = "uuid", strategy = "uuid2") // Le dice a Hibernate que use UUID.
    private String id = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id", nullable = false)
    private empresas empresas;

    private String nombre;
    private String apellido;
    private Integer edad;

    public empleados() {

    }

        public empleados(empresas empresas, String nombre, String apellido, Integer edad) {
        this.empresas = empresas;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public empresas getEmpresas() {
            return empresas;
        }

        public void setEmpresas(empresas empresas) {
            this.empresas = empresas;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public Integer getEdad() {
            return edad;
        }

        public void setEdad(Integer edad) {
            this.edad = edad;
        }

    
}
