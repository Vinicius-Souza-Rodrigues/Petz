package Backend.Backend.PetsItens;

import Backend.Backend.PetsAnimais.PetsAnimais;
import Backend.Backend.User.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "favoritos_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoritosItem {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private PetsItens petsItens;
}
