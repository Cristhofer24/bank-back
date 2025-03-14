package com.Itsqmet.Prestabank.repository;

import com.Itsqmet.Prestabank.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {
    Usuarios findByUsername(@Param("username") String username);
}
