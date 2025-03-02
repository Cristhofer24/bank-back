package com.Itsqmet.Prestabank.services;

import com.Itsqmet.Prestabank.models.Expedientes;
import com.Itsqmet.Prestabank.repository.ExpedienteRepository;
import com.Itsqmet.Prestabank.services.crudGenerico.CRUDEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpedienteService implements CRUDEntity<Expedientes, Long> {
    @Autowired
    ExpedienteRepository expedienteRepository;

    @Override
    public Expedientes create(Expedientes entity) {
        return expedienteRepository.save(entity);
    }

    @Override
    public Expedientes read(Long aLong) {
        return null;
    }

    @Override
    public Expedientes update(Expedientes entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
