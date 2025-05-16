package model.dto;

import java.time.LocalDate;

public record CadastroDTO(String email, String nome, LocalDate dataNascimento, String senha, String confirmacaoSenha) {}
