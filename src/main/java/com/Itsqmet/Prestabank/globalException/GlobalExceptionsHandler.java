package com.Itsqmet.Prestabank.globalException;

import com.Itsqmet.Prestabank.exceptions.ClienteExceptions;
import com.Itsqmet.Prestabank.exceptions.CuentaException;
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

        /*@ExceptionHandler(TransaccionNotFoundException.class)
        public ResponseEntity<String> handleTransaccionNotFound(TransaccionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }*/
    }


