package com.funeraria.exception;

public class EmailValidationException extends RuntimeException {

    public EmailValidationException() {
        super("El Email no tiene el formato correcto");

    }
}
