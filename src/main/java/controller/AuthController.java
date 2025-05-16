package controller;


import model.dto.AuthDTO;
import model.dto.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AuthService;

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