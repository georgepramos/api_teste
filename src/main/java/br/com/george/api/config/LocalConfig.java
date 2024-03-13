package br.com.george.api.config;

import br.com.george.api.domain.Usuario;
import br.com.george.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public Void startBD(){
        Usuario u1 = new Usuario(null, "George Ramos","georgepramos@gmail.com","123456");
        Usuario u2 = new Usuario(null, "Sandra Serejo","serejo.sandra@gmail.com","654321");

        usuarioRepository.saveAll(Arrays.asList(u1,u2));

        return null;
    }
}
