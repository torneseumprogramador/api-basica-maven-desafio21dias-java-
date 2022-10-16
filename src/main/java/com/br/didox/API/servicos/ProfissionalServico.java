package com.br.didox.API.servicos;

import java.util.ArrayList;
import java.util.List;

import com.br.didox.API.models.Profissional;

public class ProfissionalServico {
    public static List<Profissional> profissionais(){
        var lista = new ArrayList<Profissional>();
        lista.add(new Profissional(1, "Walter"));
        lista.add(new Profissional(2, "Lena"));
        lista.add(new Profissional(3, "Felipe Amorim"));
        return lista;
    }
}
