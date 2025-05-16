package service;


import model.dto.ItemDTO;
import model.entity.Item;
import model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repo;

    public void criar(ItemDTO dto) {
        if (repo.findByNome(dto.nome()).isPresent()) {
            throw new RuntimeException("Item já existente");
        }
        repo.save(new Item(null, dto.nome(), dto.senha()));
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }

    public List<Item> listar() {
        return repo.findAll();
    }
}
