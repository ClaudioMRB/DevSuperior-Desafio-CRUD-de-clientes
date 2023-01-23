package com.devsuperior.CRUD_de_clientes.services;

import com.devsuperior.CRUD_de_clientes.dto.ClientDto;
import com.devsuperior.CRUD_de_clientes.entities.Client;
import com.devsuperior.CRUD_de_clientes.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true) //Buscar por ID
    public ClientDto findById(Long id) {
        Optional<Client> result = repository.findById(id);
        Client ativ = result.get();
        ClientDto dto = new ClientDto(ativ);
        return dto;


    }


}
