package com.br.didox.API.modelview;

public class Home {
    public String getMensagem(){
        return "Bem vindo a api feita no desafio 21 dias de java";
    }

    public String getDocumentacao(){
        return "/swagger-ui.html";
    }

    public String getSwaggerJson(){
        return "/v2/api-docs";
    }
}
