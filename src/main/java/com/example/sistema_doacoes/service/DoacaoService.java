package com.example.sistema_doacoes.service;

import com.example.sistema_doacoes.model.Doacao;
import com.example.sistema_doacoes.repository.DoacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoacaoService {
//
//    @Autowired
//    private DoacaoRepository doacaoRepository;
//
//    // Método para buscar todas as doações
//    public List<Doacao> getAllDoacoes() {
//        log.info("Buscando todas as doações");
//        return doacaoRepository.findAll();
//    }
//
//    // Método para buscar uma doação pelo ID
//    public Optional<Doacao> getDoacaoById(Long id) {
//        log.info("Buscando doação com ID: {}", id);
//        return doacaoRepository.findById(id);
//    }
//
//    // Método para inserir uma nova doação
//    public Doacao insertDoacao(Doacao doacao) {
//        log.info("Inserindo nova doação: {}", doacao);
//        return doacaoRepository.save(doacao);
//    }
//
//    // Método para editar uma doação existente
//    public Doacao updateDoacao(Long id, Doacao doacaoDetails) {
//        log.info("Atualizando doação com ID: {}", id);
//        Doacao doacao = doacaoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Doação não encontrada com ID: " + id));
//
//        // Atualiza os detalhes da doação
//        doacao.setDoador(doacaoDetails.getDoador());
//        doacao.setInstituicao(doacaoDetails.getInstituicao());
//        doacao.setItem(doacaoDetails.getItem());
//        doacao.setData(doacaoDetails.getData());
//        // Adicione outros campos conforme necessário
//
//        return doacaoRepository.save(doacao);
//    }
//
//    // Método para apagar uma doação
//    public void deleteDoacao(Long id) {
//        log.info("Apagando doação com ID: {}", id);
//        doacaoRepository.deleteById(id);
//    }
}
