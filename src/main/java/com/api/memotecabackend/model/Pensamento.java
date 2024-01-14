package com.api.memotecabackend.model;

import com.api.memotecabackend.dto.PensamentoDTO;
import com.api.memotecabackend.dto.PensamentoDTOPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pensamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;
    private String autoria;
    private String modelo;


    public Pensamento(PensamentoDTOPost pensamento) {
        this.conteudo = pensamento.conteudo();
        this.autoria = pensamento.autoria();
        this.modelo = pensamento.modelo();
    }


}
