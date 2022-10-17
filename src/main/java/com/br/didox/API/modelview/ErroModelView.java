package com.br.didox.API.modelview;

public class ErroModelView {
    public ErroModelView(String mensagem){
        this.mensagem = mensagem;
    }

    private String mensagem;
    public String getMensagem(){
        return this.mensagem;
    }
}
