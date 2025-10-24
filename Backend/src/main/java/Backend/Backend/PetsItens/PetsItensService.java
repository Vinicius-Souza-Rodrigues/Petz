package Backend.Backend.PetsItens;

import Backend.Backend.PetsItens.Dto.ItensDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetsItensService {

    public String Adicionar(ItensDto itens) {
        System.out.println(itens);

        PetsItens petsItens = new PetsItens();
        petsItens.setNome(itens.nome());
        petsItens.setDescricao(itens.descricao());
        petsItens.setPreco(itens.preco());

        PetsItensRepository.save(petsItens);
    }
}
