package Backend.Backend.PetsItens;

import Backend.Backend.Auth.TokenService;
import Backend.Backend.Especificacao.Dto.EspecificacaoDto;
import Backend.Backend.Especificacao.Especificacao;
import Backend.Backend.Especificacao.EspecificacaoRepository;
import Backend.Backend.Item_especificacao.ItemEspecificacao;
import Backend.Backend.PetsItens.Dto.ItemListagemDto;
import Backend.Backend.PetsItens.Dto.ItensDto;
import Backend.Backend.PetsItens.Dto.ItensResponseDto;
import Backend.Backend.User.Model.User;
import Backend.Backend.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetsItensService {

    private final PetsItensRepository petsItensRepository;
    private final EspecificacaoRepository especificacaoRepository;
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final FavoritosItemRepository favoritosItemRepository;

    @Transactional
    public String adicionar(ItensDto dto) {
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
            petsItensRepository.save(item);

        } catch (RuntimeException exc) {
            return "Não foi possível adicionar o item";
        }

        return "Item e especificações salvos com sucesso!";
    }

    public List<ItemListagemDto> listarDetalhes() {
        List<PetsItens> itens = petsItensRepository.findAll();
        List<ItemListagemDto> resposta = new ArrayList<>();

        for (PetsItens item : itens) {
            List<EspecificacaoDto> especificacoes = item.getEspecificacoes().stream()
                    .map(ie -> new EspecificacaoDto(
                            ie.getEspecificacao().getNome(),
                            ie.getValor()
                    ))
                    .toList();

            resposta.add(new ItemListagemDto(
                    item.getId(),
                    item.getNome(),
                    item.getDescricao(),
                    item.getPreco(),
                    especificacoes
            ));
        }

        return resposta;
    }

    public List<ItensResponseDto> listar() {
        List<ItensResponseDto> itens = petsItensRepository.findAll().stream()
                .map(item -> new ItensResponseDto(
                        item.getId(),
                        item.getNome(),
                        item.getDescricao(),
                        item.getPreco()
                ))
                .toList();

        return itens;
    }

    public String favoritarItem(UUID itemId, String token) {
        try {
            UUID usuarioId = tokenService.getUsuarioId(token);

            Optional<FavoritosItens> favoritoExistente = favoritosItemRepository.findByUsuarioIdAndPetsItensId(usuarioId, itemId);

            if (favoritoExistente.isPresent()) {
                favoritosItemRepository.delete(favoritoExistente.get());
                return "Item removido dos favoritos";
            }

            User usuario = userRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

            PetsItens item = petsItensRepository.findById(itemId)
                    .orElseThrow(() -> new RuntimeException("Item nao encontrado"));

            FavoritosItens novoFavorito = new FavoritosItens();
            novoFavorito.setUsuario(usuario);
            novoFavorito.setPetsItens(item);

            favoritosItemRepository.save(novoFavorito);
            return "Item adicionado aos favoritos!";

        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao favoritar item");
        }
    }
}
