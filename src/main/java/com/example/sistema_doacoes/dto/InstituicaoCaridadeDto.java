package com.example.sistema_doacoes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstituicaoCaridadeDto {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
}