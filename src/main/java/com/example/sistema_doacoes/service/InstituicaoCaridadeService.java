package com.example.sistema_doacoes.service;

import com.example.sistema_doacoes.model.InstituicaoCaridade;
import com.example.sistema_doacoes.repository.InstituicaoCaridadeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstituicaoCaridadeService {

    @Autowired
    private InstituicaoCaridadeRepository instituicaoCaridadeRepository;

    // Método para buscar todas as instituições de caridade
    public List<InstituicaoCaridade> getAllInstituicoes() {
        log.info("Buscando todas as instituições de caridade");
        return instituicaoCaridadeRepository.findAll();
    }

    // Método para buscar uma instituição de caridade pelo ID
    public Optional<InstituicaoCaridade> getInstituicaoById(Long id) {
        log.info("Buscando instituição de caridade com ID: {}", id);
        return instituicaoCaridadeRepository.findById(id);
    }

    // Método para inserir uma nova instituição de caridade
    public InstituicaoCaridade insertInstituicao(InstituicaoCaridade instituicaoCaridade) {
        log.info("Inserindo nova instituição de caridade: {}", instituicaoCaridade);
        return instituicaoCaridadeRepository.save(instituicaoCaridade);
    }

    // Método para editar uma instituição de caridade existente
    public InstituicaoCaridade updateInstituicao(Long id, InstituicaoCaridade instituicaoDetails) {
        log.info("Atualizando instituição de caridade com ID: {}", id);
        InstituicaoCaridade instituicaoCaridade = instituicaoCaridadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instituição de caridade não encontrada com ID: " + id));

        // Atualiza os detalhes da instituição
        instituicaoCaridade.setNome(instituicaoDetails.getNome());
        instituicaoCaridade.setCnpj(instituicaoDetails.getCnpj());
        // Adicione outros campos conforme necessário

        return instituicaoCaridadeRepository.save(instituicaoCaridade);
    }

    // Método para apagar uma instituição de caridade
    public void deleteInstituicao(Long id) {
        log.info("Apagando instituição de caridade com ID: {}", id);
        instituicaoCaridadeRepository.deleteById(id);
    }
}
