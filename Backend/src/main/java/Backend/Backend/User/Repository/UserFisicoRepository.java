package Backend.Backend.User.Repository;

import Backend.Backend.User.Model.UserFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserFisicoRepository extends JpaRepository<UserFisico, UUID> {

    UserDetails findByCpf(String cpf);

    boolean existsByUsuario_Email(String email);
}


