package Backend.Backend.PetsAnimais;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animais")
@RequiredArgsConstructor
public class PetsAnimaisController {

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar() {

        return ResponseEntity.ok("teste");
    }


    @GetMapping("/listar")
    public ResponseEntity<String> produtos(){
        return ResponseEntity.ok("testado");
    }
}
