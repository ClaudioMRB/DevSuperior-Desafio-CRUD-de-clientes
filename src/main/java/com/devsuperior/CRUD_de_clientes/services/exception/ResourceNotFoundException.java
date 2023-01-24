package com.devsuperior.CRUD_de_clientes.services.exception;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String msg) {
        super(msg);
    }


}