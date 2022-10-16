package com.br.didox.API.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.didox.API.models.Profissional;
import com.br.didox.API.modelview.Home;
import com.br.didox.API.servicos.ProfissionalServico;

@RestController
public class HomeController {

    @GetMapping("/")
    public Home index(){
        return new Home();
    }

    @GetMapping("/profissionais")
    public List<Profissional> profissionais(){
        return ProfissionalServico.profissionais();
    }
    
}
