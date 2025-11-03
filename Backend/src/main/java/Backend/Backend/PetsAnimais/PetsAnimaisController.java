package Backend.Backend.PetsAnimais;

import Backend.Backend.PetsAnimais.Dto.PetsAnimaisDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animais")
@RequiredArgsConstructor
public class PetsAnimaisController {

    private final PetsAnimaisService animaisService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody PetsAnimaisDto dto, @RequestHeader("Authorization") String authHeader) {
        System.out.println("teste");
        String token = authHeader.replace("Bearer ", "");

        String animal = animaisService.Adicionar(dto, token);
        return ResponseEntity.ok(animal);
    }


    @GetMapping("/listar")
    public ResponseEntity<String> produtos(){
        return ResponseEntity.ok("testado");
    }
}
