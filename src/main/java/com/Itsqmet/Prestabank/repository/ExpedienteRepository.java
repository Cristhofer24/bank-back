package com.Itsqmet.Prestabank.repository;

import com.Itsqmet.Prestabank.models.Expedientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedienteRepository extends JpaRepository<Expedientes, Long> {
}
