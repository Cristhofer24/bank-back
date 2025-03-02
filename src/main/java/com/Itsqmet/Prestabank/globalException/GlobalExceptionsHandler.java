package com.Itsqmet.Prestabank.globalException;

import com.Itsqmet.Prestabank.exceptions.ClienteExceptions;
import com.Itsqmet.Prestabank.exceptions.CuentaException;
import com.Itsqmet.Prestabank.exceptions.MovimientoExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler {

        @ExceptionHandler(ClienteExceptions.class)
        public ResponseEntity<String> handleClienteNotFound(ClienteExceptions e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        @ExceptionHandler(CuentaException.class)
        public ResponseEntity<String> handleCuentaNotFound(CuentaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }


         @ExceptionHandler(MovimientoExceptions.class)
         public ResponseEntity<String> handleMovimientoNotFound(MovimientoExceptions e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }


    }


