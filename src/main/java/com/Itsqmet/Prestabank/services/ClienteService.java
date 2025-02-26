package com.Itsqmet.Prestabank.services;

import com.Itsqmet.Prestabank.exceptions.ClienteExceptions;
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

       if (repository.findByCedula(clientes.getCedula()) != null){
           throw new ClienteExceptions("El cliente con cedula " + clientes.getCedula() + " ya existe");
       }
    return repository.save(clientes);
    }

    @Override
    public Clientes read(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClienteExceptions("Cliente no encontrado"));
    }

    public List<Clientes> getAllClientes(){
        return repository.findAll();
    }

    @Override
    public Clientes update(Clientes clientes) {
        return repository.save(clientes);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new ClienteExceptions("Cliente no encontrado");
        }
        repository.deleteById(id);
    }



}
