package com.Itsqmet.Prestabank.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TASESORES")
public class Asesores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASESORID")
    private Long asesorId;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="CORREO")
    private String correo;

    @Column(name="TELEFONO")
    private String telefono;

    //Relacion de varios a varios con Expedientes
    @OneToMany(mappedBy = "fkAsesor")
    private List<Expedientes> expediente;

    //Getters y setters

    public Long getAsesorId() {
        return asesorId;
    }

    public void setAsesorId(Long asesorId) {
        this.asesorId = asesorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Expedientes> getExpediente() {
        return expediente;
    }

    public void setExpediente(List<Expedientes> expediente) {
        this.expediente = expediente;
    }
}
