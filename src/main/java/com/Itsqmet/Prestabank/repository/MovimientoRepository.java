package com.Itsqmet.Prestabank.repository;

import com.Itsqmet.Prestabank.models.Cuentas;
import com.Itsqmet.Prestabank.models.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimientos, Long> {
    //Buscar Movimientos por el id de la cuenta
    @Query(value = "select " +
            "tm.descripcion," +
            "tm.monto, " +
            "tm.fmovimiento " +
            "from tmovimientos tm " +
            "where tm.fk_cuenta=:id " +
            "ORDER BY tm.movimientoid  DESC",nativeQuery = true)
    List<Object[]> obtenerMovimientosporfk(@Param("id") Long id);

    @Query(value = "select " +
            "tm.descripcion," +
            "tm.monto, " +
            "tm.fmovimiento " +
            "from tmovimientos tm " +
            "where tm.fk_cuenta=:id " +
            "ORDER BY tm.descripcion  DESC limit 1",nativeQuery = true)
    List<Object[]> obtenerMovimientosreciente(@Param("id") Long id);



}
