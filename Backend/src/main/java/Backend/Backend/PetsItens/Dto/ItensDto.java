package Backend.Backend.PetsItens.Dto;

import Backend.Backend.Especificacao.Dto.EspecificacaoDto;

import java.math.BigDecimal;
import java.util.List;

public record ItensDto(
        String nome,
        String descricao,
        BigDecimal preco,
        List<EspecificacaoDto> especificacoes
) {}
