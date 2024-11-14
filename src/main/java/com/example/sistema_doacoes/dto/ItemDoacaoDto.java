package com.example.sistema_doacoes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDoacaoDto {
    private Long id;
    private String nome;
    private String descricao;
    private String categoria;
}
