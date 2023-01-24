package com.devsuperior.CRUD_de_clientes.controllers;


import com.devsuperior.CRUD_de_clientes.dto.ClientDto;
import com.devsuperior.CRUD_de_clientes.dto.CustomError;
import com.devsuperior.CRUD_de_clientes.services.ClientServices;
import com.devsuperior.CRUD_de_clientes.services.exception.DatabaseException;
import com.devsuperior.CRUD_de_clientes.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;

@RestController
@RequestMapping(value = "/clients")
public class ClientControllers {

    @Autowired
    private ClientServices service;

    @GetMapping(value = "/{id}") //Buscar por ID
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            ClientDto findbyid = service.findById(id);
            return ResponseEntity.ok(findbyid);
        } catch (ResourceNotFoundException e) {
            CustomError error = new CustomError(Instant.now(), 404, e.getMessage(), "caminho");
            return ResponseEntity.status(404).body(error);
        }

    }

    @GetMapping /*Busca paginada de clientes*/
    public ResponseEntity<Page<ClientDto>> findAll(Pageable pageable) {
        Page<ClientDto> findAllDto = service.findAll(pageable);
        return ResponseEntity.ok(findAllDto);

    }

    @PostMapping /*Inserção de novo cliente*/
    public ResponseEntity<ClientDto> insert(@RequestBody ClientDto insertDto) throws URISyntaxException {
        insertDto = service.Insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertDto.getId()).toUri();
        return ResponseEntity.created(uri).body(insertDto);
    }

    @PutMapping(value = "/{id}") /*Atualizar dados*/
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto updateDto) {
        updateDto = service.update(id, updateDto);
        return ResponseEntity.ok(updateDto);
    }

    @DeleteMapping(value = "/{id}") //Deletar dados no banco
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
