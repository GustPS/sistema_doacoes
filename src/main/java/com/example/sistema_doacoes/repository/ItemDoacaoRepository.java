package com.example.sistema_doacoes.repository;

import com.example.sistema_doacoes.model.ItemDoacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDoacaoRepository extends JpaRepository<ItemDoacao, Long> {
}
