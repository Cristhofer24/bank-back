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

    @Query(value = "select " +
            "tc.numerocuenta," +  //index 0
            "tcl.nombre," +   //index 1
            "tc.fcaducidad ," + //index 2
            "tcl.cedula," +  //index 3
            "tc.saldo," + //index 4
            "tc.tipocuenta " + //index 5
            "from tcuentas tc join " +
            "tclientes tcl on tcl.clienteid = tc.fk_cliente " +
            "where tcl.clienteid= :id " +
            "ORDER BY tc.fapertura DESC limit 1", nativeQuery = true)
    List<Object[]> EncontrarCuentaReciente(@Param("id") Long id);



}
