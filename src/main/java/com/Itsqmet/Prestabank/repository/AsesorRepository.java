package com.Itsqmet.Prestabank.repository;

import com.Itsqmet.Prestabank.models.Asesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesorRepository extends JpaRepository<Asesores, Long> {
}
