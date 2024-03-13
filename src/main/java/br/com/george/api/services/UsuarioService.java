package br.com.george.api.services;

import br.com.george.api.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findById(Integer id);

    List<Usuario> findAll();
}
