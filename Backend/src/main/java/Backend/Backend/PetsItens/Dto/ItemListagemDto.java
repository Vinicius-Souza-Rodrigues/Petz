package Backend.Backend.PetsItens.Dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemListagemDto(
        UUID id,
        String nome,
        String descricao,
        BigDecimal preco,
        String especificacoes
) {}
