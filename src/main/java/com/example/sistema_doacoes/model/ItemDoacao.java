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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Alterado para IDENTITY para auto incremento no banco
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "categoria", length = 100)
    private String categoria;

    @ManyToMany
    @JoinTable(
            name = "doacao_item", // Tabela de junção
            joinColumns = @JoinColumn(name = "item_doacao_id"), // Chave estrangeira para ItemDoacao
            inverseJoinColumns = @JoinColumn(name = "doacao_id") // Chave estrangeira para Doacao
    )
    private Set<Doacao> doacoes;

    // Método toString para facilitar a depuração
    @Override
    public String toString() {
        return "ItemDoacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
