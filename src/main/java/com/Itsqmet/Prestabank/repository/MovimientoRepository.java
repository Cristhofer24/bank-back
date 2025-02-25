package com.Itsqmet.Prestabank.repository;

import com.Itsqmet.Prestabank.models.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimientos, Long> {
}
