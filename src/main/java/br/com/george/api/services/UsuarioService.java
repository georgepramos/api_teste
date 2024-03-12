package br.com.george.api.services;

import br.com.george.api.domain.Usuario;

public interface UsuarioService {

    Usuario findById(Integer id);
}
