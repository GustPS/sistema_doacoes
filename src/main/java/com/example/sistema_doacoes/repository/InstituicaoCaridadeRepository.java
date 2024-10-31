package com.example.sistema_doacoes.repository;

import com.example.sistema_doacoes.model.InstituicaoCaridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoCaridadeRepository extends JpaRepository<InstituicaoCaridade, Long> {
}
