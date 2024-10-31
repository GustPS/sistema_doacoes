package com.example.sistema_doacoes.controller;

import com.example.sistema_doacoes.model.Campanha;
import com.example.sistema_doacoes.service.CampanhaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campanha")
@RequiredArgsConstructor
@Slf4j
public class CampanhaController {

    private final CampanhaService campanhaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Campanha> getAllCampanhas() {
        log.info("Buscando todas as campanhas");
        return campanhaService.getAllCampanhas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Campanha getCampanhaById(@PathVariable Long id) {
        log.info("Buscando campanha com ID: {}", id);
        return campanhaService.getCampanhaById(id)
                .orElseThrow(() -> new RuntimeException("Campanha não encontrada com ID: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Campanha insertCampanha(@RequestBody Campanha campanha) {
        log.info("Inserindo nova campanha: {}", campanha);
        return campanhaService.insertCampanha(campanha);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Campanha updateCampanha(@PathVariable Long id, @RequestBody Campanha campanhaDetails) {
        log.info("Atualizando campanha com ID: {}", id);
        return campanhaService.updateCampanha(id, campanhaDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCampanha(@PathVariable Long id) {
        log.info("Apagando campanha com ID: {}", id);
        campanhaService.deleteCampanha(id);
    }
}
