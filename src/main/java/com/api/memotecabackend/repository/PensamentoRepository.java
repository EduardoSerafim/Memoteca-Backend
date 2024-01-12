package com.api.memotecabackend.repository;

import com.api.memotecabackend.model.Pensamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PensamentoRepository extends JpaRepository<Pensamento, Long> {
}
