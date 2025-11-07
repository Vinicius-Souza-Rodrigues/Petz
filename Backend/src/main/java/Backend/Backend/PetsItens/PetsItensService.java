package Backend.Backend.PetsItens;

import Backend.Backend.Especificacao.Dto.EspecificacaoDto;
import Backend.Backend.Especificacao.Especificacao;
import Backend.Backend.Especificacao.EspecificacaoRepository;
import Backend.Backend.Item_especificacao.ItemEspecificacao;
import Backend.Backend.PetsItens.Dto.ItensDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PetsItensService {

    private final PetsItensRepository repository;
    private final EspecificacaoRepository especificacaoRepository;

    @Transactional
    public String Adicionar(ItensDto dto) {
        try {
            PetsItens item = new PetsItens();
            item.setNome(dto.nome());
            item.setDescricao(dto.descricao());
            item.setPreco(dto.preco());

            List<ItemEspecificacao> itemEspecificacoes = new ArrayList<>();

            if (dto.especificacoes() != null) {
                for (EspecificacaoDto especDto : dto.especificacoes()) {

                    Especificacao espec = especificacaoRepository
                            .findByNome(especDto.nome())
                            .orElseGet(() -> {
                                Especificacao nova = new Especificacao();
                                nova.setNome(especDto.nome());
                                return especificacaoRepository.save(nova);
                            });

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
            return "Não foi possível adicionar o item";
        }

        return "Item e especificações salvos com sucesso!";
    }

    public List<Map<String, Object>> Listar() {
        return repository.listarItensComEspecificacoes();
    }
}
