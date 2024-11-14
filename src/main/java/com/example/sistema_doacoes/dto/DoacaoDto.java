package com.example.sistema_doacoes.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class DoacaoDto {
    private Long id;
    private Long doadorId;
    private Long instituicaoId;
    private LocalDate dataDoacao;
    private String descricao;
    private Double valor;
    private String campanha;
}
