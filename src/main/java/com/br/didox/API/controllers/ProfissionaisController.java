package com.br.didox.API.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.didox.API.models.Profissional;
import com.br.didox.API.modelview.ErroModelView;
import com.br.didox.API.servicos.ProfissionalServico;

@RestController
@RequestMapping("/profissionais")
public class ProfissionaisController {
    @GetMapping
    public ResponseEntity<List<Profissional>> index(){
        var profissionais = ProfissionalServico.getInstancia().getProfissionais();
        return ResponseEntity.status(200).body(profissionais);
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody Profissional profissional){
        Profissional prof = ProfissionalServico.getInstancia().buscaPorId(profissional.getId());
        if(prof != null){
            return ResponseEntity.status(400).body(new ErroModelView("Profissional com o id (" + prof.getId() + ") já foi cadastrado"));
        }
        ProfissionalServico.getInstancia().adicionar(profissional);
        return ResponseEntity.status(201).body(profissional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterar(@PathVariable int id, @RequestBody Profissional profissional){
        var profissionais = ProfissionalServico.getInstancia().getProfissionais();
        Profissional prof = ProfissionalServico.getInstancia().buscaPorId(id);

        if(prof == null){
            return ResponseEntity.status(404).body(new ErroModelView("Profissional não encontrado"));
        }

        profissionais.remove(prof);

        ProfissionalServico.getInstancia().adicionar(profissional);
        return ResponseEntity.status(200).body(profissional);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> alterarParte(@PathVariable int id, @RequestBody Profissional profissional){
        Profissional prof = ProfissionalServico.getInstancia().buscaPorId(id);

        if(prof == null){
            return ResponseEntity.status(404).body(new ErroModelView("Profissional não encontrado"));
        }
        prof.setNome(profissional.getNome());
        return ResponseEntity.status(200).body(prof);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> mostrar(@PathVariable int id){
        Profissional profissional = ProfissionalServico.getInstancia().buscaPorId(id);

        if(profissional == null){
            return ResponseEntity.status(404).body(new ErroModelView("Profissional não encontrado"));
        }

        return ResponseEntity.status(200).body(profissional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id){
        Profissional profissional = ProfissionalServico.getInstancia().buscaPorId(id);

        if(profissional == null){
            return ResponseEntity.status(404).body(new ErroModelView("Profissional não encontrado"));
        }

        ProfissionalServico.getInstancia().getProfissionais().remove(profissional);

        return ResponseEntity.status(204).body("");
    }
}
