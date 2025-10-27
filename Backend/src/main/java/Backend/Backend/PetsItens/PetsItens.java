package Backend.Backend.PetsItens;

import Backend.Backend.Item_especificacao.ItemEspecificacao;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetsItens {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEspecificacao> especificacoes;
}
