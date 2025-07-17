package colmeia.com.projeto_colmeia.model.entity;


import colmeia.com.projeto_colmeia.model.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jogo", schema = "colmeia")
@EqualsAndHashCode(of = "id", callSuper = false)
public class JogoEntity extends BaseModel {

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, columnDefinition = "text")
    private String descricao;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @Column(length = 255)
    private String website;

    @Column(name = "url_capa", length = 255)
    private String urlCapa;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "desenvolvedor_id", nullable = false)
    private DesenvolvedorEntity desenvolvedor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "genero_id", nullable = false)
    private GeneroEntity genero;

    @ManyToMany
    @JoinTable(
            schema = "colmeia",
            name = "jogo_console",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "console_id")
    )
    private List<ConsoleEntity> consoles;
}