package Backend.Backend.Especificacao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "especificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Especificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    private String nome;
}
