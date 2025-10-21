package Backend.Backend.User.Repository;

import Backend.Backend.User.Model.UserFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserFisicoRepository extends JpaRepository<UserFisico, UUID> {

    @Query("""
        SELECT uf.usuario
        FROM UserFisico uf
        WHERE uf.cpf = :cpf
    """)
    UserDetails findByCpf(@Param("cpf") String cpf);

    boolean existsByUsuario_Email(String email);
}


