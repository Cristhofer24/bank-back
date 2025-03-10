package com.Itsqmet.Prestabank.controller;

import com.Itsqmet.Prestabank.models.Clientes;
import com.Itsqmet.Prestabank.models.Cuentas;
import com.Itsqmet.Prestabank.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/Cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaservice;

    @GetMapping("/ObtenerValores")
    public String obtenerValores(@RequestParam String tipoCuenta) {
            Cuentas cuentas = cuentaservice.generarValores()

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



    @PostMapping
    public ResponseEntity<Object> createCuenta(@RequestBody Cuentas cuenta) {
        Cuentas createCuenta = cuentaservice.create(cuenta);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cuenta creada con éxito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }




}
