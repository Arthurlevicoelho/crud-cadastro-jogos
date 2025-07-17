package colmeia.com.projeto_colmeia.model.entity;


import colmeia.com.projeto_colmeia.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "genero", schema = "colmeia")
@EqualsAndHashCode(of = "id", callSuper = false)
public class GeneroEntity extends BaseModel {

    @Column(nullable = false, name = "nome")
    String nome;
}
