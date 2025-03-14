package com.Itsqmet.Prestabank.controller;

import com.Itsqmet.Prestabank.models.Clientes;
import com.Itsqmet.Prestabank.models.Cuentas;
import com.Itsqmet.Prestabank.models.DTOClienteCuenta;
import com.Itsqmet.Prestabank.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cuentas")

public class CuentaController {

    @Autowired
    private CuentaService cuentaservice;

    @PostMapping
    public ResponseEntity<Object> createCuenta(@RequestBody Cuentas cuenta) {

        Cuentas createCuenta = cuentaservice.create(cuenta);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cuenta creada con éxito");


        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/ObtenerValores")
    public ResponseEntity<Object> generarValoresCuenta(@RequestParam("tipoCuenta") String tipoCuenta) {
        Cuentas cuenta = new Cuentas();
        cuenta.setTipoCuenta(tipoCuenta);
        cuenta = cuentaservice.generarValores(cuenta);

        return ResponseEntity.ok(cuenta);
    }

    @GetMapping("/all")

    public ResponseEntity<Object> getAllCuentas() {

        List<Cuentas> clientes = cuentaservice.getAllCuentas();
        return new ResponseEntity<>(clientes, HttpStatus.OK);

    }









}
