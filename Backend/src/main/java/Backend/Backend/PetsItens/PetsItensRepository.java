package Backend.Backend.PetsItens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetsItensRepository extends JpaRepository<PetsItens, UUID> {

    @Query(value = """
        SELECT
            i.id,
            i.nome,
            i.descricao,
            i.preco,
            COALESCE(
                json_agg(
                    json_build_object(
                        'nome', e.nome,
                        'valor', ie.valor
                    )
                ) FILTER (WHERE e.id IS NOT NULL),
                '[]'
            ) AS especificacoes
        FROM item i
        LEFT JOIN item_especificacao ie ON i.id = ie.item_id
        LEFT JOIN especificacao e ON e.id = ie.especificacao_id
        GROUP BY i.id
        ORDER BY i.nome
        """, nativeQuery = true)
    List<Object[]> listarItensComEspecificacoes();
}
