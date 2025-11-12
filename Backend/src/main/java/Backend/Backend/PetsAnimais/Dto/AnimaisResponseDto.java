package Backend.Backend.PetsAnimais.Dto;

import java.util.UUID;

public record AnimaisResponseDto(
        UUID id,
        String nome,
        String sexo,
        String porte,
        String peso,
        String idade,
        String microchip,
        String especie,
        String raca,
        String localizacao,
        String descricao,
        UUID usuarioId
) {
}
