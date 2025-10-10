package Backend.Backend.User;

import Backend.Backend.User.Dto.RegisterDto;
import Backend.Backend.User.Model.User;
import Backend.Backend.User.Model.UserFisico;
import Backend.Backend.User.Model.UserJuridico;
import Backend.Backend.User.Repository.UserFisicoRepository;
import Backend.Backend.User.Repository.UserJuridicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFisicoRepository userFisicoRepository;
    private final UserJuridicoRepository userJuridicoRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registerJuridico(RegisterDto register) {
        if (userJuridicoRepository.existsByUsuario_Email(register.email())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ja existente!");
        }

        if (!register.senha().equals(register.confirmarSenha())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "As senhas tem que ser iguais");
        }

        User user = new User();

        user.setCelular(register.celular());
        user.setTelefone(register.telefone());
        user.setEmail(register.email());
        user.setTipo_usuario(register.tipoUsuario());
        user.setSenha(passwordEncoder.encode(register.senha()));

        UserJuridico userJuridico = new UserJuridico();

        userJuridico.setUsuario(user);
        userJuridico.setCnpj(register.cnpj());
        userJuridico.setNome_contato(register.nomeContato());
        userJuridico.setRazao_social(register.razaoSocial());

        userJuridicoRepository.save(userJuridico);

        return "usuario juridico registrado com sucesso";
    }

    public String registerFisico(RegisterDto register) {
        if (userFisicoRepository.existsByUsuario_Email(register.email())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ja existente!");
        }

        if (!register.senha().equals(register.confirmarSenha())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "As senhas tem que ser iguais");
        }

        User user = new User();
        user.setCelular(register.celular());
        user.setTelefone(register.telefone());
        user.setEmail(register.email());
        user.setTipo_usuario(register.tipoUsuario());
        user.setSenha(passwordEncoder.encode(register.senha()));

        UserFisico userFisico = new UserFisico();
        userFisico.setCpf(register.cpf());
        userFisico.setNome(register.nome());
        userFisico.setData_nascimento(register.dataNascimento());
        userFisico.setGenero(register.genero());
        userFisico.setUsuario(user);

        userFisicoRepository.save(userFisico);

        return "Usuário físico registrado com sucesso!";
    }
}
