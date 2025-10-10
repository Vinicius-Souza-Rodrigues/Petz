package Backend.Backend.User.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user_fisico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFisico {
    @Id
    @GeneratedValue
    private UUID usuarioid;

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private User usuario;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "genero")
    private String genero;

    @Column(name = "data_nascimento", nullable = false)
    private java.time.LocalDate data_nascimento;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

}
