package com.example.sistema_doacoes.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "doacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doador_id", nullable = false)
    private Doador doador;

    @ManyToOne
    @JoinColumn(name = "instituicao_id", nullable = false)
    private InstituicaoCaridade instituicao;

    @ManyToOne
    @JoinColumn(name = "item_id") // Associa um único item à doação
    private ItemDoacao item;

    @Column(name = "data_doacao", nullable = false)
    private LocalDate dataDoacao;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "campanha_id")
    private Campanha campanha;
}
