package Backend.Backend.PetsAnimais;

import Backend.Backend.PetsAnimais.Dto.AnimaisResponseDto;
import Backend.Backend.PetsAnimais.Dto.PetsAnimaisDto;
import Backend.Backend.PetsItens.PetsItens;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animais")
@RequiredArgsConstructor
public class PetsAnimaisController {

    private final PetsAnimaisService animaisService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody PetsAnimaisDto dto, @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");

        String animal = animaisService.adicionar(dto, token);
        return ResponseEntity.ok(animal);
    }

    @PostMapping("/favoritar/{animalId}")
    public ResponseEntity<String> favoritarAnimal(@PathVariable UUID animalId, @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");

        String favoritado = animaisService.favoritarAnimal(animalId, token);


        return ResponseEntity.ok(favoritado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AnimaisResponseDto>> listarAnimais() {
        List<AnimaisResponseDto> animais = animaisService.listar();
        return ResponseEntity.ok(animais);
    }
}
