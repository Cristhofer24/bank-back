package com.Itsqmet.Prestabank.services;

import com.Itsqmet.Prestabank.models.Usuarios;
import com.Itsqmet.Prestabank.repository.UsuariosRepository;
import com.Itsqmet.Prestabank.rol.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios createUser(Usuarios user) {
     String encodedPassword = passwordEncoder.encode(user.getPassword());
     user.setPassword(encodedPassword);
     user.setRol(Roles.CLIENTE);
     return usuariosRepository.save(user);
    }

    public HashMap<String, Object> loginUser(String username, String password) {
        HashMap<String, Object> response = new HashMap<>();
        Usuarios user = usuariosRepository.findByUsername(username);

        if (user == null) {
            response.put("message", "Usuario no encontrado");
            return response;
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            response.put("message", "Contraseña incorrecta");
            return response;
        }

        response.put("message", "Login exitoso");
        response.put("role", user.getRol());

        if (user.getRol() == Roles.CLIENTE) {
            response.put("clienteId", user.getFkCliente());
        }

        return response;
    }








}
