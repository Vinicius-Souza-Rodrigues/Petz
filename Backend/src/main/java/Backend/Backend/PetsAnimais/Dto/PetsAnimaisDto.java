package Backend.Backend.PetsAnimais.Dto;

public record PetsAnimaisDto(
        String nome,
        String sexo,
        String porte,
        String peso,
        String idade,
        String microchip,
        String especie,
        String raca,
        String localizacao,
        String descricao
) {
}