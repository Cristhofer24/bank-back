package com.Itsqmet.Prestabank.services;

import com.Itsqmet.Prestabank.exceptions.CuentaException;
import com.Itsqmet.Prestabank.models.Clientes;
import com.Itsqmet.Prestabank.models.Cuentas;
import com.Itsqmet.Prestabank.repository.CuentaRepository;
import com.Itsqmet.Prestabank.services.components.NumeroCuentaAleatorio;
import com.Itsqmet.Prestabank.services.crudGenerico.CRUDEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class CuentaService implements CRUDEntity<Cuentas, Long> {
    @Autowired
    private CuentaRepository cuentarepository;
    @Autowired
    private ClienteService clienteservice;
    @Autowired
    private NumeroCuentaAleatorio numeroCuentaAleatorio;


    @Override
    public Cuentas create(Cuentas cuentas) {
        if (cuentarepository.findByNumeroCuenta(cuentas.getNumeroCuenta()) != null) {
            throw new CuentaException("El número de cuenta ya existe");
        }

        if (cuentas.getFkCliente() == null || cuentas.getFkCliente().getClienteId() == null) {
            throw new CuentaException("La cuenta debe tener un cliente asociado");
        }
        // Buscar cliente en la base de datos
        Clientes cliente = clienteservice.read(cuentas.getFkCliente().getClienteId());
        // Asignar el cliente persistente a la cuenta
        cuentas.setFkCliente(cliente);
        cuentas.setNumeroCuenta(numeroCuentaAleatorio.generarNumeroCuentaAleatoria(cuentas.getTipoCuenta()));
        cuentas.setFechaApertura(LocalDate.now());
        cuentas.setFechaCaducidad(LocalDate.now().plusYears(3));
        cuentas.setEstado("ACTIVO");
        return cuentarepository.save(cuentas);
    }

    @Override
    public Cuentas read(Long id) {
        return cuentarepository.findById(id).orElse(null);
    }

    public List<Cuentas> getAllCuentas() {
        return cuentarepository.findAll();
    }

    @Override
    public Cuentas update(Cuentas cuentas) {
        return cuentarepository.save(cuentas);
    }

    @Override
    public void delete(Long id) {
        cuentarepository.deleteById(id);
    }

}
