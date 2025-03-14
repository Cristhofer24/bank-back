package com.Itsqmet.Prestabank.controller;

import com.Itsqmet.Prestabank.models.DTOClienteCuenta;
import com.Itsqmet.Prestabank.services.ClienteCuentaServicesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clienteCuenta")
public class DTOCuentaClienteController {
    @Autowired
    private ClienteCuentaServicesDTO clienteCuentaServicesDTO;

    //Traer los DTO de las cuentas
    @GetMapping("/ObtenerCuentas")
    public ResponseEntity<DTOClienteCuenta> ExtraccionDatos(@RequestParam("id") Long id) {
        DTOClienteCuenta informacion = clienteCuentaServicesDTO.EncontrarCuentaReciente(id);
        return ResponseEntity.ok(informacion);
    }

    @GetMapping("/ObtenerCuentasTodos")
    public ResponseEntity<List<DTOClienteCuenta>> ExtraccionDatosTodos(@RequestParam("id") Long id) {
        List<DTOClienteCuenta> informacion = clienteCuentaServicesDTO.EncontrarCuentas(id);
        return ResponseEntity.ok(informacion);
    }


}
