package com.example.sistema_doacoes.controller;

import com.example.sistema_doacoes.model.InstituicaoCaridade;
import com.example.sistema_doacoes.service.InstituicaoCaridadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituicao")
@RequiredArgsConstructor
@Slf4j
public class InstituicaoCaridadeController {

    private final InstituicaoCaridadeService instituicaoCaridadeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InstituicaoCaridade> getAllInstituicoes() {
        log.info("Buscando todas as instituições de caridade");
        return instituicaoCaridadeService.getAllInstituicoes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstituicaoCaridade getInstituicaoById(@PathVariable Long id) {
        log.info("Buscando instituição com ID: {}", id);
        return instituicaoCaridadeService.getInstituicaoById(id)
                .orElseThrow(() -> new RuntimeException("Instituição não encontrada com ID: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstituicaoCaridade insertInstituicao(@RequestBody InstituicaoCaridade instituicao) {
        log.info("Inserindo nova instituição: {}", instituicao);
        return instituicaoCaridadeService.insertInstituicao(instituicao);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstituicaoCaridade updateInstituicao(@PathVariable Long id, @RequestBody InstituicaoCaridade instituicaoDetails) {
        log.info("Atualizando instituição com ID: {}", id);
        return instituicaoCaridadeService.updateInstituicao(id, instituicaoDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstituicao(@PathVariable Long id) {
        log.info("Apagando instituição com ID: {}", id);
        instituicaoCaridadeService.deleteInstituicao(id);
    }
}
