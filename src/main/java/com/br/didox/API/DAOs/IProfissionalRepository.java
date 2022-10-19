package com.br.didox.API.DAOs;

import org.springframework.data.repository.CrudRepository;

import com.br.didox.API.models.Profissional;

public interface IProfissionalRepository extends CrudRepository<Profissional, Integer>  {
    
}
