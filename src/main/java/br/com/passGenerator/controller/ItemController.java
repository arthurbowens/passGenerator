package br.com.passGenerator.controller;

import br.com.passGenerator.model.dto.ItemDTO;
import br.com.passGenerator.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.passGenerator.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody ItemDTO dto) {
        service.criar(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/todos")
    public ResponseEntity<Void> deletarTodos() {
        service.deletarTodos();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> listar() {
        List<Item> itens = service.listar();
        return ResponseEntity.ok(itens);
    }
}