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
@Table(name = "usuario", schema = "colmeia")
@EqualsAndHashCode(of = "id", callSuper = false)
public class UsuarioEntity extends BaseModel {

    @Column(nullable = false, name = "nome")
    String nome;

    @Column(nullable = false, name = "email")
    String email;

    @Column(nullable = true, name = "telefone")
    String telefone;

    @Column(nullable = false, name = "cpf")
    String cpf;

    @Column(nullable = false, name = "senha")
    String senha;
}
