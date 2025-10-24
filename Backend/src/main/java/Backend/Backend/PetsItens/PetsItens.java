package Backend.Backend.PetsItens;

import Backend.Backend.Item_especificacao.ItemEspecificacao;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetsItens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nome;

    private String descricao;

    private Double preco;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEspecificacao> especificacoes;
}
