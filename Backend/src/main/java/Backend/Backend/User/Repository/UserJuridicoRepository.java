package Backend.Backend.User.Repository;

import Backend.Backend.User.Model.UserJuridico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJuridicoRepository extends JpaRepository<UserJuridico, UUID> {

    @Query("""
        SELECT uf.usuario
        FROM UserJuridico uf
        WHERE uf.cnpj = :cnpj
    """)
    UserDetails findByCnpj(@Param("cnpj") String cnpj);

    Boolean existsByUsuario_Email(String email);

    Optional<UserJuridico> findByUsuarioId(UUID usuarioId);
}
