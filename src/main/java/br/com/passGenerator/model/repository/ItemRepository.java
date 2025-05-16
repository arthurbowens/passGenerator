package br.com.passGenerator.model.repository;

import br.com.passGenerator.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByNome(String nome);
}