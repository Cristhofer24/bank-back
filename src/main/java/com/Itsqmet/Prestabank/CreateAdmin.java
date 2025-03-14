package com.Itsqmet.Prestabank;

import com.Itsqmet.Prestabank.models.Usuarios;
import com.Itsqmet.Prestabank.repository.UsuariosRepository;
import com.Itsqmet.Prestabank.rol.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateAdmin implements CommandLineRunner {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Imprime un mensaje al inicio de la ejecución
        System.out.println("Iniciando el DataLoader...");

        // Verificar si ya existe un usuario administrador
        if (usuariosRepository.count() == 0) {
            // Si no existe, crear el usuario administrador
            Usuarios admin = new Usuarios();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRol(Roles.ADMINISTRADOR);
            admin.setFkCliente(null); // O el ID que prefieras
            usuariosRepository.save(admin);

            // Imprimir un mensaje indicando que se creó el usuario
            System.out.println("Usuario administrador creado con éxito.");
        } else {
            System.out.println("Ya existen usuarios en la base de datos.");
        }
    }
}
