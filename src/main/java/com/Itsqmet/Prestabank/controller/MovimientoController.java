package com.Itsqmet.Prestabank.controller;

import com.Itsqmet.Prestabank.models.Clientes;
import com.Itsqmet.Prestabank.models.Cuentas;
import com.Itsqmet.Prestabank.models.DTOClienteCuenta;
import com.Itsqmet.Prestabank.models.Movimientos;
import com.Itsqmet.Prestabank.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/ObtenerMovimientos")
    public ResponseEntity<List<Movimientos>> ExtracciondeMovimientos(@RequestParam("id") Long id) {
        List<Movimientos> informacion = movimientoService.obtenerTodosMovimietos(id);
        return ResponseEntity.ok(informacion);
    }

    @GetMapping("/ObtenerMovimientoReciente")
    public ResponseEntity<Movimientos> MovimientoReciente(@RequestParam("id") Long id) {
        Movimientos movimiento = movimientoService.ObtenerMovimientosRecientes(id);
        return ResponseEntity.ok(movimiento);
    }

    @GetMapping("/all")

    public ResponseEntity<Object> getAllMovimientos() {

        List<Movimientos> movimientos = movimientoService.getAllMovimientos();
        return new ResponseEntity<>(movimientos, HttpStatus.OK);

    }



}
