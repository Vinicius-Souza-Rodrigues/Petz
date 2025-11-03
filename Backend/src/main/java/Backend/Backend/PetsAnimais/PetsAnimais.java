package Backend.Backend.PetsAnimais;

import Backend.Backend.User.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "animais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetsAnimais {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String sexo;
    private String porte;
    private String peso;
    private String idade;
    private String microchip;
    private String especie;
    private String raca;
    private String localizacao;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;
}
