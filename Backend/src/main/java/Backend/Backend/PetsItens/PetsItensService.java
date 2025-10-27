package Backend.Backend.PetsItens;

import Backend.Backend.Especificacao.Dto.EspecificacaoDto;
import Backend.Backend.Especificacao.Especificacao;
import Backend.Backend.Item_especificacao.ItemEspecificacao;
import Backend.Backend.PetsItens.Dto.ItensDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetsItensService {

    private final PetsItensRepository repository;

    public String Adicionar(ItensDto dto) {
        try {
            PetsItens item = new PetsItens();
            item.setNome(dto.nome());
            item.setDescricao(dto.descricao());
            item.setPreco(dto.preco());

            List<ItemEspecificacao> itemEspecificacoes = new ArrayList<>();

            if (dto.especificacoes() != null) {
                for (EspecificacaoDto especDto : dto.especificacoes()) {
                    Especificacao espec = new Especificacao();
                    espec.setNome(especDto.nome());

                    ItemEspecificacao itemEspec = new ItemEspecificacao();
                    itemEspec.setEspecificacao(espec);
                    itemEspec.setValor(especDto.valor());
                    itemEspec.setItem(item);

                    itemEspecificacoes.add(itemEspec);
                }
            }

            item.setEspecificacoes(itemEspecificacoes);
            repository.save(item);

        } catch (RuntimeException exc) {
            return "Não foi possivel adicionar o item";
        }

        return "Item e especificações salvos com sucesso!";
    }
}
