package com.Itsqmet.Prestabank.controller;

import com.Itsqmet.Prestabank.models.Asesores;
import com.Itsqmet.Prestabank.models.Cuentas;
import com.Itsqmet.Prestabank.services.AsesorService;
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
@RequestMapping("/api/asesor")
public class AsesorController {
    @Autowired
    private AsesorService asesorService;

    @PostMapping
    public ResponseEntity<Object> createAsesor(@RequestBody Asesores asesores) {
        Asesores createAsesor = asesorService.create(asesores);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Asesor creado con éxito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
