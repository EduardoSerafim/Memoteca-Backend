package com.api.memotecabackend.dto;

public record PensamentoDTO(
        Long id,
        String conteudo,
        String autoria,
        String modelo
) {
}
