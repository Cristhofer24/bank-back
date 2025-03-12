package com.Itsqmet.Prestabank.services;

import com.Itsqmet.Prestabank.models.DTOClienteCuenta;
import com.Itsqmet.Prestabank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClienteCuentaServicesDTO {

    @Autowired
    private ClienteRepository clienteRepository;

    public DTOClienteCuenta EncontrarCuentaReciente(Long id) {
       List<Object[]>  datos = clienteRepository.EncontrarCuentaReciente(id);

       if(!datos.isEmpty()){
           return ObtnerDatos(datos.get(0));
       }
        return null;
    }

    //Extraccion de Datos

    private DTOClienteCuenta ObtnerDatos(Object[] datos){
        DTOClienteCuenta dto = new DTOClienteCuenta();

        if (datos.length>0) dto.setNumeroCuenta((String) datos[0]);
        if (datos.length>1) dto.setNombre((String) datos[1]);
        if (datos.length>2 && datos[2] instanceof java.sql.Date){
            java.sql.Date fcaducidad = (java.sql.Date) datos[2];
            dto.setFechaCaducidad(fcaducidad.toLocalDate());
        }
        if (datos.length>3) dto.setCedula((String) datos[3]);
        if (datos.length>4) dto.setSaldo((BigDecimal) datos[4]);
        if (datos.length>5) dto.setTipoCuenta((String) datos[5]);

        return dto;

    }





}
