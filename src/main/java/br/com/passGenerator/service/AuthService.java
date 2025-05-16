package br.com.passGenerator.service;


import br.com.passGenerator.model.dto.AuthDTO;
import br.com.passGenerator.model.dto.CadastroDTO;
import br.com.passGenerator.model.entity.Usuario;
import br.com.passGenerator.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TokenService tokenService;

    public String signin(AuthDTO dto) {
        Usuario usuario = usuarioRepo.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));

        if (!encoder.matches(dto.senha(), usuario.getSenha())) {
            throw new RuntimeException("Credenciais inválidas");
        }
        return tokenService.gerarToken(usuario);
    }

    public void signup(CadastroDTO dto) {
        if (usuarioRepo.findByEmail(dto.email()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        if (!dto.senha().equals(dto.confirmacaoSenha())) {
            throw new RuntimeException("Senhas não conferem");
        }
        Usuario user = new Usuario(null, dto.email(), dto.nome(), dto.dataNascimento(), encoder.encode(dto.senha()));
        usuarioRepo.save(user);
    }
}
