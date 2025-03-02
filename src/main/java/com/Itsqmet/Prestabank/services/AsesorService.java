package com.Itsqmet.Prestabank.services;

import com.Itsqmet.Prestabank.models.Asesores;
import com.Itsqmet.Prestabank.repository.AsesorRepository;
import com.Itsqmet.Prestabank.services.crudGenerico.CRUDEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsesorService implements CRUDEntity<Asesores, Long> {
    @Autowired
    private AsesorRepository asesorRepository;


    @Override
    public Asesores create(Asesores entity) {
        return asesorRepository.save(entity);
    }

    @Override
    public Asesores read(Long aLong) {
        return null;
    }

    @Override
    public Asesores update(Asesores entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
