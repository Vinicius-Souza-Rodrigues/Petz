package Backend.Backend.PetsItens;

import Backend.Backend.PetsItens.Dto.ItensDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class PetsItensController {

    public final PetsItensService petsItensService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody ItensDto request) {
        System.out.println(request);
        String resposta = petsItensService.Adicionar(request);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/listar")
    public ResponseEntity<String> produtos(){

        System.out.println("teste listar");

        return ResponseEntity.ok("testado");
    }
}
