package com.petz.api.exceptions;

public enum ServiceExceptionHandlerEnum {

    ERRO400("A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
    ERRO404("O recurso solicitado não existe ou não foi implementado"),
    ERRO405("Recurso com um método não suportado"),
    ERRO500("Ocorreu um erro no gateway da API ou no microsserviço");


    private final String description;

    ServiceExceptionHandlerEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
