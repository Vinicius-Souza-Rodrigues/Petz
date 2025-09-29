package Backend.Backend.User.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false, name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "celular")
    private String celular;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "confirmar_senha", nullable = false)
    private String confirmarSenha;

}
