package com.api.memotecabackend.controllers;

import com.api.memotecabackend.model.Pensamento;
import com.api.memotecabackend.repository.PensamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API/pensamento")
public class PensamentoController {

    @Autowired
    private PensamentoRepository repository;

    List<Pensamento> list = List.of();



    @GetMapping
    public List<Pensamento> getPensamentos(){
        return repository.findAll();
    }

}
