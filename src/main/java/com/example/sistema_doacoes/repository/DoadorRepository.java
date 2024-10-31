package com.example.sistema_doacoes.repository;

import com.example.sistema_doacoes.model.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {
}
