package Backend.Backend.PetsItens;

import Backend.Backend.PetsItens.Dto.ItensDto;
import Backend.Backend.PetsItens.Dto.ItensResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class PetsItensController {

    public final PetsItensService itensService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody ItensDto request) {
        String resposta = itensService.adicionar(request);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/listar/descricao")
    public ResponseEntity<?> listarDetalhes() {
        return ResponseEntity.ok(itensService.listarDetalhes());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ItensResponseDto>> animais() {

        List<ItensResponseDto> itens = itensService.listar();

        return ResponseEntity.ok(itens);
    }

    @PostMapping("/favoritar/{itemId}")
    public ResponseEntity<String> favoritarItens(@PathVariable UUID itemId, @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");

        String favoritado = itensService.favoritarItem(itemId, token);

        return ResponseEntity.ok(favoritado);
    }
}
