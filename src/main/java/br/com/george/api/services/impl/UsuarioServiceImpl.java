package br.com.george.api.services.impl;

import br.com.george.api.domain.Usuario;
import br.com.george.api.domain.dto.UsuarioDTO;
import br.com.george.api.repositories.UsuarioRepository;
import br.com.george.api.services.UsuarioService;
import br.com.george.api.services.exceptions.DataIntegratyViolationException;
import br.com.george.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario create(UsuarioDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Usuario.class));
    }

    private void findByEmail(UsuarioDTO obj){
        Optional<Usuario> usuario = repository.findByEmail(obj.getEmail());
        if(usuario.isPresent()){
            throw new DataIntegratyViolationException("Email já cadastrado no sistema.");
        }
    }
}
