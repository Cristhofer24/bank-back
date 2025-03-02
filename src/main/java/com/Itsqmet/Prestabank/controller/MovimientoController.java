package com.Itsqmet.Prestabank.controller;

import com.Itsqmet.Prestabank.models.Clientes;
import com.Itsqmet.Prestabank.models.Movimientos;
import com.Itsqmet.Prestabank.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<Object> createMovimiento(@RequestBody Movimientos movimientos) {
        Movimientos createMovimiento = movimientoService.create(movimientos);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "El movimiento a sido registrado satifactoriamente");
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }



}
