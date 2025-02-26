package com.Itsqmet.Prestabank.repository;

import com.Itsqmet.Prestabank.models.Cuentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository <Cuentas, Long> {
     Cuentas findByNumeroCuenta(@Param("numeroCuenta") String numeroCuenta);
}
