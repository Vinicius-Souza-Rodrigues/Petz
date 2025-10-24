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
    public ResponseEntity<String> adicionar(@PathVariable ItensDto request) {



        return ResponseEntity.ok("adicionado");
    }

    @GetMapping("/listar")
    public ResponseEntity<String> produtos(){


        return ResponseEntity.ok("testado");
    }
}
