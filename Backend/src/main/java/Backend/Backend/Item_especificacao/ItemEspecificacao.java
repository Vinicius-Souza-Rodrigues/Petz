package Backend.Backend.Item_especificacao;

import Backend.Backend.Especificacao.Especificacao;
import Backend.Backend.PetsItens.PetsItens;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item_especificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEspecificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private PetsItens item;

    @ManyToOne
    @JoinColumn(name = "especificacao_id", nullable = false)
    private Especificacao especificacao;

    @Column(nullable = false)
    private String valor;
}
