package colmeia.com.projeto_colmeia.service;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.JogoEntity;
import colmeia.com.projeto_colmeia.repository.JogoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JogoService extends BaseService<JogoEntity, UUID> {

    private final JogoRepository jogoRepository;

    public JogoService(JpaRepository<JogoEntity, UUID> repository, JogoRepository jogoRepository) {
        super(repository);
        this.jogoRepository = jogoRepository;
    }

    public ResponseEntity<ResponseModel> save(JogoEntity jogo) {
        if (jogo != null) {
            JogoEntity jogoEntity = jogoRepository.getReferenceById(jogo.getId());

            if (jogoEntity == null) {

                jogoRepository.save(jogo);
                return ResponseEntity.ok().body(new ResponseModel(null, "Jogo cadastrado"));
            }else {
                return ResponseEntity.badRequest().body(new ResponseModel(null, "Jogo já cadastrado"));
            }
        }
        return ResponseEntity.badRequest().body(new ResponseModel(null, "Jogo inválido"));
    }

    public ResponseEntity<ResponseModel> put(JogoEntity jogoEntity) {
        if (jogoEntity != null && jogoEntity.getId() != null) {
            JogoEntity jogo = jogoRepository.getReferenceById(jogoEntity.getId());

            if (jogo == null) return ResponseEntity.badRequest().body(new ResponseModel(null, "Jogo não localizado"));
            if (jogo != null && !jogo.getNome().equals(jogo.getNome())) return ResponseEntity.badRequest().body(new ResponseModel(null, "Nome do jogo já utilizado"));

            jogoRepository.save(jogoEntity);

            return ResponseEntity.ok().body(new ResponseModel(null, "Jogo atualizado"));
        }

        return ResponseEntity.badRequest().body(new ResponseModel(null, "Jogo inválido"));
    }
}
