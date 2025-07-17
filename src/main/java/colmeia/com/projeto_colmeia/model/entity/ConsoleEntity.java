package colmeia.com.projeto_colmeia.model.entity;

import colmeia.com.projeto_colmeia.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "console", schema = "colmeia")
@EqualsAndHashCode(of = "id", callSuper = false)
public class ConsoleEntity extends BaseModel {

    @Column(nullable = false, name = "nome")
    String nome;

    @Column(nullable = false, name = "data_lancamento")
    LocalDateTime dataLancamento;

    @Column(nullable = false, name = "empresa")
    String empresa;
}
