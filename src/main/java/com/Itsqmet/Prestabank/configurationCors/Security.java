package com.Itsqmet.Prestabank.configurationCors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Orígenes permitidos (origen de tu frontend Angular)
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));

        // Métodos permitidos (GET, POST, PUT, DELETE, OPTIONS)
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Cabeceras permitidas (aquí puedes agregar más cabeceras si es necesario)
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        // Habilitar el envío de credenciales (si usas cookies, tokens, etc.)
        config.setAllowCredentials(true);

        // Registrar configuración de CORS para todas las rutas
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    // Configuración de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // Configura CORS usando el bean corsConfigurationSource
                .csrf(csrf -> csrf.disable())  // Deshabilita CSRF si no lo necesitas
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()
//                        .requestMatchers("/crypto/**").permitAll()  // Permite acceso a las rutas de la API sin autenticación
                        .anyRequest().authenticated()  // Requiere autenticación para otras rutas
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Usamos BCryptPasswordEncoder para la encriptación de contraseñas
        return new BCryptPasswordEncoder();
    }

}
