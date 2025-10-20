package Backend.Backend.User.Repository;

import Backend.Backend.User.Model.UserJuridico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJuridicoRepository extends JpaRepository<UserJuridico, UUID> {

    Boolean existsByUsuario_Email(String email);

    UserDetails findByCnpj(String cnpj);
}
