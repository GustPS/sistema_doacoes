package com.example.sistema_doacoes.service;

import com.example.sistema_doacoes.model.Campanha;
import com.example.sistema_doacoes.repository.CampanhaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    // Método para buscar todas as campanhas
    public List<Campanha> getAllCampanhas() {
        log.info("Buscando todas as campanhas");
        return campanhaRepository.findAll();
    }

    // Método para buscar uma campanha pelo ID
    public Optional<Campanha> getCampanhaById(Long id) {
        log.info("Buscando campanha com ID: {}", id);
        return campanhaRepository.findById(id);
    }

    // Método para inserir uma nova campanha
    public Campanha insertCampanha(Campanha campanha) {
        log.info("Inserindo nova campanha: {}", campanha);
        return campanhaRepository.save(campanha);
    }

    // Método para editar uma campanha existente
    public Campanha updateCampanha(Long id, Campanha campanhaDetails) {
        log.info("Atualizando campanha com ID: {}", id);
        Campanha campanha = campanhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campanha não encontrada com ID: " + id));

        // Atualiza os detalhes da campanha
        campanha.setNome(campanhaDetails.getNome());
        campanha.setDescricao(campanhaDetails.getDescricao());
        campanha.setInstituicao(campanhaDetails.getInstituicao());
        campanha.setDataInicio(campanhaDetails.getDataInicio());
        campanha.setDataFim(campanhaDetails.getDataFim());
        // Adicione outros campos conforme necessário

        return campanhaRepository.save(campanha);
    }

    // Método para apagar uma campanha
    public void deleteCampanha(Long id) {
        log.info("Apagando campanha com ID: {}", id);
        campanhaRepository.deleteById(id);
    }
}
