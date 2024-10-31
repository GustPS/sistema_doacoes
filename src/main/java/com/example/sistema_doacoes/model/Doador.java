package com.example.sistema_doacoes.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

@Entity
@Table(name = "doador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "contato", length = 100, nullable = false)
    private String contato;

    @Column(name = "endereco", length = 200)
    private String endereco;

    @Column(name = "tipo_doacao_preferido", length = 50)
    private String tipoDoacaoPreferido;

    @OneToMany(mappedBy = "doador", targetEntity = Doacao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Doacao> doacoes;
}