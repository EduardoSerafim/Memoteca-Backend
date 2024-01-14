package com.api.memotecabackend.controllers;

import com.api.memotecabackend.dto.PensamentoDTO;
import com.api.memotecabackend.dto.PensamentoDTOPost;
import com.api.memotecabackend.model.Pensamento;
import com.api.memotecabackend.repository.PensamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pensamento")
public class PensamentoController {

    @Autowired
    private PensamentoRepository repository;

    List<Pensamento> list = List.of();



    @GetMapping
    public List<PensamentoDTO> getPensamento(){
        return repository.findAll().stream().map(PensamentoDTO::new).toList();
    }

    @GetMapping("/{id}")
    public PensamentoDTO getPensamentoById(@PathVariable Long id){
        return new PensamentoDTO(repository.getReferenceById(id));
    }

    @PostMapping
    public void postPensamento(@RequestBody PensamentoDTOPost pensamento ){
        Pensamento pensamentoEntity = new Pensamento(pensamento);
        repository.save(pensamentoEntity);
    }



}
