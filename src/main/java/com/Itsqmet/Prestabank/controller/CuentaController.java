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
    public ResponseEntity<Cuentas> generarValoresCuenta(@RequestParam String tipoCuenta) {
        Cuentas cuenta = new Cuentas();
        cuenta.setTipoCuenta(tipoCuenta);

        Clientes cliente = new Clientes();
        cuenta.setFkCliente(cliente);

        cuenta = cuentaservice.generarValores(cuenta);

        return ResponseEntity.ok(cuenta);
    }



    @PostMapping
    public ResponseEntity<Object> createCuenta(@RequestBody Cuentas cuenta) {
        Cuentas createCuenta = cuentaservice.create(cuenta);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cuenta creada con éxito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }




}
