package Backend.Backend.User;

import Backend.Backend.Auth.TokenService;
import Backend.Backend.User.Dto.LoginDto;
import Backend.Backend.User.Dto.RegisterDto;
import Backend.Backend.User.Model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDto request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.input(), request.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var user = (User) auth.getPrincipal();
        var token = tokenService.gerarToken(user);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto request) {
        String resultado;

        if ("fisico".equalsIgnoreCase(request.tipoUsuario())) {
            resultado = userService.registerFisico(request);
        } else if ("juridico".equalsIgnoreCase(request.tipoUsuario())) {
            resultado = userService.registerJuridico(request);
        } else {
            return ResponseEntity.badRequest().body("Tipo de usuario invalido!");
        }

        return ResponseEntity.ok(resultado);
    }
}
