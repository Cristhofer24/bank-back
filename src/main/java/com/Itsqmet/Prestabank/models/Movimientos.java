package com.Itsqmet.Prestabank.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "TMOVIMIENTOS")
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIMIENTOID")
    private Long movimientoId;

    @Column(name = "TIPOMOVIMIENTO")
    private String tipoMovimiento;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "FMOVIMIENTO")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaMovimiento;

    @Column(name = "CUENTAORIGEN")
    private String cuentaOrigen;

    @Column(name = "CUENTADESTINO")
    private String cuentaDestino ;


    @ManyToOne
    @JoinColumn(name = "FK_CUENTA" , nullable = false)
    private Cuentas fkCuenta;

    //Getters and Setters


    public Long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(Long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public LocalDate getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDate fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Cuentas getFkCuenta() {
        return fkCuenta;
    }

    public void setFkCuenta(Cuentas fkCuenta) {
        this.fkCuenta = fkCuenta;
    }
}
