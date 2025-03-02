package com.Itsqmet.Prestabank.services;

import com.Itsqmet.Prestabank.exceptions.MovimientoExceptions;
import com.Itsqmet.Prestabank.models.Cuentas;
import com.Itsqmet.Prestabank.models.Movimientos;
import com.Itsqmet.Prestabank.repository.CuentaRepository;
import com.Itsqmet.Prestabank.repository.MovimientoRepository;
import com.Itsqmet.Prestabank.services.crudGenerico.CRUDEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class MovimientoService implements CRUDEntity<Movimientos,Long> {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public Movimientos create(Movimientos entity) {
        Cuentas cuentaOrigen = cuentaRepository.findByNumeroCuenta(entity.getCuentaOrigen());
        Cuentas cuentaDestino = cuentaRepository.findByNumeroCuenta(entity.getCuentaDestino());
       if(entity.getMonto().compareTo(BigDecimal.ZERO)<=0){
           throw new MovimientoExceptions("El monto debe ser mayor a 0");
       }

       if(cuentaOrigen==null){
           throw new MovimientoExceptions("La cuenta origen no existe");
       }

       if("DEPOSITO".equalsIgnoreCase(entity.getTipoMovimiento())){
           cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().add(entity.getMonto()));
           entity.setCuentaDestino(cuentaOrigen.getNumeroCuenta());
       }

       if("RETIRO".equalsIgnoreCase(entity.getTipoMovimiento())){
           if(cuentaOrigen.getSaldo().compareTo(entity.getMonto())<0){
               throw new MovimientoExceptions("El monto es mayor al saldo de la cuenta");
           }
           cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(entity.getMonto()));
           entity.setCuentaDestino(cuentaOrigen.getNumeroCuenta());
       }

       if("TRANSFERENCIA".equalsIgnoreCase(entity.getTipoMovimiento())){

           if (cuentaDestino == null) {
               throw new MovimientoExceptions("La cuenta destino no existe");
           }

           if(cuentaOrigen.getSaldo().compareTo(entity.getMonto())<0){
               throw new MovimientoExceptions("El monto es mayor al saldo de la cuenta");
           }
           cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(entity.getMonto()));
           cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(entity.getMonto()));
           entity.setCuentaDestino(cuentaDestino.getNumeroCuenta());
       }

       if ("PAGO".equalsIgnoreCase(entity.getTipoMovimiento())) {
           if (cuentaOrigen.getSaldo().compareTo(entity.getMonto()) < 0) {
               throw new MovimientoExceptions("El monto es mayor al saldo de la cuenta");
           }
           cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(entity.getMonto()));
           entity.setCuentaDestino(cuentaOrigen.getNumeroCuenta());
       }

       cuentaRepository.save(cuentaOrigen);
       entity.setFechaMovimiento(LocalDate.now());
       entity.setFkCuenta(cuentaOrigen);

        return movimientoRepository.save(entity);
    }

    @Override
    public Movimientos read(Long aLong) {
        return null;
    }

    @Override
    public Movimientos update(Movimientos entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
