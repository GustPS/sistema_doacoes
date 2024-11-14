package com.example.sistema_doacoes.dto;

import com.example.sistema_doacoes.model.Doador;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoadorDto {

    private Long id;
    private String nome;
    private String email;
    private String contato;
    private String endereco;
    private String tipoDoacaoPreferido;
    private Set<Long> doacoesIds; // Se você quiser incluir apenas os IDs das doações, por exemplo

    public DoadorDto(Doador doador) {
        this.id = doador.getId();
        this.nome = doador.getNome();
        this.email = doador.getEmail();
        this.contato = doador.getContato();
        this.endereco = doador.getEndereco();
        this.tipoDoacaoPreferido = doador.getTipoDoacaoPreferido();
        if (doador.getDoacoes() != null) {
            this.doacoesIds = doador.getDoacoes().stream().map(doacao -> doacao.getId()).collect(Collectors.toSet());
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoDoacaoPreferido() {
        return tipoDoacaoPreferido;
    }

    public void setTipoDoacaoPreferido(String tipoDoacaoPreferido) {
        this.tipoDoacaoPreferido = tipoDoacaoPreferido;
    }

    public Set<Long> getDoacoesIds() {
        return doacoesIds;
    }

    public void setDoacoesIds(Set<Long> doacoesIds) {
        this.doacoesIds = doacoesIds;
    }
}
