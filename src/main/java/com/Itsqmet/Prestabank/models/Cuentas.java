package com.Itsqmet.Prestabank.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TCUENTAS")
public class Cuentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUENTAID")
    private Long cuentaId;

    @Column(name = "TIPOCUENTA")
    private String tipoCuenta;

    @Column(name = "NUEMROCUENTA", unique = true)
    private String numeroCuenta;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    @Column(name = "FAPERTURA")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaApertura;

    @Column(name = "FCADUCIDAD")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCaducidad;

    @Column(name = "ESTADO")
    private String estado;

    //Cardinalidad con la entidad Cliente, R=1-n

    @ManyToOne
    @JoinColumn(name = "FK_CLIENTE")
    private Clientes fkCliente;

    //Cardinalidad con la entidad Movimientos, R=1-n
    @OneToMany(mappedBy = "fkCuenta")
    private List<Movimientos> movimientos;

    //getters y setters


    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public List<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public Clientes getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Clientes fkCliente) {
        this.fkCliente = fkCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }


}
