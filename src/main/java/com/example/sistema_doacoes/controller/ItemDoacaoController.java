package com.example.sistema_doacoes.controller;

import com.example.sistema_doacoes.model.ItemDoacao;
import com.example.sistema_doacoes.service.ItemDoacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item-doacao")
@RequiredArgsConstructor
@Slf4j
public class ItemDoacaoController {

    private final ItemDoacaoService itemDoacaoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDoacao> getAllItens() {
        log.info("Buscando todos os itens de doação");
        return itemDoacaoService.getAllItens();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDoacao getItemById(@PathVariable Long id) {
        log.info("Buscando item de doação com ID: {}", id);
        return itemDoacaoService.getItemById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com ID: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDoacao insertItem(@RequestBody ItemDoacao item) {
        log.info("Inserindo novo item de doação: {}", item);
        return itemDoacaoService.insertItem(item);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDoacao updateItem(@PathVariable Long id, @RequestBody ItemDoacao itemDetails) {
        log.info("Atualizando item de doação com ID: {}", id);
        return itemDoacaoService.updateItem(id, itemDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        log.info("Apagando item de doação com ID: {}", id);
        itemDoacaoService.deleteItem(id);
    }
}
