package com.Itsqmet.Prestabank.repository;

import com.Itsqmet.Prestabank.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {
    Clientes findByCedula(@Param("cedula") String cedula);

    @Query(value = "SELECT " +
            "tc.numerocuenta, " +  // Index 0
            "tcl.nombre, " +   // Index 1
            "tc.fcaducidad, " + // Index 2
            "tcl.cedula, " +  // Index 3
            "tc.saldo, " + // Index 4
            "tc.tipocuenta, " +// Index 5
            "tcl.clienteid, " +// Index 6
            "tc.cuentaid " +//7
            "FROM tcuentas tc " +
            "JOIN tclientes tcl ON tcl.clienteid = tc.fk_cliente " +
            "WHERE tcl.clienteid = :id " +
            "ORDER BY tc.fapertura DESC " +
            "LIMIT 1", nativeQuery = true)
    List<Object[]> EncontrarCuentaReciente(@Param("id") Long id);



    @Query(value = "SELECT " +
            "tc.numerocuenta, " + //0
            "tcl.nombre, " +  //1
            "tc.fcaducidad, " +  //2
            "tcl.cedula, " + //3
            "tc.saldo, " + //4
            "tc.tipocuenta, " +  //5
            "tcl.clienteid, " + //6
            "tc.cuentaid " +//7
            "FROM tcuentas tc " +
            "JOIN tclientes tcl ON tcl.clienteid = tc.fk_cliente " +
            "WHERE tcl.clienteid = :id", nativeQuery = true)
    List<Object[]> EncontrarCuentasporId(@Param("id") Long id);



}
