package com.Itsqmet.Prestabank.controller;

import com.Itsqmet.Prestabank.exceptions.ClienteExceptions;
import com.Itsqmet.Prestabank.models.Clientes;
import com.Itsqmet.Prestabank.services.ClienteService;
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
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteservice;

    @PostMapping
    public ResponseEntity<Object> createCliente(@RequestBody Clientes clientes) {

            Clientes createCliente = clienteservice.create(clientes);
            Map<String, Object> response = new HashMap<>();
             response.put("clienteId", createCliente.getClienteId());
             response.put("message", "Cliente creado con éxito");
            return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

}
