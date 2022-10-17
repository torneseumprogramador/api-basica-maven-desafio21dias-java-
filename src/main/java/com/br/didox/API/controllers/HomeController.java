package com.br.didox.API.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.didox.API.modelview.Home;

@RestController
public class HomeController {
    @GetMapping("/")
    public Home index(){
        return new Home();
    }
}
