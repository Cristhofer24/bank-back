package com.Itsqmet.Prestabank.controller;

import com.Itsqmet.Prestabank.models.Usuarios;
import com.Itsqmet.Prestabank.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/crear")
    public Usuarios createUser(@RequestBody Usuarios user) {
        return userServices.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        HashMap<String, Object> response = userServices.loginUser(username, password);

        return ResponseEntity.ok(response);
    }

}
