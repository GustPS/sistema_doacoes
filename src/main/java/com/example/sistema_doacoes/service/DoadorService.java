package com.example.sistema_doacoes.service;

import com.example.sistema_doacoes.model.Doador;
import com.example.sistema_doacoes.repository.DoadorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoadorService {

    @Autowired
    private DoadorRepository doadorRepository;

    // Método para buscar todos os doadores
    public List<Doador> getAllDoadores() {
        log.info("Buscando todos os doadores");
        return doadorRepository.findAll();
    }

    // Método para buscar um doador pelo ID
    public Optional<Doador> getDoadorById(Long id) {
        log.info("Buscando doador com ID: {}", id);
        return doadorRepository.findById(id);
    }

    // Método para inserir um novo doador
    public Doador insertDoador(Doador doador) {
        log.info("Inserindo novo doador: {}", doador);
        return doadorRepository.save(doador);
    }

    // Método para editar um doador existente
    public Doador updateDoador(Long id, Doador doadorDetails) {
        log.info("Atualizando doador com ID: {}", id);
        Doador doador = doadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doador não encontrado com ID: " + id));

        // Atualiza os detalhes do doador
        doador.setNome(doadorDetails.getNome());
        doador.setEmail(doadorDetails.getEmail());
        // Adicione outros campos conforme necessário

        return doadorRepository.save(doador);
    }

    // Método para apagar um doador
    public void deleteDoador(Long id) {
        log.info("Apagando doador com ID: {}", id);
        doadorRepository.deleteById(id);
    }
}
