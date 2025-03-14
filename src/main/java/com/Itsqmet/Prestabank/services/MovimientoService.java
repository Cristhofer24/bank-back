package com.Itsqmet.Prestabank.services;

import com.Itsqmet.Prestabank.exceptions.MovimientoExceptions;
import com.Itsqmet.Prestabank.models.Cuentas;
import com.Itsqmet.Prestabank.models.DTOClienteCuenta;
import com.Itsqmet.Prestabank.models.Movimientos;
import com.Itsqmet.Prestabank.repository.CuentaRepository;
import com.Itsqmet.Prestabank.repository.MovimientoRepository;
import com.Itsqmet.Prestabank.services.crudGenerico.CRUDEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
       if( entity.getMonto() == null || entity.getMonto().compareTo(BigDecimal.ZERO)<=0){
           throw new MovimientoExceptions("El monto debe ser mayor a 0");
       }

       if(cuentaOrigen==null){
           throw new MovimientoExceptions("La cuenta origen no existe");
       }

       if("DEPOSITO".equalsIgnoreCase(entity.getTipoMovimiento())){
           cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().add(entity.getMonto()));
           entity.setCuentaDestino(cuentaOrigen.getNumeroCuenta());
           entity.setDescripcion("Deposito satisfactorio");
       }

       if("RETIRO".equalsIgnoreCase(entity.getTipoMovimiento())){
           if(cuentaOrigen.getSaldo().compareTo(entity.getMonto())<0){
               throw new MovimientoExceptions("El monto es mayor al saldo de la cuenta");
           }
           cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(entity.getMonto()));
           entity.setCuentaDestino(cuentaOrigen.getNumeroCuenta());
           entity.setDescripcion("Retiro satisfactorio");
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

       if ("PAGOS".equalsIgnoreCase(entity.getTipoMovimiento())) {
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

    public List<Movimientos> obtenerTodosMovimietos(Long id){
        List<Object[]> obtm = movimientoRepository.obtenerMovimientosporfk(id);
        return obtm.stream().map(this::ObtnerDatos).toList();
    }

    public Movimientos ObtenerMovimientosRecientes(Long id) {
        List<Object[]>  mov = movimientoRepository.obtenerMovimientosreciente(id);

        if(!mov.isEmpty()){
            return ObtnerDatos(mov.get(0));
        }
        return null;
    }


    public List<Movimientos> getAllMovimientos() {
        return movimientoRepository.findAll().stream().distinct().collect(Collectors.toList());
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

    private Movimientos ObtnerDatos(Object[] datos){
        Movimientos dto = new Movimientos();

        if (datos.length>0) dto.setDescripcion((String) datos[0]);

        if (datos.length>1) dto.setMonto((BigDecimal) datos[1]);
        if (datos.length>2 && datos[2] instanceof java.sql.Date){
            java.sql.Date fmovimiento = (java.sql.Date) datos[2];
            dto.setFechaMovimiento(fmovimiento.toLocalDate());
        }
        return dto;

    }


}
