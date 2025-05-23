package br.com.passGenerator.service;

import br.com.passGenerator.exception.AppException;
import br.com.passGenerator.model.dto.ItemDTO;
import br.com.passGenerator.model.entity.Item;
import br.com.passGenerator.model.entity.Usuario;
import br.com.passGenerator.model.repository.ItemRepository;
import br.com.passGenerator.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public void criar(ItemDTO dto) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = usuarioRepo.findByEmail(userEmail)
                .orElseThrow(() -> new AppException("Usuário não encontrado", 404));

        if (repo.findByNomeAndUsuario(dto.nome(), usuario).isPresent()) {
            throw new AppException("Item já existente para este usuário", 400);
        }

        Item item = new Item(dto.nome(), dto.senha(), usuario);
        repo.save(item);
    }

    public void deletar(Long id) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = usuarioRepo.findByEmail(userEmail)
                .orElseThrow(() -> new AppException("Usuário não encontrado", 404));

        Item item = repo.findById(id)
                .orElseThrow(() -> new AppException("Item não encontrado", 404));

        if (!item.getUsuario().equals(usuario)) {
            throw new AppException("Você não tem permissão para deletar este item", 403);
        }

        repo.deleteById(id);
    }

    public List<Item> listar() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = usuarioRepo.findByEmail(userEmail)
                .orElseThrow(() -> new AppException("Usuário não encontrado", 404));

        List<Item> itens = repo.findByUsuario(usuario);
        if (itens.isEmpty()) {
            throw new AppException("Nenhum item encontrado para este usuário", 404);
        }
        return itens;
    }
}
