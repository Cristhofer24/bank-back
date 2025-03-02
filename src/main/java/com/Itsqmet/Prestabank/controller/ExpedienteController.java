package com.Itsqmet.Prestabank.controller;

import com.Itsqmet.Prestabank.models.Cuentas;
import com.Itsqmet.Prestabank.models.Expedientes;
import com.Itsqmet.Prestabank.services.ExpedienteService;
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
@RequestMapping("/api/expediente")
public class ExpedienteController {
    @Autowired
    private ExpedienteService expedienteService;

    @PostMapping
    public ResponseEntity<Object> createExpediente(@RequestBody Expedientes expedientes) {
        Expedientes createExpediente = expedienteService.create(expedientes);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Expediente Registrado");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
