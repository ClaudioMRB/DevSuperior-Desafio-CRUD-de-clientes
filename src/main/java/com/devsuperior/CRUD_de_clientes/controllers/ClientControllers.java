package com.devsuperior.CRUD_de_clientes.controllers;


import com.devsuperior.CRUD_de_clientes.dto.ClientDto;
import com.devsuperior.CRUD_de_clientes.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
