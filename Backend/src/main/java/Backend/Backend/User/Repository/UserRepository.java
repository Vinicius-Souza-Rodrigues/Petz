package Backend.Backend.User.Repository;

import Backend.Backend.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByEmail(String email);

    @Query("SELECT uj.usuario FROM UserJuridico uj WHERE uj.cnpj = :cnpj")
    User findByCnpj(@Param("cnpj") String cnpj);

}
