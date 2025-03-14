package com.Itsqmet.Prestabank.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="TEXPEDIENTES")
public class Expedientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEXPEDIENTEID")
    private Long expedienteId;

    @Column(name = "DESCRIPCION")
    private String descripcion;


    //relacion de muchos a muchos con cliente y ascesor
    @ManyToOne
    @JoinColumn(name = "FK_CLIENTE")
    @JsonBackReference
    private Clientes fkClientes;

    @ManyToOne
    @JoinColumn(name = "FK_ASESOR")
    @JsonBackReference
    private Asesores fkAsesor;

    //getters y setters

    public Long getExpedienteId() {
        return expedienteId;
    }

    public void setExpedienteId(Long expedienteId) {
        this.expedienteId = expedienteId;
    }

    public Clientes getFkClientes() {
        return fkClientes;
    }

    public void setFkClientes(Clientes fkClientes) {
        this.fkClientes = fkClientes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Asesores getFkAsesor() {
        return fkAsesor;
    }

    public void setFkAsesor(Asesores fkAsesor) {
        this.fkAsesor = fkAsesor;
    }
}
