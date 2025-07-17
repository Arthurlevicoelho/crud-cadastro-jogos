package colmeia.com.projeto_colmeia.model.entity;

import colmeia.com.projeto_colmeia.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "desenvolvedor", schema = "colmeia")
@EqualsAndHashCode(of = "id", callSuper = false)
public class DesenvolvedorEntity extends BaseModel {

    @Column(nullable = false, name = "nome")
    String nome;

    @Column(nullable = false, name = "data_fundacao")
    Date dataFundacao;

    @Column(nullable = false, name = "website")
    String website;

    @Column(nullable = false, name = "sede")
    String sede;
}
