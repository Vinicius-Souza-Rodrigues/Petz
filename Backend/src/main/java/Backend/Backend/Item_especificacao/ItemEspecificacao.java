package Backend.Backend.Item_especificacao;

import Backend.Backend.Especificacao.Especificacao;
import Backend.Backend.PetsItens.PetsItens;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "item_especificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEspecificacao {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private PetsItens item;

    @ManyToOne
    @JoinColumn(name = "especificacao_id", nullable = false)
    private Especificacao especificacao;

    @Column(nullable = false)
    private String valor;
}
