package com.Itsqmet.Prestabank.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "TCLIENTES")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClienteID")
    private Long clienteId;

    @Column(name ="CEDULA" , unique = true)
    private String cedula;

    @Column(name ="NOMBRE")
    private String nombre;

    @Column(name ="CORREO")
    private String correo;

    @Column(name ="TELEFONO")
    private String telefono;

    @Column(name ="FNACIMIENTO")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @Column(name ="DIRECCION")
    private String direccion;

    //cardinalidad 1 a varios con Cuenta
    @OneToMany(mappedBy = "fkCliente")
    @JsonManagedReference
    private List<Cuentas> cuentas;

    //cardinalidad variosa varios con Expediente
    @OneToMany(mappedBy = "fkClientes")
    @JsonManagedReference
    private List<Expedientes> expediente;

    //getters and setters

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Expedientes> getExpediente() {
        return expediente;
    }

    public void setExpediente(List<Expedientes> expediente) {
        this.expediente = expediente;
    }
}
