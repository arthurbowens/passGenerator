package br.com.passGenerator.controller;

import br.com.passGenerator.model.dto.AuthDTO;
import br.com.passGenerator.model.dto.CadastroDTO;
import br.com.passGenerator.model.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.passGenerator.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/signin")
    public TokenDTO signin(@RequestBody AuthDTO dto) {
        return new TokenDTO(service.signin(dto));
    }

    @PostMapping("/signup")
    public void signup(@RequestBody CadastroDTO dto) {
        service.signup(dto);
    }
}