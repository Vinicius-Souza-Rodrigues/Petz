package Backend.Backend.PetsAnimais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FavoritosRepository extends JpaRepository<FavoritosAnimais, UUID> {
}
