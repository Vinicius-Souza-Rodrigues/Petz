package Backend.Backend.Especificacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EspecificacaoRepository extends JpaRepository<Especificacao, UUID> {
    Optional<Especificacao> findByNome(String nome);
}
