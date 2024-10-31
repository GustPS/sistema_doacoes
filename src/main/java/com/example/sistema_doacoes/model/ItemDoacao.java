package com.example.sistema_doacoes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "item_doacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemDoacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "categoria", length = 100)
    private String categoria;

    @ManyToMany(mappedBy = "itens", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Doacao> doacoes;
}
