package br.com.passGenerator.model.repository;

import br.com.passGenerator.model.entity.Item;
import br.com.passGenerator.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByNome(String nome);
    Optional<Item> findByNomeAndUsuario(String nome, Usuario usuario);
    List<Item> findByUsuario(Usuario usuario);
}