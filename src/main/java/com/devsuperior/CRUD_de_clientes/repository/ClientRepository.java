package com.devsuperior.CRUD_de_clientes.repository;

import com.devsuperior.CRUD_de_clientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}