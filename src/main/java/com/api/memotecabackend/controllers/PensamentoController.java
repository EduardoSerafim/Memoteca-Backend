package com.api.memotecabackend.controllers;

import com.api.memotecabackend.dto.PensamentoDTO;
import com.api.memotecabackend.dto.PensamentoDTOPost;
import com.api.memotecabackend.model.Pensamento;
import com.api.memotecabackend.repository.PensamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pensamento")
public class PensamentoController {

    @Autowired
    private PensamentoRepository repository;


    @GetMapping
    public ResponseEntity<List<PensamentoDTO> >getPensamento(){
        var pensamentos = repository.findAll().stream().map(PensamentoDTO::new).toList();
        return ResponseEntity.ok(pensamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PensamentoDTO> getPensamentoById(@PathVariable Long id){
        var pensamento = new PensamentoDTO(repository.getReferenceById(id));
        return ResponseEntity.ok(pensamento);
    }

    @PostMapping
    public ResponseEntity<PensamentoDTO> postPensamento(@RequestBody PensamentoDTOPost pensamento, UriComponentsBuilder uriComponentsBuilder){
        Pensamento pensamentoEntity = new Pensamento(pensamento);
        repository.save(pensamentoEntity);

        URI uri = uriComponentsBuilder.path("api/pensamento/{id}").buildAndExpand(pensamentoEntity.getId()).toUri();

        return ResponseEntity.created(uri).body(new PensamentoDTO(pensamentoEntity));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePensamento(@PathVariable Long id){
       repository.deleteById(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PensamentoDTO> updatePensamento(@PathVariable Long id, @RequestBody PensamentoDTO dto){
        var pensamento = repository.getReferenceById(id);
        pensamento.setConteudo(dto.conteudo());
        pensamento.setAutoria(dto.autoria());
        pensamento.setModelo(dto.modelo());

        pensamento = repository.save(pensamento);

        return ResponseEntity.ok(new PensamentoDTO(pensamento));

    }




}
