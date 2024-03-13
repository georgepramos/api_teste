package br.com.george.api.controller;

import br.com.george.api.domain.dto.UsuarioDTO;
import br.com.george.api.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UsuarioDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        //List<Usuario> list = service.findAll();
        //List<UsuarioDTO> listDTO = list.stream().map(x -> mapper.map(x, UsuarioDTO.class)).collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(service.findAll()
                        .stream().map(x -> mapper.map(x, UsuarioDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO obj){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}").buildAndExpand(service.create(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
