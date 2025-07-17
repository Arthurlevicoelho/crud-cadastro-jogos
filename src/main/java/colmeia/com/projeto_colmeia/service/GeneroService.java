package colmeia.com.projeto_colmeia.service;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.GeneroEntity;
import colmeia.com.projeto_colmeia.repository.GeneroRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class GeneroService extends BaseService<GeneroEntity, UUID>{

    private final GeneroRepository generoRepository;

    public GeneroService(JpaRepository<GeneroEntity, UUID> repository, GeneroRepository generoRepository) {
        super(repository);
        this.generoRepository = generoRepository;
    }

    private ResponseEntity<ResponseModel> save(GeneroEntity genero) {
        if (genero != null) {
            GeneroEntity generoEntity = generoRepository.getReferenceById(genero.getId());

            if (generoEntity == null) {

                generoRepository.save(genero);
                return ResponseEntity.ok().body(new ResponseModel(null, "Genero cadastrado"));
            }else {
                return ResponseEntity.badRequest().body(new ResponseModel(null, "Genero já cadastrado"));
            }
        }
        return ResponseEntity.badRequest().body(new ResponseModel(null, "Genero inválido"));
    }
    public ResponseEntity<ResponseModel> put(GeneroEntity generoEntity) {
        if (generoEntity != null && generoEntity.getId() != null) {
            GeneroEntity genero = generoRepository.getReferenceById(generoEntity.getId());

            if (genero == null) return ResponseEntity.badRequest().body(new ResponseModel(null, "Genero não localizado"));
            if (genero != null && !genero.getNome().equals(genero.getNome())) return ResponseEntity.badRequest().body(new ResponseModel(null, "Nome do Genero já utilizado"));

            generoRepository.save(generoEntity);

            return ResponseEntity.ok().body(new ResponseModel(null, "Genero atualizado"));
        }

        return ResponseEntity.badRequest().body(new ResponseModel(null, "Genero inválido"));
    }
}
