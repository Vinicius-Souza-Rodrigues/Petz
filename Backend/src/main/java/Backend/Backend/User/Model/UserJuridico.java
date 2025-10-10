package Backend.Backend.User.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user_juridico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserJuridico {

    @Id
    @GeneratedValue
    private UUID usuarioid;

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private User usuario;

    @Column(name = "razao_social")
    private String razao_social;

    @Column(name = "nome_contato")
    private String nome_contato;

    @Column(name = "cnpj")
    private String cnpj;
}
