package br.com.passGenerator.controller;


import br.com.passGenerator.model.dto.ItemDTO;
import br.com.passGenerator.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.passGenerator.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping
    public void criar(@RequestBody ItemDTO dto) {
        service.criar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/items")
    public List<Item> listar() {
        return service.listar();
    }
}