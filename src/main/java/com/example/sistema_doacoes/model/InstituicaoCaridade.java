package com.example.sistema_doacoes.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

@Entity
@Table(name = "instituicao_caridade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class InstituicaoCaridade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "localizacao", length = 200)
    private String localizacao;

    @Column(name = "contato", length = 100, nullable = false)
    private String contato;

    @OneToMany(mappedBy = "instituicao", targetEntity = Doacao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Doacao> doacoes;

    @OneToMany(mappedBy = "instituicao", targetEntity = Campanha.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Campanha> campanhas;
}
