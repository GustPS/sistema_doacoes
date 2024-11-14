package com.example.sistema_doacoes.controller;

import com.example.sistema_doacoes.dto.DoadorDto;
import com.example.sistema_doacoes.exception.ResourceNotFoundException;
import com.example.sistema_doacoes.model.Doador;
import com.example.sistema_doacoes.service.DoadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doadores")
@RequiredArgsConstructor
public class DoadorController {

    private final DoadorService doadorService;

    // Método para listar todos os doadores
    @GetMapping
    public ResponseEntity<List<DoadorDto>> getAllDoadores() {
        List<DoadorDto> doadores = doadorService.getAllDoadores();
        return ResponseEntity.ok(doadores);
    }

    // Método para buscar um doador pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<DoadorDto> getDoadorById(@PathVariable Long id) {
        try {
            DoadorDto doador = doadorService.getDoadorById(id);
            return ResponseEntity.ok(doador);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Método para inserir um novo doador
    @PostMapping
    public ResponseEntity<DoadorDto> createDoador(@RequestBody DoadorDto doadorDto) {
        Doador doador = doadorService.insertDoador(doadorDto);
        DoadorDto response = new DoadorDto(doador);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Método para atualizar um doador existente
    @PutMapping("/{id}")
    public ResponseEntity<DoadorDto> updateDoador(@PathVariable Long id, @RequestBody DoadorDto doadorDetails) {
        try {
            DoadorDto updatedDoador = doadorService.updateDoador(id, doadorDetails);
            return ResponseEntity.ok(updatedDoador);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Método para apagar um doador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoador(@PathVariable Long id) {
        try {
            doadorService.deleteDoador(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
