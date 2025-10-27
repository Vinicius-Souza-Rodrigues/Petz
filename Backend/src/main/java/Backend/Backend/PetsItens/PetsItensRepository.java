package Backend.Backend.PetsItens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetsItensRepository extends JpaRepository<PetsItens, UUID> {
}
