package com.demo.testeMutacao.exceptions;

public class NotaInvalidaException extends Exception {

    private final String mensagemError;

    public NotaInvalidaException(String mensagemError){
        super(mensagemError);
        this.mensagemError = mensagemError;
    }

    public String getMensagemError() {
        return mensagemError;
    }
}
