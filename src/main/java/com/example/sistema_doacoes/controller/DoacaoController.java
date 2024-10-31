package com.example.sistema_doacoes.controller;

import com.example.sistema_doacoes.model.Doacao;
import com.example.sistema_doacoes.service.DoacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doacao")
@RequiredArgsConstructor
@Slf4j
public class DoacaoController {
//
//    private final DoacaoService doacaoService;
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Doacao> getAllDoacoes() {
//        log.info("Buscando todas as doações");
//        return doacaoService.getAllDoacoes();
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Doacao getDoacaoById(@PathVariable Long id) {
//        log.info("Buscando doação com ID: {}", id);
//        return doacaoService.getDoacaoById(id)
//                .orElseThrow(() -> new RuntimeException("Doação não encontrada com ID: " + id));
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Doacao insertDoacao(@RequestBody Doacao doacao) {
//        log.info("Inserindo nova doação: {}", doacao);
//        return doacaoService.insertDoacao(doacao);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Doacao updateDoacao(@PathVariable Long id, @RequestBody Doacao doacaoDetails) {
//        log.info("Atualizando doação com ID: {}", id);
//        return doacaoService.updateDoacao(id, doacaoDetails);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteDoacao(@PathVariable Long id) {
//        log.info("Apagando doação com ID: {}", id);
//        doacaoService.deleteDoacao(id);
//    }
}
