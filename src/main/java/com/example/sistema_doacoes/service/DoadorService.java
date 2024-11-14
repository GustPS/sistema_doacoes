package com.example.sistema_doacoes.service;

import com.example.sistema_doacoes.dto.DoadorDto;
import com.example.sistema_doacoes.exception.ResourceNotFoundException;
import com.example.sistema_doacoes.model.Doador;
import com.example.sistema_doacoes.repository.DoadorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoadorService {

    private final DoadorRepository doadorRepository;

    // Método para buscar todos os doadores
    public List<DoadorDto> getAllDoadores() {
        log.info("Buscando todos os doadores");
        List<Doador> doadores = doadorRepository.findAll();
        return doadores.stream()
                .map(doador -> new DoadorDto(doador)) // Convertendo Doador para DoadorDto
                .collect(Collectors.toList());
    }

    // Método para buscar um doador pelo ID
    public DoadorDto getDoadorById(Long id) throws ResourceNotFoundException {
        log.info("Buscando doador com ID: {}", id);
        Doador doador = doadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doador não encontrado com ID: " + id));
        return new DoadorDto(doador); // Convertendo Doador para DoadorDto
    }

    // Método para inserir um novo doador
    public Doador insertDoador(DoadorDto doadorDto) {
        log.info("Inserindo novo doador: {}", doadorDto);
        Doador doador = new Doador();
        doador.setNome(doadorDto.getNome());
        doador.setEmail(doadorDto.getEmail());
        doador.setContato(doadorDto.getContato());
        doador.setEndereco(doadorDto.getEndereco());
        doador.setTipoDoacaoPreferido(doadorDto.getTipoDoacaoPreferido());
        // Caso haja necessidade de inicializar o Set de Doações:
        doador.setDoacoes(Set.of());
        return doadorRepository.save(doador);
    }

    // Método para editar um doador existente
    public DoadorDto updateDoador(Long id, DoadorDto doadorDetails) throws ResourceNotFoundException {
        log.info("Atualizando doador com ID: {}", id);
        Doador doador = doadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doador não encontrado com ID: " + id));

        // Atualiza os detalhes do doador
        doador.setNome(doadorDetails.getNome());
        doador.setEmail(doadorDetails.getEmail());
        doador.setContato(doadorDetails.getContato());
        doador.setEndereco(doadorDetails.getEndereco());
        doador.setTipoDoacaoPreferido(doadorDetails.getTipoDoacaoPreferido());

        doadorRepository.save(doador); // Atualiza o doador no banco

        return new DoadorDto(doador); // Retorna o DoadorDto atualizado
    }

    // Método para apagar um doador
    public void deleteDoador(Long id) throws ResourceNotFoundException {
        log.info("Apagando doador com ID: {}", id);
        Doador doador = doadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doador não encontrado com ID: " + id));
        doadorRepository.delete(doador); // Deleta o doador do banco
    }
}
