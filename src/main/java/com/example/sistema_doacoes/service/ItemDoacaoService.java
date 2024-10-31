package com.example.sistema_doacoes.service;

import com.example.sistema_doacoes.model.ItemDoacao;
import com.example.sistema_doacoes.repository.ItemDoacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemDoacaoService {

    @Autowired
    private ItemDoacaoRepository itemDoacaoRepository;

    // Método para buscar todos os itens de doação
    public List<ItemDoacao> getAllItens() {
        log.info("Buscando todos os itens de doação");
        return itemDoacaoRepository.findAll();
    }

    // Método para buscar um item de doação pelo ID
    public Optional<ItemDoacao> getItemById(Long id) {
        log.info("Buscando item de doação com ID: {}", id);
        return itemDoacaoRepository.findById(id);
    }

    // Método para inserir um novo item de doação
    public ItemDoacao insertItem(ItemDoacao itemDoacao) {
        log.info("Inserindo novo item de doação: {}", itemDoacao);
        return itemDoacaoRepository.save(itemDoacao);
    }

    // Método para editar um item de doação existente
    public ItemDoacao updateItem(Long id, ItemDoacao itemDetails) {
        log.info("Atualizando item de doação com ID: {}", id);
        ItemDoacao itemDoacao = itemDoacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de doação não encontrado com ID: " + id));

        // Atualiza os detalhes do item
        itemDoacao.setNome(itemDetails.getNome());
        itemDoacao.setDescricao(itemDetails.getDescricao());
        // Adicione outros campos conforme necessário

        return itemDoacaoRepository.save(itemDoacao);
    }

    // Método para apagar um item de doação
    public void deleteItem(Long id) {
        log.info("Apagando item de doação com ID: {}", id);
        itemDoacaoRepository.deleteById(id);
    }
}
