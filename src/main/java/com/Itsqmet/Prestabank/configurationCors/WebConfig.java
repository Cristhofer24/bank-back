package com.Itsqmet.Prestabank.configurationCors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Asegúrate de que este patrón cubra las rutas necesarias
                .allowedOrigins("http://localhost:4200") // La URL del frontend Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Los métodos permitidos
                .allowedHeaders("*") // Permitir cualquier encabezado
                .allowCredentials(true); // Permitir credenciales (cookies, cabeceras de autenticación, etc.)
    }


}
