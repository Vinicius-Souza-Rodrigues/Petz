package Backend.Backend.User.Dto;

public record LoginDto(
        String email,
        String cnpj,
        String cpf,
        String senha
) {
}
