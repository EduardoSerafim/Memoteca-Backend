package com.api.memotecabackend.dto;

import com.api.memotecabackend.model.Pensamento;

public record PensamentoDTO(
        Long id,
        String conteudo,
        String autoria,
        String modelo
) {
    public PensamentoDTO(Pensamento pensamento){
        this(pensamento.getId(), pensamento.getConteudo(), pensamento.getAutoria(), pensamento.getModelo());
    }
}
