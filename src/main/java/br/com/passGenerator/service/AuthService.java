package br.com.passGenerator.service;

import br.com.passGenerator.exception.AppException;
import br.com.passGenerator.model.dto.AuthDTO;
import br.com.passGenerator.model.dto.CadastroDTO;
import br.com.passGenerator.model.entity.Usuario;
import br.com.passGenerator.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class AuthService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TokenService tokenService;

    public String signin(AuthDTO dto) {
        Usuario usuario = usuarioRepo.findByEmail(dto.email())
                .orElseThrow(() -> new AppException("Credenciais inválidas", 401));

        if (!encoder.matches(dto.senha(), usuario.getSenha())) {
            throw new AppException("Credenciais inválidas", 401);
        }
        return tokenService.gerarToken(usuario);
    }

    public void signup(CadastroDTO dto) {
        if (!isValidEmail(dto.email())) {
            throw new AppException("Email inválido", 400);
        }
        if (usuarioRepo.findByEmail(dto.email()).isPresent()) {
            throw new AppException("Email já cadastrado", 400);
        }
        if (!dto.senha().equals(dto.confirmacaoSenha())) {
            throw new AppException("Senhas não conferem", 400);
        }
        Usuario user = new Usuario(null, dto.email(), dto.nome(), dto.dataNascimento(), encoder.encode(dto.senha()));
        usuarioRepo.save(user);
    }

    private boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}
