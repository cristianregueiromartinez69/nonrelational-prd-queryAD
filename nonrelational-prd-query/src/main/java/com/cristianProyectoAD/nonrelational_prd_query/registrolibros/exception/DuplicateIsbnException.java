package com.cristianProyectoAD.nonrelational_prd_query.registrolibros.exception;

public class DuplicateIsbnException extends RuntimeException {
    public DuplicateIsbnException(String message) {
        super(message);
    }
}
