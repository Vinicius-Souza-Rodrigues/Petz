package Backend.Backend.PetsAnimais;

import Backend.Backend.Auth.TokenService;
import Backend.Backend.PetsAnimais.Dto.PetsAnimaisDto;
import Backend.Backend.PetsItens.Dto.ItensDto;
import Backend.Backend.PetsItens.PetsItensRepository;
import Backend.Backend.User.Model.User;
import Backend.Backend.User.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetsAnimaisService {

    private final PetsAnimaisRepository petsAnimaisRepository;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Transactional
    public String Adicionar(PetsAnimaisDto dto, String token) {
        try {
            UUID usuarioId = tokenService.getUsuarioId(token);

            User usuario = userRepository.findById(usuarioId)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            PetsAnimais petsAnimais = new PetsAnimais();

            petsAnimais.setNome(dto.nome());
            petsAnimais.setIdade(dto.idade());
            petsAnimais.setEspecie(dto.especie());
            petsAnimais.setPeso(dto.peso());
            petsAnimais.setDescricao(dto.descricao());
            petsAnimais.setRaca(dto.raca());
            petsAnimais.setLocalizacao(dto.localizacao());
            petsAnimais.setMicrochip(dto.microchip());
            petsAnimais.setSexo(dto.sexo());
            petsAnimais.setPorte(dto.porte());
            petsAnimais.setUsuario(usuario);

            petsAnimaisRepository.save(petsAnimais);


        } catch (RuntimeException e) {
            throw new RuntimeException("Animal nao pode ser adicionado");
        }

        return "Deu certo, animal adicionado!";
    }
}
