package Backend.Backend.User.Dto;

import java.time.LocalDate;

public record RegisterFisicoDto(
        String nome,
        String email,
        String genero,
        LocalDate dataNascimento,
        String cpf,
        String telefone,
        String celular,
        String senha,
        String confirmarSenha,
        String tipoUsuario
) {
}
