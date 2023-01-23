package com.devsuperior.CRUD_de_clientes.services;

import com.devsuperior.CRUD_de_clientes.dto.ClientDto;
import com.devsuperior.CRUD_de_clientes.entities.Client;
import com.devsuperior.CRUD_de_clientes.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true) /*Busca paginada de clientes*/
    public Page<ClientDto> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDto(x));
    }

    @Transactional(readOnly = true) /*Inserção de novo cliente*/
    public ClientDto Insert(ClientDto dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDto(entity);

    }

    /*método para reaproveitamento de códigos*/
    private void copyDtoToEntity(ClientDto dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }


}
