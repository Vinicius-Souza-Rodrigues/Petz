package Backend.Backend.User.Repository;

import Backend.Backend.User.Model.UserFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFisicoRepository extends JpaRepository<UserFisico, Long> {
    Boolean existsByEmail(String email);
}
