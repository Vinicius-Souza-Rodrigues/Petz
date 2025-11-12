package Backend.Backend.PetsItens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FavoritosItemRepository extends JpaRepository<FavoritosItens, UUID> {
    Optional<FavoritosItens> findByUsuarioIdAndPetsItensId(UUID usuarioId, UUID PetsItens);
}
