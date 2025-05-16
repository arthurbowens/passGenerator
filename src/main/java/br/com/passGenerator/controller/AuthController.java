package br.com.passGenerator.controller;


import br.com.passGenerator.model.dto.AuthDTO;
import br.com.passGenerator.model.dto.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.passGenerator.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/signin")
    public String signin(@RequestBody AuthDTO dto) {
        return service.signin(dto);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody CadastroDTO dto) {
        service.signup(dto);
    }
}