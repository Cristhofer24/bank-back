package com.Itsqmet.Prestabank.repository;

import com.Itsqmet.Prestabank.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {
}
