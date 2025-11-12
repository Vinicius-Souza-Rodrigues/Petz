package Backend.Backend.PetsItens.Dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ItensResponseDto(
        UUID id,
        String nome,
        String descricao,
        BigDecimal preco
)
{}
