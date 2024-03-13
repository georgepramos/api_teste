package br.com.george.api.services;

import br.com.george.api.domain.Usuario;
import br.com.george.api.domain.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    Usuario findById(Integer id);

    List<Usuario> findAll();

    Usuario create(UsuarioDTO obj);

    Usuario update(UsuarioDTO obj);
}
