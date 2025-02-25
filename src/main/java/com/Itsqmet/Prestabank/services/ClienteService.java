package com.Itsqmet.Prestabank.services;

import com.Itsqmet.Prestabank.models.Clientes;
import com.Itsqmet.Prestabank.repository.ClienteRepository;
import com.Itsqmet.Prestabank.services.crudGenerico.CRUDEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements CRUDEntity<Clientes, Long> {
    @Autowired
    private ClienteRepository repository;


    @Override
    public Clientes create(Clientes clientes) {
    return repository.save(clientes);
    }

    @Override
    public Clientes read(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public List<Clientes> getAllClientes(){
        return repository.findAll();
    }

    @Override
    public Clientes update(Clientes clientes) {
        if (!repository.existsById(clientes.getClienteId())){
            throw new RuntimeException("Cliente no encontrado");
        }
        return repository.save(clientes);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("Cliente no encontrado");
        }
        repository.deleteById(id);
    }



}
