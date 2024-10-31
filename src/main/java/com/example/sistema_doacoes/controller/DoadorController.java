package com.example.sistema_doacoes.controller;

import com.example.sistema_doacoes.dto.DoadorDto;
import com.example.sistema_doacoes.model.Doador;
import com.example.sistema_doacoes.service.DoadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doador")
@RequiredArgsConstructor
@Slf4j
public class DoadorController {

    private final DoadorService doadorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Doador> getAllDoadores() {
        log.info("Buscando todos os doadores");
        return doadorService.getAllDoadores();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoadorDto createDoador(@RequestBody DoadorDto doadorDto) {
        log.info("Criando doador: {}");
        return doadorService.createDoador(doadorDto);
    }

    // Adicione outros métodos conforme necessário
}
