package com.devsuperior.CRUD_de_clientes.controllers;


import com.devsuperior.CRUD_de_clientes.dto.ClientDto;
import com.devsuperior.CRUD_de_clientes.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientControllers {

    @Autowired
    private ClientServices service;

    @GetMapping(value = "/{id}") //Buscar por ID
    public ResponseEntity<ClientDto> findById(@PathVariable Long id) {

        ClientDto findbyid = service.findById(id);
        return ResponseEntity.ok(findbyid);

    }

    @GetMapping /*Busca paginada de clientes*/
    public ResponseEntity<Page<ClientDto>> findAll(Pageable pageable) {
        Page<ClientDto> findAllDto = service.findAll(pageable);
        return ResponseEntity.ok(findAllDto);

    }

    @PostMapping /*Inserção de novo cliente*/
    public ResponseEntity<ClientDto> insert(@RequestBody ClientDto insertDto) {
        insertDto = service.Insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertDto.getId()).toUri();
        return ResponseEntity.created(uri).body(insertDto);
    }


}
