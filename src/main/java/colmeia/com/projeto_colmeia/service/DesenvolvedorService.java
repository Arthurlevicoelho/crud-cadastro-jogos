package colmeia.com.projeto_colmeia.service;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.DesenvolvedorEntity;
import colmeia.com.projeto_colmeia.repository.DesenvolvedorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service

public class DesenvolvedorService extends BaseService<DesenvolvedorEntity, UUID>{

    private final DesenvolvedorRepository desenvolvedorRepository;

    public DesenvolvedorService(JpaRepository<DesenvolvedorEntity, UUID> repository, DesenvolvedorRepository desenvolvedorRepository) {
        super(repository);
        this.desenvolvedorRepository = desenvolvedorRepository;
    }

    public ResponseEntity<ResponseModel> save(DesenvolvedorEntity desenvolvedor) {
        if (desenvolvedor != null) {
            DesenvolvedorEntity desenvolvedorEntity = desenvolvedorRepository.getReferenceById(desenvolvedor.getId());

            if (desenvolvedorEntity == null) {

                desenvolvedorRepository.save(desenvolvedor);
                return ResponseEntity.ok().body(new ResponseModel(null, "Desenvolvedor cadastrado"));
            }else {
                return ResponseEntity.badRequest().body(new ResponseModel(null, "Desenvolvedor já cadastrado"));
            }
        }
        return ResponseEntity.badRequest().body(new ResponseModel(null, "Desenvolvedor inválido"));
    }

    public ResponseEntity<ResponseModel> put(DesenvolvedorEntity desenvolvedorEntity) {
        if (desenvolvedorEntity != null && desenvolvedorEntity.getId() != null) {
            DesenvolvedorEntity desenvolvedor = desenvolvedorRepository.getReferenceById(desenvolvedorEntity.getId());

            if (desenvolvedor == null) return ResponseEntity.badRequest().body(new ResponseModel(null, "Desenvolvedor não localizado"));
            if (desenvolvedor != null && !desenvolvedor.getNome().equals(desenvolvedorEntity.getNome())) return ResponseEntity.badRequest().body(new ResponseModel(null, "Nome do Desenvolvedor já utilizado"));

            desenvolvedorRepository.save(desenvolvedorEntity);

            return ResponseEntity.ok().body(new ResponseModel(null, "Desenvolvedor atualizado"));
        }

        return ResponseEntity.badRequest().body(new ResponseModel(null, "Desenvolvedor inválido"));
    }
}
