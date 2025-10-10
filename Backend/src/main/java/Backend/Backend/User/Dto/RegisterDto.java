package Backend.Backend.User.Dto;

import java.time.LocalDate;

public record RegisterDto(
        String email,
        String telefone,
        String celular,
        String senha,
        String confirmarSenha,
        String tipoUsuario,

        // Físico
        String nome,
        String genero,
        LocalDate dataNascimento,
        String cpf,

        // Jurídico
        String razaoSocial,
        String nomeContato,
        String cnpj

) {
}
