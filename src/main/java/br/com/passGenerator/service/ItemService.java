package br.com.passGenerator.service;

import br.com.passGenerator.exception.AppException;
import br.com.passGenerator.model.dto.ItemDTO;
import br.com.passGenerator.model.entity.Item;
import br.com.passGenerator.model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repo;

    public void criar(ItemDTO dto) {
        if (repo.findByNome(dto.nome()).isPresent()) {
            throw new AppException("Item já existente", 400);
        }
        repo.save(new Item(null, dto.nome(), dto.senha()));
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) {
            throw new AppException("Item não encontrado", 404);
        }
        repo.deleteById(id);
    }

    public List<Item> listar() {
        return repo.findAll();
    }
}
