package com.devsuperior.CRUD_de_clientes.dto;

import java.time.Instant;

public class CustomError {

    /*criando objetos que correspondem ao formato de erro
    "timestamp": "2023-01-23T14:07:08.149+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/atividade/7"
     */

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}