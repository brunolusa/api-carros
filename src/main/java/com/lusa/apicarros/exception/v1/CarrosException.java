package com.lusa.apicarros.exception.v1;

public class CarrosException extends RuntimeException {

    private final String mensagem;

    public CarrosException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return mensagem;
    }

}
