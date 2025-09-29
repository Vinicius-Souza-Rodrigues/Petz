package Backend.Backend.User;

import Backend.Backend.User.Dto.RegisterFisicoDto;
import Backend.Backend.User.Dto.RegisterJuridicoDto;
import Backend.Backend.User.Model.User;
import Backend.Backend.User.Model.UserFisico;
import Backend.Backend.User.Repository.UserFisicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private String password;

    private final UserFisicoRepository registerfisico;

    public String RegisterJuridico(RegisterJuridicoDto register) {

    }

    public String RegisterFisico(RegisterFisicoDto register) {
        if(registerfisico.existsByEmail(register.email()) ) {
            throw new RuntimeException("user ja existente!");
        }

        if (register.senha().equals(register.confirmarSenha())) {
            password = register.senha();
        } else {
            throw new RuntimeException("As senhas devemser iguais");
        }

        User user = new User();

        user.setCelular(register.celular());
        user.setSenha(password);
        user.setTelefone(register.telefone());
        user.setEmail(register.email());


        UserFisico userFisico = new UserFisico();

        userFisico.setCpf(register.cpf());
        userFisico.setNome(register.nome());
        userFisico.setGenero(register.genero());
        userFisico.setUsuario(user);

        registerfisico.save(userFisico);

        return "Usuario ta tudo certo";
    }
}
