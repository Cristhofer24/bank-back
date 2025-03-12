package com.Itsqmet.Prestabank.services.components;

import org.springframework.stereotype.Component;

@Component
public class NumeroCuentaAleatorio {

    public String generarNumeroCuentaAleatoria(String tipoCuenta) {
        String prefijo = tipoCuenta.equalsIgnoreCase("CORRIENTE") ? "20" : "17";
        String numeroCuenta = prefijo + String.format("%06d",(int)(Math.random()*1000000));
        return numeroCuenta;
    }




}
